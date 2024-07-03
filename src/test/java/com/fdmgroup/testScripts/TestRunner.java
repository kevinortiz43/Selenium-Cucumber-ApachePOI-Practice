package com.fdmgroup.testScripts;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Feature", glue = { "com.fdmgroup" }, publish = true, plugin = {
		"pretty", "html:target/cucumber.html", "json:target/cucumber.json",
		"junit:target/cucumber.xml" }, tags = "@TestCase5", monochrome = true)

public class TestRunner {

}
