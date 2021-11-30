package com.qw4wer.spring.cloud.nacos.examples.consumer.api;

import com.qw4wer.spring.cloud.nacos.examples.consumer.api.fallback.ProductClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * golang 服务提供
 */
@FeignClient(name = "demo.go", decode404 = true, fallbackFactory = ProductClientFallbackFactory.class)
public interface GolangClient {

    @GetMapping("/welcome")
    String welcome();

}
