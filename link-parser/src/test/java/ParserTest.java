import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.tinkoff.java.parser.GitHubParser;
import ru.tinkoff.java.parser.Parser;
import ru.tinkoff.java.parser.StackOverflowParser;

public class ParserTest {
    @ParameterizedTest
    @CsvSource({"https://github.com/sanyarnd/tinkoff-java-course-2022/,sanyarnd/tinkoff-java-course-2022",
            "https://github.com/iampolshin/java-tasks/blob/master/build.gradle,iampolshin/java-tasks"})
    public void testGitHubParserWithValidLink(String url, String expected) {
        Parser githubParser = new GitHubParser();
        String result = githubParser.parse(url);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testStackOverflowParserWithValidLink() {
        String url = "https://stackoverflow.com/questions/1642028/what-is-the-operator-in-c";
        String expected = "1642028";
        Parser stackOverflowParser = new StackOverflowParser();
        String result = stackOverflowParser.parse(url);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testStackOverflowParserWithInvalidLink() {
        String url = "https://ficko.com/questions/1642028/what-is-the-operator-in-c";
        Parser stackOverflowParser = new StackOverflowParser();
        String result = stackOverflowParser.parse(url);
        Assertions.assertNull(result);
    }

    @Test
    public void testGitHubParserWithInvalidLink() {
        String url = "https://ficko.com/iampolshin/tinkoff-java-course-2077";
        Parser githubParser = new GitHubParser();
        String result = githubParser.parse(url);
        Assertions.assertNull(result);
    }

    @Test
    public void testChainOfResponsibilityWithValidLink() {
        String url = "https://stackoverflow.com/questions/1642028/what-is-the-operator-in-c";
        Parser githubParser = new GitHubParser();
        String expected = "1642028";
        githubParser.setNextParser(new StackOverflowParser());
        String result = githubParser.parse(url);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testChainOfResponsibilityWithInvalidLink() {
        String url = "https://tcsbank.ru/some-secrets";
        Parser githubParser = new GitHubParser();
        githubParser.setNextParser(new StackOverflowParser());
        String result = githubParser.parse(url);
        Assertions.assertNull(result);
    }
}
