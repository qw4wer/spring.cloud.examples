package com.qw4wer.spring.cloud.nacos.examples.consumer.api.fallback;

import com.qw4wer.spring.cloud.nacos.examples.consumer.api.ProductClient;
import com.qw4wer.spring.cloud.nacos.examples.consumer.api.pojo.User;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ProductClientFallbackFactory implements FallbackFactory<ProductClient> {
    @Override
    public ProductClient create(Throwable cause) {
        return new ProductClient() {
            @Override
            public String hello() {
                return "error";
            }

            @Override
            public User post(User user) {
                return new User();
            }
        };
    }
}
