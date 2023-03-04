package com.amazon.runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.amazon.baseclass.BaseClass;
import com.amazon.cucumber.TestContext;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/java/com/amazon/feature/amazon.feature",
		// tags = "@test",
		monochrome = true, glue = "com.amazon.stepdefinition", //
		dryRun = false, //
		stepNotifications = false //
)

public class TestRunner {
public static WebDriver driver = null;

	@BeforeClass
	public static void stepUp() throws Exception {
		BaseClass.browserlaunch("chrome");
	driver =BaseClass.driver;



	 
	}

	@AfterClass

	public static void tearDown() {

		driver.quit();
	}

}
