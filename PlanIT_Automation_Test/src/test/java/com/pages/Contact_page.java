package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contact_page {

	@FindBy(xpath = "//a[contains(@href,'contact')]")
	public  WebElement contact;

	public Contact_page(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public void clickContact() {

		contact.click();
	}

}
