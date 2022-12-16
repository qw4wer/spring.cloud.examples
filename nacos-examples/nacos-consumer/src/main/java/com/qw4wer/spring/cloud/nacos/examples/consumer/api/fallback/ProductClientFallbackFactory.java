package com.qw4wer.spring.cloud.nacos.examples.consumer.api.fallback;

import com.qw4wer.spring.cloud.nacos.examples.common.RestResult;
import com.qw4wer.spring.cloud.nacos.examples.common.data.pojo.SysUser;
import com.qw4wer.spring.cloud.nacos.examples.consumer.api.ProductClient;
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
            public RestResult<SysUser> post(SysUser user) {
                return new RestResult();
            }
        };
    }
}
