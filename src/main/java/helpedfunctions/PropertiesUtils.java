package helpedfunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {

    public static Properties loadProperties(String propFilePath) throws IOException {
        Properties properties = new Properties();
        try (InputStream in = new FileInputStream(propFilePath)) {
            properties.load(in);
        }

        return properties;
    }
}
