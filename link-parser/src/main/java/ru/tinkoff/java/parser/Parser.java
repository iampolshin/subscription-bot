package ru.tinkoff.java.parser;

public sealed interface Parser permits GitHubParser, StackOverflowParser {
    String parse(String url);

    void setNextParser(Parser nextParser);
}
