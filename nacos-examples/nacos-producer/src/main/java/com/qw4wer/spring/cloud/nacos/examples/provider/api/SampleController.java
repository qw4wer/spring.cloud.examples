package com.qw4wer.spring.cloud.nacos.examples.provider.api;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.qw4wer.spring.cloud.nacos.examples.provider.config.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.core.env.Environment;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

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
    public String pull() {
        for (int i = 0; i < 10; i++) {
            streamBridge.send("source2-out-0", MessageBuilder.withPayload(1).build());
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return "done";
    }

    @ResponseBody
    @RequestMapping("/post")
    public UserConfig.User post(@RequestBody UserConfig.User user) {
        user.setName(userName);
        return user;
    }
}