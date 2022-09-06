package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import jupitortoystestcases.BaseTest;


public class ContactSuccessfulPage extends BaseTest {
	
	By successfulMessage=By.xpath("//div[contains(@class,'alert alert-success')]");


	public ContactSuccessfulPage(WebDriver driver) {
		this.driver=driver;

}

	public String getSuccessfulMessage() {
		return driver.findElement(successfulMessage).getText();


}
}
