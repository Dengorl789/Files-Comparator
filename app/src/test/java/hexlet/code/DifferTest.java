package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    private final String path1 = "src/test/resources/FirstFile.json";
    private final String path2 = "src/test/resources/SecondFile.json";
    private final String path3 = "src/test/resources/FirstFile.yml";
    private final String path4 = "src/test/resources/SecondFile.yml";
    private final int intNumber = 1;
    private final double doubleNumber = 0.5;


    private final Path pathStylish =
            Paths.get("src/test/resources/expected/testSTYLISH").toAbsolutePath().normalize();
    private final Path pathPlain =
            Paths.get("src/test/resources/expected/testPlain").toAbsolutePath().normalize();
    private final Path pathJson =
            Paths.get("src/test/resources/expected/testJSON").toAbsolutePath().normalize();

    @Test
    public void test1() throws Exception {
        String expected = Files.readString(pathStylish).trim();
        assertEquals(expected, Differ.generate(path1, path2).trim());
    }

    @Test
    public void testStylish1() throws Exception {
        String expected = Files.readString(pathStylish).trim();
        assertEquals(expected, Differ.generate(path1, path2, "stylish").trim());
    }

    @Test
    public void testStylish2() throws Exception {
        String expected = Files.readString(pathStylish).trim();
        assertEquals(expected, Differ.generate(path3, path4, "stylish").trim());
    }

    @Test
    public void testPlain1() throws Exception {
        String expected = Files.readString(pathPlain);
        assertEquals(expected, Differ.generate(path1, path2, "plain"));
    }

    @Test
    public void testPlain2() throws Exception {
        String expected = Files.readString(pathPlain);
        assertEquals(expected, Differ.generate(path3, path4, "plain"));
    }

    @Test
    public void testJson1() throws Exception {
        String expected = Files.readString(pathJson);
        assertEquals(expected, Differ.generate(path1, path2, "json"));
    }

    @Test
    public void testJson2() throws Exception {
        String expected = Files.readString(pathJson);
        assertEquals(expected, Differ.generate(path3, path4, "json"));
    }
    @Test
    public void getFileDataJsonTest() throws Exception {
        String path = "src/test/resources/testParser.json";
        var actualMap = Differ.getFileData(path);
        TreeMap<String, Object> expectedMap = new TreeMap<>();
        expectedMap.put("intKey", intNumber);
        expectedMap.put("charKey", 'a');
        expectedMap.put("stringKey", "abc");
        expectedMap.put("nullKey", null);
        expectedMap.put("doubleKey", doubleNumber);
        expectedMap.put("booleanKey", true);
        var actual = actualMap.toString();
        var expected = expectedMap.toString();
        assertEquals(expected, actual);
    }
    @Test
    public void getFileDataYmlTest() throws Exception {
        String path = "src/test/resources/testParser.yml";
        var actualMap = Differ.getFileData(path);
        TreeMap<String, Object> expectedMap = new TreeMap<>();
        expectedMap.put("intKey", intNumber);
        expectedMap.put("charKey", 'a');
        expectedMap.put("stringKey", "abc");
        expectedMap.put("nullKey", null);
        expectedMap.put("doubleKey", doubleNumber);
        expectedMap.put("booleanKey", true);
        var actual = actualMap.toString();
        var expected = expectedMap.toString();
        assertEquals(expected, actual);
    }
}
