package com.superb.controller.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

@Slf4j
@Aspect
@Component
public class ControllerAspect {


    /**
     * 对查询方法记录日志的切点
     */
    @Pointcut("execution(* com.superb.controller..*(..))")
    public void query() {
    }

    @Pointcut(value = "@annotation(com.superb.controller.aspect.SysLog)")
    public void sysLog() {

    }

//    @AfterReturning(value = "query()", returning = "rvt")
//    public void queryLog(JoinPoint joinPoint, Object rvt) {
//        log.info("切面---》？？？？？？？？？？？？？");
//        String className = joinPoint.getTarget().getClass().getName();
//        String methodName = joinPoint.getSignature().getName();
//        String returnResult = rvt.toString();
//        log.info("{},{},{}", className, methodName, returnResult);
//    }

//    @Before("query()")
//    public void addLog(JoinPoint joinPoint) {
//        log.info("进入切面》》》》》》》》》》》");
//        String className = joinPoint.getTarget().getClass().getName();
//        String methodName = joinPoint.getSignature().getName();
//        Object[] params = joinPoint.getArgs();
//        log.info("{},{},{}", className, methodName, Arrays.toString(params));
//    }

    @Before("sysLog()")
    public void saveLog(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        SysLog sysLog = method.getAnnotation(SysLog.class);
        if (!Objects.isNull(sysLog)) {
            log.info("进入注解切面。。。打印日志");
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            Object[] params = joinPoint.getArgs();

            log.info("{},{},{},{}", className, methodName, Arrays.toString(params), sysLog.value());
        }
    }

}
