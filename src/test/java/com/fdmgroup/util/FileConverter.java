package com.fdmgroup.util;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;


public class FileConverter {
	private static final String CONFIG_FILE_PATH = "src/test/resources/config.properties";
	private static Properties properties = new Properties();

	static {
		try (FileInputStream fileInputStream = new FileInputStream(CONFIG_FILE_PATH)) {
			properties.load(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
				}
	}

	public static String getProperty(String configPropertyVariable) {
		return properties.getProperty(configPropertyVariable);
	}
}