package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Formatter {
    public static String formatStyle(List<Map<String, Object>> diffs, String format) throws IOException {
        switch (format) {
            case "stylish":
                return Stylish.formatStylish(diffs);
            case "plain":
                return Plain.formatPlain(diffs);
            case "json":
                return Json.formatJson(diffs);
            default:
                System.out.println("Format" + format + "is not correct!");
        }
        return Stylish.formatStylish(diffs);
    }
}
