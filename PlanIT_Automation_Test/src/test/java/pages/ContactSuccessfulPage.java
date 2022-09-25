package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactSuccessfulPage extends BasePage {

	By successfulMessage = By.xpath("//div[(@class='alert alert-success')]");

	public ContactSuccessfulPage(WebDriver driver) {
		super(driver);

	}

	public String getSuccessfulMessage() {
		return driver.findElement(successfulMessage).getText();

	}
}
