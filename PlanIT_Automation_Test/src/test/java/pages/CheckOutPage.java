package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import jupitortoystestcases.BaseTest;

public class CheckOutPage extends BaseTest {
	
	By address=By.name("address");
	
	By card=By.id("cardType");
	
	By cardnumber=By.id("card");
	
	By submitButton=By.id("checkout-submit-btn");
	
	By orderNumber=By.xpath("//div[contains(@class,'alert alert-success')]/strong[2]");
	
	
	
	public CheckOutPage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public void enterAddress(String Address) {
		
		driver.findElement(address).sendKeys(Address);
	}
	
	public void cardSelect(String Cardselect) {
		WebElement element=driver.findElement(card);
		Select select=new Select(element);
		select.selectByValue(Cardselect);
		
	}
	
	public void enterCardNumber(String cardNumber) {
		
		driver.findElement(cardnumber).sendKeys(cardNumber);
	}
	
	public void checkoutSubmitButton(){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement submitbutton= driver.findElement(submitButton);
		js.executeScript("arguments[0].click();", submitbutton);
	}
	
	public String getOrderNumber() {
			
		return driver.findElement(orderNumber).getText();
	}
	
	
	
	
}


