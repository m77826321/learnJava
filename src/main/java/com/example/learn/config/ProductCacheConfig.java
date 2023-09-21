package com.example.learn.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductCacheConfig {
    @Bean
    public Config cacheConfig() {
        return new Config()
                .setInstanceName("HAZEL-INSTANCE")
                .addMapConfig(new MapConfig()
                        .setName("product-cache")
                        .setTimeToLiveSeconds(31000));

    }
}
