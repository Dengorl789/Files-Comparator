package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.TreeMap;

public class Parser {
    public static TreeMap<String, Object> parser(String data, String fileType) throws IOException {
        ObjectMapper objectmapper = chooseFormat(fileType);
        return objectmapper.readValue(data, new TypeReference<>() { });
    }

    public static ObjectMapper chooseFormat(String fileType) {
        switch (fileType) {
            case("json"):
                return new ObjectMapper();
            case ("yml"):
                return new ObjectMapper(new YAMLFactory());
            default: throw new NoSuchElementException("There is no such filetype!");
        }



    }
}
