package com.sap.bulletinboard.ads.config;

import java.util.concurrent.TimeUnit;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    private static final int DEFAULT_MAX_TOTAL_CONNECTIONS = 500;
    private static final int DEFAULT_MAX_CONNECTIONS_PER_ROUTE = 100;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(getClientHttpRequestFactory());
    }

    private ClientHttpRequestFactory getClientHttpRequestFactory() {

        RequestConfig config = getRequestConfig();

        HttpClientBuilder clientBuilder = HttpClientBuilder.create();
        clientBuilder.setDefaultRequestConfig(config);

        clientBuilder.setProxy(config.getProxy());

        clientBuilder.setConnectionManager(getConnectionManager());
        // Optionally: setup background thread to close unused connections:
        clientBuilder.evictIdleConnections(15, TimeUnit.MINUTES);
        clientBuilder.evictExpiredConnections();

        CloseableHttpClient client = clientBuilder.build();

        // 1 client - n reused connections, per request a client contexts
        return new HttpComponentsClientHttpRequestFactory(client);
    }

    /*
     * Configures timeouts.
     * 
     * Timeout Properties Explained:
     * Connection Timeout
     *      the time to establish the connection with the target host 
     *      
     * Socket Timeout
     *      the time waiting for data – after the connection was established; 
     *      maximum time of inactivity between two data packets 
     * 
     * Connection Manager Timeout
     *      the time to wait for a connection from the connection manager/pool
     */
    private RequestConfig getRequestConfig() {
        RequestConfig.Builder requestConfigBuilder = RequestConfig.custom()
                .setConnectTimeout(3000)
                .setSocketTimeout(4000)
                .setConnectionRequestTimeout(2000);
        return requestConfigBuilder.build();
    }

    /*
     * Optimization: reuse connection to the same target host for subsequent requests.
     */
    private PoolingHttpClientConnectionManager getConnectionManager() {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();

        connectionManager.setMaxTotal(DEFAULT_MAX_TOTAL_CONNECTIONS);
        connectionManager.setDefaultMaxPerRoute(DEFAULT_MAX_CONNECTIONS_PER_ROUTE); // per target host

        return connectionManager;
    }
}