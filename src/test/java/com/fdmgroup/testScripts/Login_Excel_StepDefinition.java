package com.fdmgroup.testScripts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import com.fdmgroup.data.DriverSetUp;
import com.fdmgroup.pages.HomePage;
import com.fdmgroup.pages.SignInPage;
import com.fdmgroup.util.ExcelUtility;
import com.fdmgroup.util.FileConverter;
import com.fdmgroup.util.Hooks;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_Excel_StepDefinition extends DriverSetUp {

	@Given("User goes to website")
	public void user_goes_to_website() {
		Hooks.setUpBrowser();
		assertEquals(FileConverter.getProperty("homePageURL"), driver.getCurrentUrl());
	}

	@When("User attempts to sign in and provides an email  from given sheetname {string} and rowNumber {int}")
	public void user_attempts_to_sign_in_and_provides_an_email_from_given_sheetname_and_row_number(String SheetName,
			Integer RowNumber) throws Exception, Exception {

		HomePage.signInButton(driver).click();

		ExcelUtility reader = new ExcelUtility();
		List<Map<String, String>> testData = reader
				.getData("src\\test\\resources\\DataFiles\\Ebay_project_ExcelSheets.xlsx", SheetName);

		String email = testData.get(RowNumber).get("email");
		SignInPage.emailInputField(driver).sendKeys(email);
		SignInPage.submissionButton(driver).click();
		assertEquals(FileConverter.getProperty("signUpPageHeader"), SignInPage.signInPageHeader(driver).getText());
	}

	@Then("User should verify the error messages is incorrect")
	public void user_should_verify_the_error_messages_is_incorrect() {
		WebElement errorMessage = SignInPage.errorMessage(driver);
		assertTrue(errorMessage.isDisplayed());
	}
}
