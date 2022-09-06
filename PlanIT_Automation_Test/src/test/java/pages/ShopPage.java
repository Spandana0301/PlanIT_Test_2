package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import jupitortoystestcases.BaseTest;

public class ShopPage extends BaseTest {


	By fluffybunny = By.xpath("//h4[contains(text(), 'Fluffy Bunny')]/following-sibling::p/a");

	By stuffedfrog = By.xpath("//h4[contains(text(), 'Stuffed Frog')]/following-sibling::p/a");

	By valentinebear = By.xpath("//h4[contains(text(), 'Valentine Bear')]/following-sibling::p/a");

	public ShopPage(WebDriver driver) {

		this.driver = driver;
	}

	public void addStuffedfrogToCart(int number) {

		while (number != 0) {
			driver.findElement(stuffedfrog).click();
			number = number - 1;
		}
	}

	public void addFluffybunnyTocart(int number) {

		while (number != 0) {
			driver.findElement(fluffybunny).click();
			number = number - 1;
		}

	}

	public void addValentinebearToCart(int number) {

		while (number != 0) {
            driver.findElement(valentinebear).click();
			number = number - 1;
		}
	}

}
