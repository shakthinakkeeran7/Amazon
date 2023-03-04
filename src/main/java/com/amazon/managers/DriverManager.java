package com.amazon.managers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.amazon.enums.DriverType;
import com.amazon.enums.EnvironmentType;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;


public class DriverManager {
    private WebDriver driver;
    private static DriverType driverType;
    private static EnvironmentType environmentType;
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

    public DriverManager() {
        driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
        environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();

    }

    

	public WebDriver getDriver() {
        if(driver == null)
            driver = createDriver();
        return driver;
    }

    private WebDriver createDriver() {
        switch (environmentType) {
            case LOCAL : driver = createLocalDriver();
                break;
            case REMOTE : driver = createRemoteDriver();
                break;
        }
        return driver;
    }

    private WebDriver createRemoteDriver() {
     
        switch (driverType) {
        case FIREFOX : driver = new FirefoxDriver();
            break;
        case CHROME :
            WebDriverManager.chromedriver().setup();
        	driver = new ChromeDriver();
            break;
        case INTERNETEXPLORER : driver = new InternetExplorerDriver();
            break;
    }

    if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize())
        driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(
            FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS
    );
    return driver;
}
    private WebDriver createLocalDriver() {
        switch (driverType) {
            case FIREFOX : driver = new FirefoxDriver();
                break;
            case CHROME :
                System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath());
                driver = new ChromeDriver();
                break;
            case INTERNETEXPLORER : driver = new InternetExplorerDriver();
                break;
        }

        if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize())
            driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(
                FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS
        );
        return driver;
    }

    public void closeDriver() {
        driver.close();

    }

}