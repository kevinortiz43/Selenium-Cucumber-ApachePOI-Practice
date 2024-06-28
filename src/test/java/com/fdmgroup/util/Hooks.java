package com.fdmgroup.util;

import java.time.Duration; 

import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.fdmgroup.data.DriverSetUp;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;

public class Hooks extends DriverSetUp {

	@BeforeClass
	public static void setUpBrowser() {
		driverUtilities = DriverUtilities.getInstance();
		driver = driverUtilities.getDriver();
		js = driverUtilities.getJsExecutor();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.ebay.com");
	}

	@AfterAll
	public static void closeBrowser() {
		driver.quit();
	}

	@After
	public static void cucumberReportScreenshots(io.cucumber.java.Scenario sc) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
		sc.attach(screenshot, "image/png", "Cucumber screenshot report");
		driver.quit();
	}
}
