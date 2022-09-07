package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import jupitortoystestcases.BaseTest;

public class ShopPage extends BaseTest {

	public ShopPage(WebDriver driver) {

		this.driver = driver;
	}

	public void buyItem(String itemName, int numberOfItems) {
		WebElement itemContainer = findItem(itemName);
		WebElement buyButton = itemContainer.findElement(By.xpath(".//a[text()='Buy']"));
		for (int i = numberOfItems; i > 0; i--) {
			buyButton.click();

		}

	}

	private WebElement findItem(String itemName) {
		return driver.findElement(By.xpath("//h4[text()='" + itemName + "']/ancestor::li"));

	}

}
