package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Shoppage {

	@FindBy(xpath = "//a[contains(@href,'shop')]")
	public WebElement shop;

	@FindBy(xpath = "//li[contains(.,'Fluffy Bunny')]//a[contains(@class,'btn btn-success')]")
	public WebElement fluffybunny;

	@FindBy(xpath = "//i[@class='icon icon-shopping-cart icon-white']")
	public WebElement cart;

	@FindBy(xpath = "//li[contains(.,'Stuffed Frog')]//a[contains(@class,'btn btn-success')]")
	public WebElement stuffedfrog;

	@FindBy(xpath = "//li[contains(.,'Valentine Bear')]//a[contains(@class,'btn btn-success')]")
	public WebElement Valentinebear;

	@FindBy(xpath = "//*[contains(.,'Stuffed Frog')]//td[4]")
	public WebElement Stuffedfrogsubtotal;

	@FindBy(xpath = "//*[contains(.,'Valentine Bear')]//tr[3]//td[4]")
	public WebElement Valentinebearsubtotal;

	@FindBy(xpath = "//*[contains(.,'Fluffy Bunny')]//tr[2]//td[4]")
	public WebElement Fluffybunnysubtotal;

	@FindBy(xpath = "//*[contains(.,'Stuffed Frog')]//td[2]")
	public WebElement Stuffedfrogprice;

	@FindBy(xpath = "//*[contains(.,'Fluffy Bunny')]//tr[2]//td[2]")
	public WebElement Fluffybunnyprice;

	@FindBy(xpath = "//*[contains(.,'Valentine Bear')]//tr[3]//td[2]")
	public WebElement Valentinebearprice;

	public Shoppage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public void clickShopBtn() {

		shop.click();
	}

	public void addingStuffedfrogToCart() {
		for (int i = 1; i < 3; i++) {
			stuffedfrog.click();
		}

	}

	public void addingFluffybunnyTocart() {

		for (int i = 1; i < 6; i++) {
			fluffybunny.click();
		}

	}

	public void addingValentinebearToCart() {

		for (int i = 1; i < 4; i++) {
			Valentinebear.click();
		}
	}

	public void clickCartBtn() {
		cart.click();

	}

	public String stuffedFrogSubtotal() {
		return Stuffedfrogsubtotal.getText();
	}

	public String valentineBearSubtotal() {

		return Valentinebearsubtotal.getText();
	}

	public String fluffyBunnySubtotal() {

		return Fluffybunnysubtotal.getText();
	}

	public String stuffedFrogPrice() {
		return Stuffedfrogprice.getText();

	}

	public String fluffyBunnyPrice() {
		return Fluffybunnyprice.getText();
	}

	public String valentineBearPrice() {
		return Valentinebearprice.getText();
		
	}
	 public double totalPrice() {
			double StuffedFrogpricesValue= Double.valueOf(stuffedFrogSubtotal().substring(1));
			double FluffyBunnypricesValue= Double.valueOf(fluffyBunnySubtotal().substring(1));
			double ValentineBearpricesValue= Double.valueOf(valentineBearSubtotal().substring(1));		
			double totalprice = StuffedFrogpricesValue + FluffyBunnypricesValue + ValentineBearpricesValue;
			return totalprice;
		    }
	
}
