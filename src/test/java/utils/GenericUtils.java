package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GenericUtils {
	
	public static String getPropertyValue(String filePath, String key) {
		FileInputStream fis;
		String value = null;
		try {
			fis = new FileInputStream(filePath);
			Properties prop = new Properties();
			prop.load(fis);
			value = prop.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
}
