package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cartpage {

	
	@FindBy(xpath = "//i[@class='icon icon-shopping-cart icon-white']")
	public WebElement cart;
	
	@FindBy(xpath = "//*[contains(.,'Stuffed Frog')]//td[4]")
	public WebElement stuffedfrogsubtotal;

	@FindBy(xpath = "//*[contains(.,'Valentine Bear')]//tr[3]//td[4]")
	public WebElement valentinebearsubtotal;

	@FindBy(xpath = "//*[contains(.,'Fluffy Bunny')]//tr[2]//td[4]")
	public WebElement fluffybunnysubtotal;

	@FindBy(xpath = "//*[contains(.,'Stuffed Frog')]//td[2]")
	public WebElement stuffedfrogprice;

	@FindBy(xpath = "//*[contains(.,'Fluffy Bunny')]//tr[2]//td[2]")
	public WebElement fluffybunnyprice;

	@FindBy(xpath = "//*[contains(.,'Valentine Bear')]//tr[3]//td[2]")
	public WebElement valentinebearprice;
	
	@FindBy(xpath="//strong[contains(@class,'total ng-binding')]")
	public WebElement totalprice;
	
	public Cartpage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	
	public void clickCartBtn() {
		cart.click();
	}
	
	public String getStuffedFrogSubtotal() {
		return stuffedfrogsubtotal.getText();
	}

	public String getValentineBearSubtotal() {

		return valentinebearsubtotal.getText();
	}

	public String getFluffyBunnySubtotal() {

		return fluffybunnysubtotal.getText();
	}

	public String getStuffedFrogPrice() {
		return stuffedfrogprice.getText();

	}

	public String getFluffyBunnyPrice() {
		return fluffybunnyprice.getText();
	}

	public String getValentineBearPrice() {
		return valentinebearprice.getText();
		
	}
	 public String gettotalPrice() {
		 
		 return totalprice.getText();
			
		    }
	

	
}
