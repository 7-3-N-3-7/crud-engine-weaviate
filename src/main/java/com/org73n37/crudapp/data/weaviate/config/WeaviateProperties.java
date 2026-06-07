package com.org73n37.crudapp.data.weaviate.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "crud.engine.weaviate")
public class WeaviateProperties {
    private String scheme = "http";
    private String host = "localhost:8080";
    private String apiKey;

    public String getScheme() { return scheme; }
    public void setScheme(String scheme) { this.scheme = scheme; }

    public String getHost() { return host; }
    public void setHost(String host) { this.host = host; }

    public String getApiKey() { return apiKey; }
    public void setApiKey(String apiKey) { this.apiKey = apiKey; }
}
