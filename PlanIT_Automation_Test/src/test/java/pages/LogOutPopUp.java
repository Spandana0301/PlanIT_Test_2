package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogOutPopUp extends BaseModal{
	
	 By logOutButton=By.xpath(".//a[(@class='btn btn-success')]");

	public LogOutPopUp(WebDriver driver) {
		super(driver);
	}
	public void clickLogOutButtonOnPopUp() {
		modal.findElement(logOutButton).click();
	}
	
	
}
