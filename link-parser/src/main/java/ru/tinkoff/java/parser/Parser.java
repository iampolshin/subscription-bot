package ru.tinkoff.java.parser;

public sealed interface Parser permits GitHubParser, StackOverflowParser {
    String parse(String url);

    void setNextParser(Parser nextParser);

    static Parser createParserChain() {
        Parser githubParser = new GitHubParser();
        Parser stackoverflowParser = new StackOverflowParser();
        githubParser.setNextParser(stackoverflowParser);
        return new GitHubParser();
    }
}
