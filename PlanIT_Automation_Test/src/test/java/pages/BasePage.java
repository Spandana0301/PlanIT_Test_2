package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

	protected WebDriver driver;

	By contact = By.xpath("//a[@href='#/contact']");

	By shop = By.xpath("//a[@href='#/shop']");

	By cart = By.xpath("//i[@class='icon icon-shopping-cart icon-white']");

	By logIn = By.xpath("//i[(@class='icon icon-user icon-white')]");

	By logOut = By.xpath(".//span[(@class='action')]");

	public BasePage(WebDriver driver) {
		this.driver = driver;

	}

	public void clickContactButton() {
		driver.findElement(contact).click();
	}

	public ShopPage clickShopButton() {
		driver.findElement(shop).click();
		return new ShopPage(driver);

	}

	public CartPage clickCartButton() {
		driver.findElement(cart).click();
		return new CartPage(driver);

	}
	public void clickLoginButton() {
		driver.findElement(logIn).click();
	}

	public void clickLogoutButton() {
		driver.findElement(logOut).click();
	}
	

}
