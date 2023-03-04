package com.amazon.stepdefinition;

import com.amazon.cucumber.TestContext;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import javax.naming.Context;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.amazon.baseclass.BaseClass;
import com.amazon.managers.DriverManager;
import com.amazon.managers.PageObjectManager;
import com.amazon.pageObjects.HomePage;
import com.amazon.runner.TestRunner;
import com.amazon.enums.*;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSearch_Steps extends BaseClass {

	WebDriver driver = TestRunner.driver;
	TestContext testContext;
	Scenario s;

	public ProductSearch_Steps(TestContext context) {

		this.testContext = context;
		testContext.setDriver(driver);
		testContext.initial(driver);
	}

	public static List<WebElement> allSelectedOptions;
	public static Select DropdownList;
	public static String SearchKeyword;
	public static String GetT1;
	public static String GetT2;

	@When("get Dropdown List")
	public void get_dropdown_list() throws Exception {

	
		testContext.getDriver().get("https://www.amazon.in");

		DropdownList = new Select(testContext.getPageObjectManager().getHomePage().getDropdown());

		allSelectedOptions = DropdownList.getOptions();


	}

	@When("comapare give value {string} in the list")
	public void comapare_give_value_in_the_list(String Expected) {
		ListIterator<WebElement> listIterator1 = allSelectedOptions.listIterator();

		while (listIterator1.hasNext()) {
			WebElement next = listIterator1.next();
			if (Expected.equalsIgnoreCase(next.getText())) {
				DropdownList.selectByVisibleText(Expected);
				System.out.println("Expected Text in Submenu Bar:" + Expected);
				System.out.println("Actual Text in Submenu Bar:" + next.getText());
				break;
			}
		}

	}

	@Given("give value {string} to the search bar")
	public void give_value_to_the_search_bar(String SearchKeyword) throws InterruptedException {
		testContext.getPageObjectManager().getHomePage().getSearchBox().click();
		testContext.getPageObjectManager().getHomePage().getSearchBox().sendKeys(SearchKeyword);
		Thread.sleep(3000);
		this.SearchKeyword = SearchKeyword;

	}

	@Given("comapare  in the search list and click")
	public void comapare_in_the_search_list_and_click() {

		for (int i = 1; i <= testContext.getPageObjectManager().getHomePage().getSearchsuggestions().size(); i++) {
			WebElement EachSearchsuggestions = driver
					.findElement(By.xpath("//div[@class='autocomplete-results-container']//child::div[" + i + "]"));
			if (SearchKeyword.equalsIgnoreCase(EachSearchsuggestions.getText())) {
				System.out.println("Expected Text in Search Bar: " + EachSearchsuggestions.getText());
				System.out.println("Actual Text in Search Bar: " + SearchKeyword);
				testContext.getPageObjectManager().getHomePage().getSearchButton().click();
				break;
			}

		}

	}

	@When("get Product Title in search result")
	public void get_product_title_in_search_result() {
		WebElement GetTitle1 = driver.findElement(
				By.xpath("//span[(text()='RESULTS')]//ancestor::div[4]//following-sibling::div[1]//child::h2"));
		GetT1 = GetTitle1.getText();
		System.out.println("Produc Name in Product List: " + GetT1);

	}

	@Then("click Product Title")
	public void click_product_title() {

		driver.findElement(
				By.xpath("//span[(text()='RESULTS')]//ancestor::div[4]//following-sibling::div[1]//child::h2/a"))
				.click();
	}

	@When("move to new product page")
	public void move_to_new_product_page() {
		System.out.println(GetT1);
		String AmazonwindowHandle = driver.getWindowHandle();
		Set<String> handle = driver.getWindowHandles();
		Iterator<String> iterator2 = handle.iterator();
		while (iterator2.hasNext()) {
			String handleID = (String) iterator2.next();

			if (!AmazonwindowHandle.equalsIgnoreCase(handleID)) {

				driver.switchTo().window(handleID);
			}
		}
	}

	@When("get Product Title in New Page")
	public void get_product_title_in_new_page() throws InterruptedException {

		WebElement GetElements = driver.findElement(By.xpath("//div[@id='titleSection']/h1"));
		String GetT2 = GetElements.getText();
		System.out.println("Produc Name in unique page: " + GetT2);
	}

	@When("Compare the Both Title")
	public void compare_the_both_title() throws InterruptedException {
		if (GetT1.equalsIgnoreCase(GetT2)) {
			Thread.sleep(1000);

		}

	}

	@Then("if the title is simler value click add to cart")
	public void if_the_title_is_simler_value_click_add_to_cart() {
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();

	}

	@Then("take screenshot in the Added to Cart page")
	public void take_screenshot_in_the_added_to_cart_page() throws IOException {

		screenshot("amazon2");
	}

	@When("click go to cart button")
	public void click_go_to_cart_button() throws InterruptedException {

		driver.findElement(By.xpath("(//a[contains(text(),'Go to Cart')])[2]")).click();
		Thread.sleep(2000);
	}

	@When("get Product Title In Goto Cart")
	public void get_product_title_in_goto_cart() throws InterruptedException {
		driver.findElement(By.xpath("(//a[contains(text(),'Go to Cart')])[2]")).click();
		Thread.sleep(2000);

	}

	@When("compare With Previous Title")
	public void compare_with_previous_title() throws IOException {
		List<WebElement> TitleName = driver
				.findElements(By.xpath("//li[@class='a-spacing-mini']//descendant::a[1]/span/span"));

		for (WebElement j2 : TitleName) {
			String GetT4 = j2.getText();
			System.out.println("Product Name in Cart Page: " + GetT4);
			if (GetT4 == GetT1) {

				break;
			}
		}

	}

	@When("get Screenshoton On The  Add To Cart Page")
	public void get_screenshoton_on_the_add_to_cart_page() throws IOException {
		screenshot("amazon");

	}

	@Then("click Proceed To Buy button")
	public void click_proceed_to_buy_button() {

		driver.findElement(By.xpath("//input[@name='proceedToRetailCheckout']"));
	}

	@Then("close The Current Window")
	public void close_the_current_window() {
		driver.close();

	}

}
