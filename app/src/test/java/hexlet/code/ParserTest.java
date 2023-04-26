package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParserTest {
    private final String path1 = "src/test/resources/testParser.json";
    private final String path2 = "src/test/resources/testParser.yml";
    private final Path pathParserJson = Paths.get(path1);
    private final Path pathParserYml = Paths.get(path2);
    private final String data1;
    private final String data2;
    private final int intNumber = 1;
    private final double doubleNumber = 0.5;

    {
        try {
            data1 = Files.readString(pathParserJson);
            data2 = Files.readString(pathParserYml);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void parserTestJson() throws IOException {
        var actual = Parser.parser(data1, "json");
        TreeMap<String, Object> expected = new TreeMap<>();
        expected.put("intKey", intNumber);
        expected.put("charKey", 'a');
        expected.put("stringKey", "abc");
        expected.put("nullKey", null);
        expected.put("doubleKey", doubleNumber);
        expected.put("booleanKey", true);
        var actualString = actual.toString();
        var expectedString = expected.toString();
        Assertions.assertEquals(expectedString, actualString);
    }
    @Test
    public void parserTestYml() throws IOException {
        var actual = Parser.parser(data2, "yml");
        TreeMap<String, Object> expected = new TreeMap<>();
        expected.put("intKey", intNumber);
        expected.put("charKey", 'a');
        expected.put("stringKey", "abc");
        expected.put("nullKey", null);
        expected.put("doubleKey", doubleNumber);
        expected.put("booleanKey", true);
        var actualString = actual.toString();
        var expectedString = expected.toString();
        Assertions.assertEquals(expectedString, actualString);
    }
    @Test
    public void chooseFormatTest1() {
        var expectedObj = new ObjectMapper();
        var actualObj = Parser.chooseFormat("json");
        var expected = expectedObj.getDateFormat();
        var actual = actualObj.getDateFormat();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void chooseFormatTest2() {
        var expectedObj = new ObjectMapper(new YAMLFactory());
        var actualObj = Parser.chooseFormat("yml");
        var expected = expectedObj.getDateFormat();
        var actual = actualObj.getDateFormat();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void chooseFormatTest3() {
        var expected = "There is no such filetype!";
        Exception exception = assertThrows(NoSuchElementException.class, () -> Parser.chooseFormat("java"));
        var actual = exception.getMessage();
        Assertions.assertEquals(expected, actual);
    }
}
