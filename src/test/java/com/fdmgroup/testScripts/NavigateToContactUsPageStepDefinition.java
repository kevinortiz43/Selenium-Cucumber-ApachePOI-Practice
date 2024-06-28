package com.fdmgroup.testScripts;

import static org.junit.Assert.assertEquals ;

import com.fdmgroup.data.DriverSetUp;
import com.fdmgroup.pages.ContactUsPage;
import com.fdmgroup.pages.HomePage;
import com.fdmgroup.util.FileConverter;
import com.fdmgroup.util.Hooks;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigateToContactUsPageStepDefinition extends DriverSetUp {

	@Given("Navigate to website")
	public void navigate_to_website() {
		Hooks.setUpBrowser();

	}

	@Given("Verify the page is correctly navigated")
	public void verify_the_page_is_correctly_navigated() {
		assertEquals(FileConverter.getProperty("homePageURL"), driver.getCurrentUrl());
	}

	@When("Scroll down to the footer")
	public void scroll_down_to_the_footer() {
		js.executeScript("arguments[0].scrollIntoView();", HomePage.contactUsButton(driver));

	}

	@When("Click on contact us button")
	public void click_on_contact_us_button() {
		HomePage.contactUsButton(driver).click();

	}

	@Then("Verify the page header is part of contact us page")
	public void verify_the_page_header_is_part_of_contact_us_page() {
		assertEquals(FileConverter.getProperty("contactUsHeader"), ContactUsPage.Header(driver).getText());
	}

}
