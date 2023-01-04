package com.qw4wer.spring.cloud.nacos.examples.provider.config;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ConfigEventListener implements ApplicationListener<ConfigChangeEvent> {

    JSONObject jsonObject;
    
    @Override
    public void onApplicationEvent(ConfigChangeEvent event) {
        Object source = event.getSource();
//        jsonObject = JSON.parseObject(event.content);
        log.info("收到事件推送 ===> {}", source.toString());
    }
}
