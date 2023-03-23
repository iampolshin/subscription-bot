package ru.tinkoff.edu.java.scrapper.client.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import ru.tinkoff.edu.java.scrapper.configuration.ApplicationConfig;

@Configuration
public class ClientConfiguration {
    @Value("${client.base-url.github}")
    private static String githubBaseUrl;
    @Value("${client.base-url.stackoverflow}")
    private static String stackOverflowBaseUrl;

    @Bean("gitHubClient")
    public WebClient gitHubClient() {
        return WebClient.builder()
                .baseUrl(githubBaseUrl)
                .build();
    }

    @Bean("stackOverflowClient")
    public WebClient stackOverflowClient() {
        return WebClient.builder()
                .baseUrl(stackOverflowBaseUrl)
                .build();
    }

    @Bean
    public long schedulerIntervalMs(ApplicationConfig config) {
        return config.scheduler().interval().toMillis();
    }
}
