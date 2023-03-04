package com.amazon.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.baseclass.BaseClass;
import com.amazon.cucumber.TestContext;

public class HomePage extends BaseClass {

	WebDriver driver = null;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "searchDropdownBox")
	private WebElement dropdown;

	public WebElement getDropdown() {

		return dropdown;

	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public List<WebElement> getSearchsuggestions() {
		return Searchsuggestions;
	}

	public WebElement getSearchButton() {
		return SearchButton;
	}

	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchBox;

	@FindBy(xpath = "//div[@class='s-suggestion-container']")
	private List<WebElement> Searchsuggestions;

	@FindBy(xpath = "//input[@id='nav-search-submit-button']")
	private WebElement SearchButton;

}
