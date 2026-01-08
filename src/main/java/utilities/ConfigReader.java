package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	static Properties prop ;
	static {
	try {
		
		String path="/home/tanguturisanjayk/eclipse-workspace/ecom-automation-suite/src/resources/config.properties";
		FileInputStream file= new FileInputStream(path);
		prop = new Properties();
		prop.load(file);
	}catch (IOException e) {
        e.printStackTrace();
        throw new RuntimeException("Failed to load config.properties file", e);
    }
	}
	public static String getproperty(String key) {
		return prop.getProperty(key);
		
	}
}

