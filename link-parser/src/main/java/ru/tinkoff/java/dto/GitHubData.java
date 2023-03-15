package ru.tinkoff.java.dto;

public record GitHubData(String username, String repository) implements UrlData {
}
