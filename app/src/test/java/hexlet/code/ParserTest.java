package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ParserTest {
    @Test
    public void chooseFormatTest() throws IOException {
        var actual = Parser.parser("data1", "json");

    }
}
