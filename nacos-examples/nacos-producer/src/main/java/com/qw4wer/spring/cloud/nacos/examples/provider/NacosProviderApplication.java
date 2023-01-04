package com.qw4wer.spring.cloud.nacos.examples.provider;

import com.alibaba.nacos.api.config.annotation.NacosConfigListener;
import com.qw4wer.spring.cloud.nacos.examples.provider.config.UserConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class  NacosProviderApplication {


    public static void main(String[] args) {
        SpringApplication.run(NacosProviderApplication.class, args);
    }

    @Bean
    public UserConfig userConfig(){
        return new UserConfig();
    }

//    @NacosConfigListener(dataId = "nacos-provider.yaml")
//    public void onMessage(String msg){
//        System.out.println("配置变动"+msg);
//    }
}