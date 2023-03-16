package ru.tinkoff.java.parsers;

public sealed abstract class AbstractParser implements Parser permits GitHubParser, StackOverflowParser {
    protected Parser nextParser;

    public void setNextParser(Parser nextParser) {
        this.nextParser = nextParser;
    }
}
