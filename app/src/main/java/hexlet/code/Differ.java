package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String pathfile1, String pathfile2, String format) throws Exception {
        Map<String, Object> map1 = getFileData(pathfile1);
        Map<String, Object> map2 = getFileData((pathfile2));

        List<Map<String, Object>> result = DifferenceFinder.differ(map1, map2);

        return Formatter.formatStyle(result, format);
    }
    public static String generate(String pathfile1, String pathfile2) throws Exception {
        return generate(pathfile1, pathfile2, "stylish");
    }
    public static Map<String, Object> getFileData(String pathToFile) throws Exception {
        Path path = Paths.get(pathToFile.substring(pathToFile.indexOf("src")));
        String fileData = Files.readString(path);
        String fileType = pathToFile.substring(pathToFile.indexOf(".") + 1);
        return Parser.parser(fileData, fileType);
    }
}
