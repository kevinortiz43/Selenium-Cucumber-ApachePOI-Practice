package com.fdmgroup.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {

	public static WebElement emailInputField(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@autocomplete='username webauthn']"));
	}

	public static WebElement submissionButton(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@class='btn btn--fluid btn--large-truncated btn--primary']"));
	}

	public static WebElement errorMessage(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id='signin-error-msg']"));
	}

	public static WebElement signInPageHeader(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id='greeting-msg']"));
	}

}
