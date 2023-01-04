package com.qw4wer.spring.cloud.nacos.examples.provider.config;

import org.springframework.context.ApplicationEvent;

public class ConfigChangeEvent extends ApplicationEvent {
    String dataId;

    String content;

    public ConfigChangeEvent(Object source, String dataId, String content) {
        super(source);
        this.dataId = dataId;
        this.content = content;
    }
}
