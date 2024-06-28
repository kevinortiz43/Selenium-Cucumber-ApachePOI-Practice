package com.fdmgroup.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdvancedSearchPage {

	public static WebElement keywordsInputField(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@data-testid='_nkw']"));
	}

	public static WebElement keywordsOptionsDropDown(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@name='_in_kw']"));
	}

	public static WebElement keywordsExclusionInputField(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@data-testid='_ex_kw']"));
	}

	public static WebElement categoriesDropDown(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@data-testid='s0-1-17-4[0]-7[3]-_sacat']"));
	}

	public static List<WebElement> buyingFormatRadioButtons(WebDriver driver) {
		return driver.findElements(By.xpath("//input[@data-radio='set-input' and @name='s0-1-17-6[3]']"));
	}

	public static List<WebElement> conditionRadioButtons(WebDriver driver) {
		return driver.findElements(By.xpath("//input[@class=\"radio__control\" and @value=\"LH_ItemCondition\"]"));
	}

	public static List<WebElement> showResults(WebDriver driver) {
		return driver
				.findElements(By.xpath("//input[@type='checkbox' and @class='checkbox__control' and @value='1' ]"));
	}

	public static List<WebElement> shippingOptions(WebDriver driver) {
		return driver
				.findElements(By.xpath("//input[@type='checkbox' and @class='checkbox__control' and @value='1' ]"));
	}

	public static List<WebElement> itemLocation(WebDriver driver) {
		return driver
				.findElements(By.xpath("//input[@type='radio' and @class='radio__control' and @value='LH_PrefLoc']"));
	}

	public static WebElement sortByDropDown(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@data-testid='s0-1-17-8[9]-1[0]-_sop']"));
	}

	public static WebElement viewResultsDropDown(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@data-testid='s0-1-17-8[9]-1[1]-_dmd']"));
	}

	public static WebElement ResultsPerPageDropDown(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@data-testid='s0-1-17-8[9]-1[1]-_dmd']"));
	}

	public static WebElement searchButton(WebDriver driver) {
		return driver.findElement(By.xpath("/html/body/div[2]/div/main/form/div[2]/button"));
	}

	public static WebElement itemResults(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@role='combobox']"));
	}

}
