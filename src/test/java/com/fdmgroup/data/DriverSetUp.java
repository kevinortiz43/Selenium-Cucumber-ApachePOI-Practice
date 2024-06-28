package com.fdmgroup.data;

import org.openqa.selenium.JavascriptExecutor;  
import org.openqa.selenium.WebDriver;

import com.fdmgroup.util.DriverUtilities;

public class DriverSetUp {
	protected static DriverUtilities driverUtilities;
	protected static WebDriver driver;
	protected static JavascriptExecutor js = (JavascriptExecutor) driver;
}
 