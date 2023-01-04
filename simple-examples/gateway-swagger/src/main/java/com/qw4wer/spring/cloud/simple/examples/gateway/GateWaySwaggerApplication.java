package com.qw4wer.spring.cloud.simple.examples.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@SpringBootApplication
public class GateWaySwaggerApplication {
    public static void main(String[] args) {
        SpringApplication.run(GateWaySwaggerApplication.class, args);
    }


    @Bean
    public BCryptPasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
