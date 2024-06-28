//package com.fdmgroup.testScripts;
//
//import static org.junit.Assert.assertEquals;
//
//import org.openqa.selenium.support.ui.Select;
//
//import com.fdmgroup.data.DataFile;
//import com.fdmgroup.data.DriverSetUp;
//import com.fdmgroup.pages.HomePage;
//import com.fdmgroup.util.FileConverter;
//import com.fdmgroup.util.Hooks;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class CategorySelectionStepDefinition extends DriverSetUp {
//
//	@Given("User navigates to browser")
//	public void user_navigates_to_browser() {
//		Hooks.setUpBrowser();
//		assertEquals(FileConverter.getProperty("homePageURL"), driver.getCurrentUrl());
//	}
//
//	@When("User opens the drop-down menu")
//	public void user_opens_the_drop_down_menu() {
//		HomePage.dropDownMenu(driver).click();
//	}
//
//	@Then("User verifies the page selected displays the correct category")
//	public void user_verifies_the_page_selected_displays_the_correct_category() {
//		Select selectCategoryDropDown = new Select(HomePage.dropDownMenu(driver));
//
//		for (int i = 0; i < selectCategoryDropDown.getOptions().size(); i++) {
//			selectCategoryDropDown.selectByIndex(i);
//			assertEquals(DataFile.homePageSelections[i], selectCategoryDropDown.getOptions().get(i).getText());
//
//		}
//	}
//}