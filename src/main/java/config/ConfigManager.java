package config;

import java.io.InputStream;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;

public class ConfigManager {

    private static final Map<String, Object> config;

    static  {
        Yaml yaml = new Yaml();

        InputStream inputStream= ConfigManager.class.getClassLoader()
                .getResourceAsStream("config/qaconfig.yaml");

        if(inputStream == null)
            throw new RuntimeException("Cannot find the config file");

        config= yaml.load(inputStream);

    }

    public static String getValue(String key) {
        if (key == null || config == null) {
            return null;
        }

        // Handle dot-notation for nested YAML blocks (e.g., "browser.name" or "ui.baseUrl")
        if (key.contains(".")) {
            String[] parts = key.split("\\.");
            Object current = config;

            for (String part : parts) {
                if (current instanceof Map) {
                    current = ((Map<String, Object>) current).get(part);
                } else {
                    return null;
                }
            }
            return current != null ? String.valueOf(current) : null;
        }

        Object value = config.get(key);
        return value != null ? String.valueOf(value) : null;
    }
}
