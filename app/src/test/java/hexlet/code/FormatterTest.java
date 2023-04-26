package hexlet.code;

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
        String actual = exception.getMessage().trim();
        Assertions.assertEquals(expected, actual);
    }
}
