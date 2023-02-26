package com.amazon.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.amazon.baseclass.BaseClass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\com\\amazon\\feature",
//tags = "@test",
monochrome = true, 
glue = "com.amazon.stepdefinition", //
dryRun = false, //
stepNotifications = false //
//plugin = "Pretty"
)

public class TestRunner extends BaseClass {

	@BeforeClass
	public static void stepUp() throws Exception {

		browserlaunch("chrome");
		geturl("https://www.amazon.in/");

	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

}


