package com.amazon.practice;

import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.amazon.baseclass.BaseClass;

public class Temp {

	
	public static void main(String[] args) throws Exception {
		
		
	BaseClass.browserlaunch("chrome");
	
	BaseClass d = new BaseClass();
	d.tt();
	
	BaseClass.geturl("https://www.amazon.in/");
		
//		WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
//		Select DropdownList = new Select(dropdown);
//		List<WebElement> allSelectedOptions = DropdownList.getOptions();
//		ListIterator<WebElement> listIterator1 = allSelectedOptions.listIterator();
//		String Expected = "Music";
//		while (listIterator1.hasNext()) {
//			WebElement next = listIterator1.next();
//			if (Expected.equalsIgnoreCase(next.getText())) {
//				DropdownList.selectByVisibleText(Expected);
//				System.out.println("Expected Text in Submenu Bar:" + Expected);
//				System.out.println("Actual Text in Submenu Bar:" + next.getText());
//				break;
			}
		

		
		
		 
	}

	
