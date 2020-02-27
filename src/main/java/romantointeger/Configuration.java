package romantointeger;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class Configuration {
    public static final Map<String, Integer> ROMAN_TO_INTEGER_MAPPING = ImmutableMap.<String, Integer>builder()
            .put("I", 1)
            .put("V", 5)
            .put("X", 10)
            .put("L", 50)
            .put("C", 100)
            .put("D", 500)
            .put("M", 1000)
            .build();
}
