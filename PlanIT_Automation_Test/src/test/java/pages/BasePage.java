package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import jupitortoystestcases.BaseTest;

public class BasePage extends BaseTest{
	
	By contact=By.xpath("//a[contains(@href,'contact')]");

	By  shop=By.xpath("//a[contains(@href,'shop')]");
	
	By cart=By.xpath("//i[@class='icon icon-shopping-cart icon-white']");
	
	public BasePage(WebDriver driver) {
		this.driver=driver;

	}
	
	public void clickContactButton(){
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

	}

	


