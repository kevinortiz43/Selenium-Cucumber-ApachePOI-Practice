package com.fdmgroup.testScripts;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.support.ui.Select;

import com.fdmgroup.data.DriverSetUp;
import com.fdmgroup.pages.AdvancedSearchPage;
import com.fdmgroup.pages.HomePage;
import com.fdmgroup.util.FileConverter;
import com.fdmgroup.util.Hooks;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SelectingProductStepDefinition extends DriverSetUp {
	@Given("User will navigate to the eBay website")
	public void user_will_navigate_to_the_e_bay_website() {
		Hooks.setUpBrowser();
		assertEquals(FileConverter.getProperty("homePageURL"), driver.getCurrentUrl());
	}

	@When("User will navigate to the advanced search and provide specific search criteria")
	public void user_will_navigate_to_the_advanced_search_and_provide_specific_search_criteria() {
		HomePage.advancedSearchButton(driver).click();
	}

	@When("User provides the keyword {string}")
	public void user_provides_the_keyword(String keyword) {
		AdvancedSearchPage.keywordsInputField(driver).sendKeys(keyword);
	}

	@When("User selects keyword options {string}")
	public void user_selects_keyword_options(String keywordOptions) {
		Select selectKeyWordOptions = new Select(AdvancedSearchPage.keywordsOptionsDropDown(driver));
		selectKeyWordOptions.selectByVisibleText(keywordOptions);
	}

	@When("User provides keyword exclusions {string}")
	public void user_provides_keyword_exclusions(String keywordExclusions) {
		AdvancedSearchPage.keywordsExclusionInputField(driver).sendKeys(keywordExclusions);

	}

	@When("User selects category {string}")
	public void user_selects_category(String category) {
		Select selectCategory = new Select(AdvancedSearchPage.categoriesDropDown(driver));
		selectCategory.selectByVisibleText(category);
	}

	@When("User selects buying formats {string}")
	public void user_selects_buying_formats(String buyingFormats) {
		for (int i = 0; i < AdvancedSearchPage.buyingFormatRadioButtons(driver).size(); i++) {
			if (AdvancedSearchPage.buyingFormatRadioButtons(driver).get(i).getAttribute("value")
					.equalsIgnoreCase(buyingFormats)) {
				AdvancedSearchPage.buyingFormatRadioButtons(driver).get(i).click();
			}
		}

	}

	@When("User selects condition {string}")
	public void user_selects_condition(String condition) {
		for (int i = 0; i < AdvancedSearchPage.conditionRadioButtons(driver).size(); i++) {
			if (AdvancedSearchPage.conditionRadioButtons(driver).get(i).getAttribute("data-testid")
					.equalsIgnoreCase(condition)) {
				AdvancedSearchPage.conditionRadioButtons(driver).get(i).click();
			}
		}
	}

	@When("User selects show results {string}")
	public void user_selects_show_results(String showResults) {
		for (int i = 0; i < AdvancedSearchPage.showResults(driver).size(); i++) {
			if (AdvancedSearchPage.showResults(driver).get(i).getAttribute("name").equalsIgnoreCase(showResults)) {
				AdvancedSearchPage.showResults(driver).get(i).click();
			}
		}
	}

	@When("User selects shipping options {string}")
	public void user_selects_shipping_options(String shippingOptions) {
		for (int i = 0; i < AdvancedSearchPage.shippingOptions(driver).size(); i++) {
			if (AdvancedSearchPage.shippingOptions(driver).get(i).getAttribute("name")
					.equalsIgnoreCase(shippingOptions)) {
				AdvancedSearchPage.shippingOptions(driver).get(i).click();
			}
		}
	}

	@When("User selects location {string}")
	public void user_selects_location(String location) {
		for (int i = 0; i < AdvancedSearchPage.itemLocation(driver).size(); i++) {
			if (AdvancedSearchPage.itemLocation(driver).get(i).getAttribute("id").equalsIgnoreCase(location)) {
				AdvancedSearchPage.itemLocation(driver).get(i).click();
			}
		}
	}

	@When("User selects sort by {string}")
	public void user_selects_sort_by(String sortBy) {
		Select sortBySelection = new Select(AdvancedSearchPage.sortByDropDown(driver));
		sortBySelection.selectByVisibleText(sortBy);

	}

	@When("User selects view results {string}")
	public void user_selects_view_results(String viewResults) {
		Select viewResultsSelection = new Select(AdvancedSearchPage.viewResultsDropDown(driver));
		viewResultsSelection.selectByVisibleText(viewResults);
	}

	@When("User selects results per page {string}")
	public void user_selects_results_per_page(String resultsPerPage) {
//		Select resultsPerPageSelection = new Select(AdvancedSearchPage.ResultsPerPageDropDown(driver));
//		resultsPerPageSelection.selectByValue(resultsPerPage);
	}

	@Then("User will verify the {string} displayed is the one wanted")
	public void user_will_verify_the_displayed_is_the_one_wanted(String keyword) {
		AdvancedSearchPage.searchButton(driver).click();
		assertEquals(AdvancedSearchPage.itemResults(driver).getAttribute("value"), keyword);
	}

}