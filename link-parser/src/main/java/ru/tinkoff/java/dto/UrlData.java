package ru.tinkoff.java.dto;

public sealed interface UrlData permits GitHubData, StackOverflowData {
}
