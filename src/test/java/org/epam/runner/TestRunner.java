package org.epam.runner;

import org.epam.browser.WebDriverBaseClass;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"}, glue ={"org.epam.stepdefinition"}, plugin = {
		"html:target/cucumber-html-report" }

)
public class TestRunner {
	@BeforeClass	
	public static void initWebDriver() {
		WebDriverBaseClass.setUp();
	}

	@AfterClass
	public static void closeWebDriver() {
		WebDriverBaseClass.tearDown();
	}

}
