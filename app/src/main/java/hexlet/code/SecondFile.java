package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class SecondFile {
    public String host;
    public boolean follow;
    public String proxy;
    public int timeout;
    public boolean verbose;

    ObjectMapper mapper = new ObjectMapper();
    Map<String, Object> values = (Map<String, Object>) mapper.readValue(new File("file2.json"), SecondFile.class);

    public SecondFile() throws IOException {
    }
}
