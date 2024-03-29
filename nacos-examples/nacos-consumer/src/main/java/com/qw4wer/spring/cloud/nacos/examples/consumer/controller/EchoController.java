package com.qw4wer.spring.cloud.nacos.examples.consumer.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.qw4wer.spring.cloud.nacos.examples.common.RestResult;
import com.qw4wer.spring.cloud.nacos.examples.common.data.pojo.SysUser;
import com.qw4wer.spring.cloud.nacos.examples.consumer.api.GolangClient;
import com.qw4wer.spring.cloud.nacos.examples.consumer.api.ProductClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class EchoController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ProductClient productClient;

    private final GolangClient golangClient;

    public EchoController(ProductClient productClient, GolangClient golangClient) {
        this.productClient = productClient;
        this.golangClient = golangClient;
    }

    @NacosValue(value = "${service.name:1}", autoRefreshed = true)
    private String serverName;

    @GetMapping("/callHello")
    public String callHello() {
        logger.info("you are calling hello");
        return productClient.hello();
    }

    @GetMapping("/callWelcome")
    public String callWelcome() {
        logger.info("you are calling welcome");
        return golangClient.welcome();
    }

    @PostMapping("/callPost")
    @ResponseBody
    public RestResult<SysUser> callPost(@RequestBody SysUser sysUser, HttpServletRequest request) {

        logger.info("you are calling post");
        RestResult<SysUser> post = productClient.post(sysUser);
        System.out.println(post);
        return post;
    }
}
