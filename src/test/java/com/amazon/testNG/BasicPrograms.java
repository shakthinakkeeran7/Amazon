package com.amazon.testNG;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.amazon.baseclass.BaseClass;

public class BasicPrograms extends BaseClass {

	public static String GetT1 = null;

	@BeforeClass
	public static void browserLaunch() throws Exception {
		browserlaunch("chrome");
	
		geturl("https://www.amazon.in/");
	}

	@Test(priority = 1)
	public static void subMenu() {
		WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
		Select DropdownList = new Select(dropdown);
		List<WebElement> allSelectedOptions = DropdownList.getOptions();
		ListIterator<WebElement> listIterator1 = allSelectedOptions.listIterator();
		String Expected = "Music";
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

	@Test(priority = 2, enabled = false)
	public static void SearchKeywords() throws InterruptedException {
		String SearchKeyword = "cd";
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(SearchKeyword);
		Thread.sleep(3000);

		List<WebElement> Searchsuggestions = driver.findElements(By.xpath("//div[@class='s-suggestion-container']"));
		for (int i = 1; i <= Searchsuggestions.size(); i++) {
			WebElement EachSearchsuggestions = driver
					.findElement(By.xpath("//div[@class='autocomplete-results-container']//child::div[" + i + "]"));
			if (SearchKeyword.equalsIgnoreCase(EachSearchsuggestions.getText())) {
				System.out.println("Expected Text in Search Bar: " + EachSearchsuggestions.getText());
				System.out.println("Actual Text in Search Bar: " + SearchKeyword);
				driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
				break;
			}

		}

		WebElement GetTitle1 = driver.findElement(
				By.xpath("//span[(text()='RESULTS')]//ancestor::div[4]//following-sibling::div[1]//child::h2"));
		GetT1 = GetTitle1.getText();
		System.out.println("Produc Name in Product List: " + GetT1);
		driver.findElement(
				By.xpath("//span[(text()='RESULTS')]//ancestor::div[4]//following-sibling::div[1]//child::h2/a"))
				.click();

	}

	@Test(priority = 3)
	public static void windowHandles() throws InterruptedException {
		System.out.println(GetT1);
		String AmazonwindowHandle = driver.getWindowHandle();
		Set<String> handle = driver.getWindowHandles();
		Iterator<String> iterator2 = handle.iterator();
		while (iterator2.hasNext()) {
			String handleID = (String) iterator2.next();

			if (!AmazonwindowHandle.equalsIgnoreCase(handleID)) {

				driver.switchTo().window(handleID);
				WebElement GetElements = driver.findElement(By.xpath("//div[@id='titleSection']/h1"));
				String GetT2 = GetElements.getText();
				System.out.println("Produc Name in unique page: " + GetT2);
				if (GetT1.equalsIgnoreCase(GetT2)) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
				}
			}
		}

	}

	@Test(priority = 4)
	public static void screenshot() throws IOException {

		screenshot("amazon2");
	}

	@Test(priority = 5)
	public static void goToCart() throws InterruptedException {

		driver.findElement(By.xpath("(//a[contains(text(),'Go to Cart')])[2]")).click();
		Thread.sleep(2000);

	}

	@Test(priority = 6)
	public static void getTitlePage() throws IOException

	{
		List<WebElement> TitleName = driver
				.findElements(By.xpath("//li[@class='a-spacing-mini']//descendant::a[1]/span/span"));

		for (WebElement j2 : TitleName) {
			String GetT4 = j2.getText();
			System.out.println("Product Name in Cart Page: " + GetT4);
			if (GetT4 == GetT1) {

				screenshot("amazon");
				driver.close();
				break;
			}
		}
	}

	@Test(priority = 7)
	private void proceedToBuy() {

		driver.findElement(By.xpath("//input[@name='proceedToRetailCheckout']")).click();

	}

	@AfterClass
	public static void quit() {

		driver.quit();

	}

}
