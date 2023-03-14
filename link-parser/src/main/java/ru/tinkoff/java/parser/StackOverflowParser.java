package ru.tinkoff.java.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record StackOverflowParser() implements Parser {
    private static Parser nextParser;

    @Override
    public String parse(String url) {
        if (url.startsWith("https://stackoverflow.com")) {
            String patternString = "^https?://stackoverflow\\.com/questions/(\\d+)/";
            Matcher matcher = Pattern.compile(patternString).matcher(url);
            return matcher.find() ? matcher.group(1) : null;
        }
        return nextParser == null ? null : nextParser.parse(url);
    }

    @Override
    public void setNextParser(Parser next) {
        nextParser = next;
    }
}

