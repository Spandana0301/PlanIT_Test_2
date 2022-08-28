package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Shoppage{

	@FindBy(xpath = "//a[contains(@href,'shop')]")
	public WebElement shop;

	@FindBy(xpath = "//li[contains(.,'Fluffy Bunny')]//a[contains(@class,'btn btn-success')]")
	public WebElement fluffybunny;

	@FindBy(xpath = "//i[@class='icon icon-shopping-cart icon-white']")
	public WebElement cart;

	@FindBy(xpath = "//li[contains(.,'Stuffed Frog')]//a[contains(@class,'btn btn-success')]")
	public WebElement stuffedfrog;

	@FindBy(xpath = "//li[contains(.,'Valentine Bear')]//a[contains(@class,'btn btn-success')]")
	public WebElement Valentinebear;

	public Shoppage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public void clickShopBtn() {

		shop.click();
	}
		
		public void addingStuffedfrogToCart() {
		for (int i = 1; i < 3; i++) {
			stuffedfrog.click();
		}

	}

	public void addingFluffybunnyTocart() {

		for (int i = 1; i < 6; i++) {
			fluffybunny.click();
		}

	}

	public void addingValentinebearToCart() {

		for (int i = 1; i < 4; i++) {
			Valentinebear.click();
		}
	}
	
	public void clickCartBtn() {
		cart.click();

	}

}
