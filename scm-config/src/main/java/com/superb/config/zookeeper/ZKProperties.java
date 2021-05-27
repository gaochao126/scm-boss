package com.superb.config.zookeeper;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = ZKProperties.PREFIX)
@Component
public class ZKProperties {

    public static final String PREFIX = "spring.zookeeper";

    private String address;

    private int timeout;
}
