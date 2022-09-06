package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import jupitortoystestcases.BaseTest;

public class BasePage extends BaseTest{
	
	By contact=By.xpath("//a[contains(@href,'contact')]");

	By  shop=By.xpath("//a[contains(@href,'shop')]");
	
	
	public BasePage(WebDriver driver) {
		this.driver=driver;

	}
	
	public void clickContactButton(){
		driver.findElement(contact).click();
	}
	
	public void clickShopButton() {
		driver.findElement(shop).click();
		
		
	}

	}

	


