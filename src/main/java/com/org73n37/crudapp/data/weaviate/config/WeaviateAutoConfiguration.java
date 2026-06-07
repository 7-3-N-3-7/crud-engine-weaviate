package com.org73n37.crudapp.data.weaviate.config;

import io.weaviate.client.Config;
import io.weaviate.client.WeaviateClient;
import io.weaviate.client.v1.auth.Authentication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@ConditionalOnClass(WeaviateClient.class)
@EnableConfigurationProperties(WeaviateProperties.class)
public class WeaviateAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public WeaviateClient weaviateClient(WeaviateProperties properties) {
        Config config = new Config(properties.getScheme(), properties.getHost());
        if (properties.getApiKey() != null && !properties.getApiKey().isBlank()) {
            config.setAuthConfig(Authentication.apiKey(properties.getApiKey()));
        }
        return new WeaviateClient(config);
    }
}
