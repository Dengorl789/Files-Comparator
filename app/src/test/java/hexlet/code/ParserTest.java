package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class ParserTest {
    private final String path = "src/test/resources/expected/testParser.json";
    private final Path pathParser = Paths.get(path);
    private final String data;

    {
        try {
            data = Files.readString(pathParser);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void parserTest() throws IOException {
        var actual = Parser.parser(data, "json");
        TreeMap<String, Object> expected = new TreeMap<>();
        expected.put("intKey", 1);
        expected.put("charKey", 'a');
        expected.put("stringKey", "abc");
        expected.put("nullKey", null);
        expected.put("doubleKey", 0.5);
        expected.put("booleanKey", true);
        Assertions.assertEquals(expected, actual);
    }
}
