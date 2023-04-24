package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FormatterTest {
    @Test
    public void formatterExceptionTest() {
        Exception exception = assertThrows(IOException.class, () -> Formatter.formatStyle(List.of(), "java"));
        String expected = "Format java does not exist!";
        var actual = exception.getMessage().trim();
        Assertions.assertEquals(expected, actual);
    }
}
