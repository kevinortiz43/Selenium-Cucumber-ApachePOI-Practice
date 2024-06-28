package com.fdmgroup.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUsPage {

	public static WebElement Header(WebDriver driver) {
		return driver.findElement(By.xpath("//h1[@id=\"srTil\"]"));
	}

}
