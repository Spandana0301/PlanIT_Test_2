package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import jupitortoystestcases.BaseTest;

public class CartPage extends BaseTest {

	By cart = By.xpath("//i[@class='icon icon-shopping-cart icon-white']");

	By stuffedfrogsubtotal = By.xpath("//tr[1]/td[4]");

	By valentinebearsubtotal = By.xpath("//tr[2]/td[4]");

	By fluffybunnysubtotal = By.xpath("//tr[3]/td[4]");

	By stuffedfrogprice = By.xpath("//tbody/tr[1]/td[2]");

	By fluffybunnyprice = By.xpath("//tbody/tr[3]/td[2]");

	By valentinebearprice = By.xpath("//tbody/tr[2]/td[2]");

	By totalprice = By.xpath("//strong[contains(@class,'total ng-binding')]");

	By RemoveButton = By.xpath("//tr[1]//td[5]//a/i[contains(@class,'icon-remove icon-white')]");

	By Accept = By.xpath("//div/a[contains(@class,'btn btn-success')]");

	By Stuffedfrogitem = By.xpath("//tr/td[1][contains(text(),' Stuffed Frog')]");

	public CartPage(WebDriver driver) {
		this.driver = driver;

	}

	public void clickCartBtn() {
		driver.findElement(cart).click();
	}

	public String getStuffedFrogSubtotal() {
		return driver.findElement(stuffedfrogsubtotal).getText();
	}

	public String getValentineBearSubtotal() {

		return driver.findElement(valentinebearsubtotal).getText();
	}

	public String getFluffyBunnySubtotal() {

		return driver.findElement(fluffybunnysubtotal).getText();
	}

	public String getStuffedFrogPrice() {
		return driver.findElement(stuffedfrogprice).getText();

	}

	public String getFluffyBunnyPrice() {
		return driver.findElement(fluffybunnyprice).getText();
	}

	public String getValentineBearPrice() {
		return driver.findElement(valentinebearprice).getText();

	}

	public String gettotalPrice() {

		return driver.findElement(totalprice).getText();

	}

	public void removeItem() {

		driver.findElement(RemoveButton).click();
	}

	public void accept() {
		driver.findElement(Accept).click();

	}

	public boolean checkRemovedItem() {
		try {
			return driver.findElement(Stuffedfrogitem).isDisplayed();

		} catch (Exception e) {
			return false;
		}
	}
}
