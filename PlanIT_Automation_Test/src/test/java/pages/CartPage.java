package pages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import jupitortoystestcases.BaseTest;

public class CartPage extends BaseTest {

	By removeStuffedfrog = By.xpath("//tr[1]//td[5]//a/i[contains(@class,'icon-remove icon-white')]");

	By accept = By.xpath("//div/a[contains(@class,'btn btn-success')]");

	By stuffedFrogItem = By.xpath("//tr/td[1][contains(text(),' Stuffed Frog')]");

	By checkOut = By.xpath("//a[text()='Check Out']");

	public CartPage(WebDriver driver) {
		this.driver = driver;

	}

	public String getItemPrice(String itemName) {

		String itemPrice = driver.findElement(By.xpath("//tr/td[contains(text(),'" + itemName + "')]/following-sibling::td[1]")).getText();
		return itemPrice;

	}

	public String getItemSubtotal(String itemName) {

		String itemSubtotal = driver.findElement(By.xpath("//tr/td[contains(text(),'" + itemName + "')]/following-sibling::td[3]")).getText();
		return itemSubtotal;

	}
	
	public int getTotalQuantity() {
		List <WebElement> rows= driver.findElements(By.xpath("//tr/td[1]"));
		int j=rows.size()-2;
		int totalQuantity =0;
		for(int i=1;i<=j;i++) {
			String quantity=driver.findElement(By.xpath("//tr["+i+"]//td[3]/input")).getAttribute("value");
			int intQuantity= Integer.valueOf(quantity);
		    totalQuantity = totalQuantity + intQuantity;
		}
		return totalQuantity;
	}
	
	public String getTotalPrice() {

     	return driver.findElement(By.xpath("//tfoot/tr[1]/td[1]")).getText();
		

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

	public void checkOutButton() {

		driver.findElement(checkOut).click();
	}

}
