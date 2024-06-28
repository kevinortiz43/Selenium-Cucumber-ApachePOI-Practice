package com.fdmgroup.pages;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public static WebElement signInButton(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@_sp='m570.l1524']"));
	}

	public static WebElement dropDownMenu(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@name='_sacat']"));
	}

	public static WebElement advancedSearchButton(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@aria-label='Advanced Search']"));
	}

	public static WebElement contactUsButton(WebDriver driver) {
		return driver.findElement(By.xpath("//a[@_sp='m571.l2911']"));

	}

}
