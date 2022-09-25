package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutSuccessfulPage extends BasePage {

	By orderNumber = By.xpath("//strong[2]");

	public CheckoutSuccessfulPage(WebDriver driver) {
		super(driver);
	}

	public String getOrderNumber() {
		return driver.findElement(orderNumber).getText();
	}

}
