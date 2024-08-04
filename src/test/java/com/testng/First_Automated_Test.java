package com.testng;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.fdmgroup.data.DriverSetUp;
import com.fdmgroup.util.Hooks;

public class First_Automated_Test extends DriverSetUp{
	
	WebDriver driver;
	
	@BeforeClass()
	public void setUp() {
Hooks.setUpBrowserTestNG();

		
	}
	
	@Test
	public void testSimpleFormDemo() {
		driver.findElement(By.linkText("Simple Form Demo")).click();
		driver.findElement(By.xpath("//p[text()='Enter Message']//following-sibling::input")).sendKeys("Lambda 111");
		driver.findElement(By.id("showInput")).click();
		String actualMessage = 
		driver.findElement(By.id("message")).getText();
		Assert.assertEquals(actualMessage, "Lambda 1111","\n Message Is not Lambda 1111");
	}
	
	
	
	
	@AfterClass	
	public void tearDown() {
		driver.quit();
	}
	
	

}
