package com.superb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author chao.gao
 */
@SpringBootApplication(scanBasePackages = "com.superb")
@MapperScan(basePackages = {"com.superb.mapper", "com.superb.config"})
@ComponentScan(basePackages = {"com.superb", "com.superb.config", "com.superb.config.interceptor", "com.superb.config.filter"})
public class StartApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }
}
