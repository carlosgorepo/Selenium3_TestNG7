package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    public static String getConfigValues(String param) throws IOException {
        FileInputStream file = new FileInputStream("./config/Config.properties");
        Properties properties = new Properties();
        properties.load(file);
        return properties.getProperty(param);
    }
}
