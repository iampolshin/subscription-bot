package ru.tinkoff.java.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record GitHubParser() implements Parser {

    private static Parser nextParser;

    @Override
    public String parse(String url) {
        if (url.startsWith("https://github.com")) {
            String patternString = "^https?://github\\.com/([\\w-]+)/([\\w-]+)";
            Matcher matcher = Pattern.compile(patternString).matcher(url);
            return matcher.find() ? matcher.group(1) + "/" + matcher.group(2) : null;
        }
        return nextParser == null ? null : nextParser.parse(url);
    }

    @Override
    public void setNextParser(Parser next) {
        nextParser = next;
    }
}
