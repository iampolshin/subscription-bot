import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.tinkoff.java.dto.UrlData;
import ru.tinkoff.java.parsers.AbstractParser;
import ru.tinkoff.java.parsers.GitHubParser;
import ru.tinkoff.java.parsers.StackOverflowParser;

public class ParserTest {
    @Test
    public void testGitHubParserWithValidLink() {
        String url = "https://github.com/iampolshin/java-tasks/blob/master/build.gradle";
        String expected = "GitHubRecord[username=iampolshin, repository=java-tasks]";
        AbstractParser gitHubParser = new GitHubParser();
        String result = String.valueOf(gitHubParser.parse(url));
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testStackOverflowParserWithValidLink() {
        String url = "https://stackoverflow.com/questions/1642028/what-is-the-operator-in-c";
        String expected = "StackOverflowRecord[id=1642028]";
        AbstractParser stackOverflowParser = new StackOverflowParser();
        String result = String.valueOf(stackOverflowParser.parse(url));
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testStackOverflowParserWithInvalidLink() {
        String url = "https://ficko.com/questions/1642028/what-is-the-operator-in-c";
        AbstractParser stackOverflowParser = new StackOverflowParser();
        UrlData result = stackOverflowParser.parse(url);
        Assertions.assertNull(result);
    }

    @Test
    public void testGitHubParserWithInvalidLink() {
        String url = "https://ficko.com/iampolshin/tinkoff-java-course-2077";
        AbstractParser gitHubParser = new GitHubParser();
        UrlData result = gitHubParser.parse(url);
        Assertions.assertNull(result);
    }

    @Test
    public void testChainOfResponsibilityWithValidLink() {
        String url = "https://stackoverflow.com/questions/1642028/what-is-the-operator-in-c";
        String expected = "StackOverflowRecord[id=1642028]";
        AbstractParser parser = AbstractParser.createParserChain();
        String result = String.valueOf(parser.parse(url));
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testChainOfResponsibilityWithInvalidLink() {
        String url = "https://tcsbank.ru/some-secrets";
        AbstractParser parser = AbstractParser.createParserChain();
        UrlData result = parser.parse(url);
        Assertions.assertNull(result);
    }
}
