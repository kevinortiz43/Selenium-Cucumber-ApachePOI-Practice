package com.fdmgroup.util;

import java.io.FileInputStream; 
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverUtilities {

	private static DriverUtilities driverUtilities;
	private WebDriver driver;
	private JavascriptExecutor js;

	public static DriverUtilities getInstance() {
		if (driverUtilities == null) {
			driverUtilities = new DriverUtilities();
		}
		return driverUtilities;
	}

	private String getDriverName() {
		Properties config = new Properties();
		String driverName = "";
		try {
			config.load(new FileInputStream("src/test/resources/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (String key : config.stringPropertyNames()) {
			if (key.equals("browser")) {
				driverName = config.getProperty(key);
			}
		}
		return driverName;
	}

	private void createDriver() {
		String driverName = getDriverName();
		switch (driverName) {
		case "google chrome":
			this.driver = new ChromeDriver();
			this.js = (JavascriptExecutor) driver;
		}
	}

	public WebDriver getDriver() {
		if (driver == null) {
			createDriver();
		}
		return driver;
	}

	public JavascriptExecutor getJsExecutor() {
		return js;
	}
}