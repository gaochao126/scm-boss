package com.superb.anno;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class StrategyFactory implements ApplicationContextAware {

    @Autowired
    private ApplicationContext applicationContext;

    public static Map<String, Class<IAnno>> strategyMap = new ConcurrentHashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    // 根据注解值，获取具体策略
    public IAnno getStrategy(String eventKey) {
        Class<IAnno> strategy = strategyMap.get(eventKey);

        if (Objects.isNull(strategy)) {
            return null;
        }

        return applicationContext.getBean(strategy);
    }

    @PostConstruct
    public void init() {
        //根据注解类型获取的对应的 bean名称 和 bean对象
        Map<String, Object> eventMap = applicationContext.getBeansWithAnnotation(Event.class);

        eventMap.forEach((k, v) -> {

            Class<IAnno> aClass = (Class<IAnno>) v.getClass();

            // 获取注解的值
            for (String s : aClass.getAnnotation(Event.class).value()) {
                strategyMap.put(s, aClass);
            }
        });
    }
}
