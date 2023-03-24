package ru.tinkoff.edu.java.scrapper.client.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ru.tinkoff.edu.java.scrapper.client.dto.StackOverflowQuestionResponse;

@Service
public class StackOverflowService {
    private static final String URI = "/questions/{id}";
    private final WebClient webClient;

    public StackOverflowService(@Qualifier("stackOverflowClient") WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<StackOverflowQuestionResponse> getQuestionById(int id) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(URI)
                        .queryParam("site", "stackoverflow")
                        .build(id))
                .retrieve()
                .bodyToMono(StackOverflowQuestionResponse.class);
    }
}
