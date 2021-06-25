package com.qw4wer.spring.cloud.nacos.examples.provider.api;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.qw4wer.spring.cloud.nacos.examples.provider.config.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RefreshScope
public class SampleController {

    @Autowired
    UserConfig userConfig;

    @Autowired
    private NacosConfigManager nacosConfigManager;

    @Autowired
    private Environment environment;

    @Value("${user.name:zz}")
    String userName;

    @Value("${user.age:25}")
    Integer age;

    @Autowired
    private StreamBridge streamBridge;

    @RequestMapping("/user")
    public String simple() {
        return "Hello Nacos Config!" + "Hello " + userName + " " + age + " [UserConfig]: "
                + userConfig + "!" + nacosConfigManager.getConfigService();
    }

    @RequestMapping("/get/{name}")
    public String getValue(@PathVariable String name) {
        return String.valueOf(environment.getProperty(name));
    }

    @RequestMapping("/bool")
    public boolean bool() {
        return (Boolean) (userConfig.getMap().get("2"));
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello" + userName + age;
    }

    @RequestMapping("/pull")
    public String pull(){
        streamBridge.send("source2-out-0", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        return "done";
    }
}