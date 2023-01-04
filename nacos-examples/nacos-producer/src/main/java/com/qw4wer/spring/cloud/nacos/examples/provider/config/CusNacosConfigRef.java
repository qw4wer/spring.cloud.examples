package com.qw4wer.spring.cloud.nacos.examples.provider.config;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Component
public class CusNacosConfigRef implements ApplicationListener<ApplicationReadyEvent>, ApplicationContextAware {

    private static final AtomicLong REFRESH_COUNT = new AtomicLong(0);


    private final ConfigService configService;

    private ApplicationContext applicationContext;

    private AtomicBoolean ready = new AtomicBoolean(false);

    private Map<String, Listener> listenerMap = new ConcurrentHashMap<>(16);

    Logger logger = LoggerFactory.getLogger(getClass());

    public CusNacosConfigRef(NacosConfigManager nacosConfigManager) {
        this.configService = nacosConfigManager.getConfigService();

    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        // many Spring context
        if (this.ready.compareAndSet(false, true)) {
            this.registerNacosListenersForApplications();
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    private void registerNacosListenersForApplications() {
        // 这个地方需要优化，改成配置形式，
        String dataId = "nacos-provider.yaml";
        registerNacosListener("DEFAULT_GROUP", dataId);
    }

    private void registerNacosListener(final String group, final String dataId) {

        Listener listener = listenerMap.computeIfAbsent(dataId, i -> new Listener() {
            @Override
            public void receiveConfigInfo(String configInfo) {
                refreshCountIncrement();
                // 推送配置修改事件
                applicationContext.publishEvent(new ConfigChangeEvent(this, dataId, configInfo));
                if (log.isInfoEnabled()) {
                    log.info("Refresh Nacos config group " + group + ",dataId" + dataId);
                }

                logger.info(configInfo);
            }

            @Override
            public Executor getExecutor() {
                return null;
            }
        });

        try {
            configService.addListener(dataId, group, listener);
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }

    public static long getRefreshCount() {
        return REFRESH_COUNT.get();
    }

    public static void refreshCountIncrement() {
        REFRESH_COUNT.incrementAndGet();
    }

}
