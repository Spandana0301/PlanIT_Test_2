package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Shoppage {
	int stuffedfrogcount=2;
	int fluffybunnycount=5;
	int Valentinebearcount=3;
	
	public Shoppage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//li[4]//a[contains(@class,'btn btn-success')]")
	public WebElement fluffybunny;

	@FindBy(xpath = "//li[2]//a[contains(@class,'btn btn-success')]")
	public WebElement stuffedfrog;

	@FindBy(xpath = "//li[7]//a[contains(@class,'btn btn-success')]")
	public WebElement valentinebear;
	

    public void addStuffedfrogToCart() {
    	
    	
		for (int i = 0; i < stuffedfrogcount ; i++) {
			stuffedfrog.click();
		}

	}

	public void addFluffybunnyTocart() {

		for (int i = 0; i <fluffybunnycount ; i++) {
			fluffybunny.click();
		}

	}

	public void addValentinebearToCart() {

		for (int i = 0; i < Valentinebearcount; i++) {
			valentinebear.click();
		}
	}



	
}
