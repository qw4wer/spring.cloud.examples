package com.qw4wer.spring.cloud.nacos.examples.consumer.api;


import com.qw4wer.spring.cloud.nacos.examples.consumer.api.fallback.ProductClientFallbackFactory;
import com.qw4wer.spring.cloud.nacos.examples.consumer.api.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "nacos-provider", decode404 = true,fallbackFactory = ProductClientFallbackFactory.class)
public interface ProductClient {

    @GetMapping("/hello")
    String hello();

    @PostMapping("/post")
    User post(User user);
}
