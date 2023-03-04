package com.amazon.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.amazon.baseclass.BaseClass;
import com.amazon.cucumber.TestContext;
import com.amazon.pageObjects.HomePage;
import com.amazon.pageObjects.ProductPage;

import io.cucumber.java.Scenario;

public class PageObjectManager {
	private WebDriver driver = null;
	private HomePage obj;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
		


	}


	public HomePage getHomePage() {

		if (obj == null) {
			obj = new HomePage(driver);
		}
		return obj;
	}

}
