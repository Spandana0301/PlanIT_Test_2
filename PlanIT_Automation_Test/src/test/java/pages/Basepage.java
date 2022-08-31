package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Basepage {
	
	@FindBy(xpath = "//a[contains(@href,'contact')]")
	public WebElement contact;
	

	@FindBy(xpath = "//a[contains(@href,'shop')]")
	public WebElement shop;
	
	public Basepage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	
	public void clickContactBtn(){
		
		contact.click();
	}
	
	public void clickShopBtn() {
		shop.click();
		
		
	}

	}

	


