//package com.fdmgroup.testScripts;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
//import org.openqa.selenium.WebElement;
//
//import com.fdmgroup.data.DriverSetUp;
//import com.fdmgroup.pages.HomePage;
//import com.fdmgroup.pages.SignInPage;
//import com.fdmgroup.util.FileConverter;
//import com.fdmgroup.util.Hooks;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class LoginStepDefinition extends DriverSetUp {
//
//	@Given("User goes to website")
//	public void user_attempts_to_log_in() {
//		Hooks.setUpBrowser();
//		assertEquals(FileConverter.getProperty("homePageURL"), driver.getCurrentUrl());
//	}
//
//	@When("User attempts to sign in and provides an invalid {string}")
//	public void user_attempts_to_sign_in_and_provides_an_invalid(String email) {
//			HomePage.signInButton(driver).click();
//			SignInPage.emailInputField(driver).sendKeys(email);
//			SignInPage.submissionButton(driver).click();
//			assertEquals(FileConverter.getProperty("signUpPageHeader"), SignInPage.signInPageHeader(driver).getText());
//		}
//	
//
//	@Then("User should verify the error messages is incorrect")
//	public void user_should_verify_the_error_messages_is_incorrect() throws Exception {
//		WebElement errorMessage = SignInPage.errorMessage(driver);
//		assertTrue(errorMessage.isDisplayed());
//	}
//}
