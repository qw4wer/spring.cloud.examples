package com.qw4wer.spring.cloud.nacos.examples.provider;

import com.qw4wer.spring.cloud.nacos.examples.provider.config.UserConfig;
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
}