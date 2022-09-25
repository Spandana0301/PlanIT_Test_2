package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseModal{

	public WebElement modal;
	
	public BaseModal(WebDriver driver) {
		this.modal=driver.findElement(By.className("popup"));

	}

}