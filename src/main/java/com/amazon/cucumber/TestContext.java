package com.amazon.cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.amazon.managers.DriverManager;
import com.amazon.managers.PageObjectManager;
import com.amazon.pageObjects.HomePage;

import com.github.dockerjava.api.model.Driver;

import com.amazon.cucumber.ScenarioContext;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.textui.TestRunner;

public class TestContext {
	private WebDriver driver = null;

	
    public TestContext(){
   
        pageObjectManager = new PageObjectManager(getDriver());
        scenarioContext = new ScenarioContext();
    }
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	
	}

	private DriverManager driverManager;
    private PageObjectManager pageObjectManager;
    private ScenarioContext scenarioContext;



    public DriverManager getWebDriverManager() {
        return driverManager;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
    public void initial(WebDriver driver) {

 	pageObjectManager = new PageObjectManager(driver);
	
    
    scenarioContext = new ScenarioContext();
}
}