package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;

public class Differ {
    public static String generate(String pathToFile1, String pathToFile2, String format) throws Exception {
        Path writeFirstFilePath = Paths.get(pathToFile1);
        Path writeSecondFilePath = Paths.get(pathToFile2);

        // Создаём файл
        Path createdFirstFilePath;

        // Чтение файла:
        // Получаем путь к нужному файлу
        String readFilePath = "file1.json";

        // Формируем путь абсолютный путь,
        // если filePath будет содержать относительный путь,
        // то мы всегда будет работать с абсолютным
        Path firstPath = Paths.get(readFilePath).toAbsolutePath().normalize();


        // Проверяем существование файл

        // Читаем файл
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> firstFileContent = mapper.readValue(firstPath, new Differ());

        // Выводим содержимое
        System.out.println(firstFileContent);

        // Создание файла:
        // Получаем путь к нужному файлу


        // Создаём файл
        try {
            Path createdSecondFilePath = Files.createFile(writeSecondFilePath);
            System.out.println("Файл создан: " + createdSecondFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String readSecondFilePath = "file2.json";
        Path secondPath = Paths.get(readFilePath).toAbsolutePath().normalize();


        // Проверяем существование файла
        if (!Files.exists(secondPath)) {
            throw new Exception("File '" + secondPath + "' does not exist");
        }

        // Читаем файл
        Map<String, Object> secondFileContent = Files.lines(secondPath)
                .sorted()
                .collect(Collectors.toMap());

        // Выводим содержимое
        System.out.println(secondFileContent);


        return null;
    }
}
