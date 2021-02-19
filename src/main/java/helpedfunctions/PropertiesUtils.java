package helpedfunctions;

import java.util.ResourceBundle;

public class PropertiesUtils {

    public static String getProperties(String key) {

        ResourceBundle bundle = ResourceBundle.getBundle("config");
        return bundle.getString(key);
    }
}
