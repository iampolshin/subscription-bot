package ru.tinkoff.java.parsers;

import ru.tinkoff.java.dto.UrlData;

public sealed abstract class AbstractParser permits GitHubParser, StackOverflowParser {
    protected AbstractParser nextParser;

    public abstract UrlData parse(String url);

    public static AbstractParser createParserChain() {
        AbstractParser gitHubParser = new GitHubParser();
        AbstractParser stackOverflowParser = new StackOverflowParser();
        gitHubParser.setNextParser(stackOverflowParser);
        return gitHubParser;
    }

    void setNextParser(AbstractParser nextParser) {
        this.nextParser = nextParser;
    }
}
