package com.fdmgroup.testScripts;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.support.ui.Select;

import com.fdmgroup.data.DataFile;
import com.fdmgroup.data.DriverSetUp;
import com.fdmgroup.pages.HomePage;
import com.fdmgroup.util.ExcelUtility;
import com.fdmgroup.util.FileConverter;
import com.fdmgroup.util.Hooks;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CategorySelectionExcelStepDefinition extends DriverSetUp {
	@Given("User navigates to browser")
	public void user_navigates_to_browser() {
		Hooks.setUpBrowser();
		assertEquals(FileConverter.getProperty("homePageURL"), driver.getCurrentUrl());
	}

	@When("User opens the drop-down menu")
	public void user_opens_the_drop_down_menu() {
		HomePage.dropDownMenu(driver).click();
	}

	@When("selects the items then writes it to excel sheetName {string}")
	public void selects_the_items_then_writes_it_to_excel_sheet_name(String sheetName) throws Exception {
		Select selectCategoryDropDown = new Select(HomePage.dropDownMenu(driver));

		String path = "src\\test\\resources\\DataFiles\\Ebay_project_ExcelSheets.xlsx";
		ExcelUtility excelWriting = new ExcelUtility(path);

		excelWriting.customHeaders(sheetName, 0, 0, "Selections", "red");

		for (int i = 0; i < selectCategoryDropDown.getOptions().size(); i++) {
			selectCategoryDropDown.selectByIndex(i);
			String browserData = selectCategoryDropDown.getOptions().get(i).getText();
			assertEquals(DataFile.homePageSelections[i], browserData);

			excelWriting.setCellData(sheetName, i + 1, 0, browserData);

		}
		driver.close();
	}

}