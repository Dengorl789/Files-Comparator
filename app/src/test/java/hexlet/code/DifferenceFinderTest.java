package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class DifferenceFinderTest {
    public final Map<String, Object> map1 = Map.of(
            "intKey1", 1,
            "stringKey", "abc",
            "charKey", "a"
    );
    public final Map<String, Object> map2 = Map.of(
            "intKey2", 2,
            "stringKey", "cba",
            "charKey", "a"
    );

    @Test
    public void differenceFinderTest() {
        var actual = DifferenceFinder.differ(map1, map2);
        List<Map<String, Object>> expected = new ArrayList<>();
        Map<String, Object> firstMap = new LinkedHashMap<>();
        firstMap.put("key", "intKey1");
        firstMap.put("oldValue", map1.get("intKey1"));
        firstMap.put("status", "removed");
        Map<String, Object> secondMap = new LinkedHashMap<>();
        secondMap.put("key", "intKey2");
        secondMap.put("newValue", map2.get("intKey2"));
        secondMap.put("status", "added");
        Map<String, Object> thirdMap = new LinkedHashMap<>();
        thirdMap.put("key", "stringKey");
        thirdMap.put("oldValue", map1.get("stringKey"));
        thirdMap.put("newValue", map2.get("stringKey"));
        thirdMap.put("status", "updated");
        Map<String, Object> fourthMap = new LinkedHashMap<>();
        fourthMap.put("key", "charKey");
        fourthMap.put("oldValue", map1.get("charKey"));
        fourthMap.put("status", "unchanged");
        expected.add((fourthMap));
        expected.add(firstMap);
        expected.add(secondMap);
        expected.add(thirdMap);
        Assertions.assertEquals(expected, actual);
    }
}
