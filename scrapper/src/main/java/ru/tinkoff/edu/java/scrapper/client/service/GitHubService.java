package ru.tinkoff.edu.java.scrapper.client.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ru.tinkoff.edu.java.scrapper.client.dto.GitHubRepositoryResponse;

@Service
public class GitHubService {
    private final WebClient webClient;

    public GitHubService(@Qualifier("gitHubClient") WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<GitHubRepositoryResponse> getRepository(String owner, String repo) {
        return webClient.get()
                .uri("/repos/{owner}/{repo}", owner, repo)
                .retrieve()
                .bodyToMono(GitHubRepositoryResponse.class);
    }
}
