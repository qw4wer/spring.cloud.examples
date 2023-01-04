package com.qw4wer.spring.cloud.simple.examples.gateway.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "HelloController")
@RestController
public class HelloController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @Operation(summary = "接口方法描述")
    public String hello() {
        return "hello";
    }

}
