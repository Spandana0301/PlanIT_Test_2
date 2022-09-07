package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import jupitortoystestcases.BaseTest;

public class CartPage extends BaseTest {


	By removeStuffedfrog = By.xpath("//tr[1]//td[5]//a/i[contains(@class,'icon-remove icon-white')]");

	By accept = By.xpath("//div/a[contains(@class,'btn btn-success')]");

	By stuffedFrogItem = By.xpath("//tr/td[1][contains(text(),' Stuffed Frog')]");
	

	public CartPage(WebDriver driver) {
		this.driver = driver;

	}

	public String getItemPrice(String itemName) {
		
		 String	itemPrice = driver.findElement(By.xpath("//tr/td[contains(text(),'"+itemName+"')]/following-sibling::td[1]")).getText();
			return itemPrice;
		
	}
	
	public String getItemSubtotal(String itemName) {
		
		 String	itemSubtotal = driver.findElement(By.xpath("//tr/td[contains(text(),'"+itemName+"')]/following-sibling::td[3]")).getText();
			return itemSubtotal;
		
	}
	public String getTotalPrice() {
		
		 String	itemsTotalPrice = driver.findElement(By.xpath("//tfoot/tr[1]/td[1]")).getText();
			return itemsTotalPrice;
		
	}
	
	public void removeStuffedFrog() {
		driver.findElement(removeStuffedfrog).click();
		
	}
	
	public void accept() {
		
		driver.findElement(accept).click();
	}
	
	public boolean getStuffedFrog() {
		
		try {
			return driver.findElement(stuffedFrogItem).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	

	
}
