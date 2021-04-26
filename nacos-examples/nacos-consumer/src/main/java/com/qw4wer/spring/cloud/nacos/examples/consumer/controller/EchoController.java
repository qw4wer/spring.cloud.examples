package com.qw4wer.spring.cloud.nacos.examples.consumer.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.qw4wer.spring.cloud.nacos.examples.consumer.api.ProductClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ProductClient productClient;

    public EchoController(ProductClient productClient) {
        this.productClient = productClient;
    }

    @NacosValue(value = "${service.name:1}", autoRefreshed = true)
    private String serverName;

    @GetMapping("/callHello")
    public String callHello() {
        logger.info("you are calling hello");
        return productClient.hello();
    }
}
