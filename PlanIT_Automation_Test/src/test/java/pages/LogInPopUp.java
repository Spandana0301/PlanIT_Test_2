package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPopUp extends BaseModal {

	By userName = By.id("loginUserName");

	By password = By.id("loginPassword");

	By submitbutton = By.xpath(".//button[(@class='btn btn-primary')]");

	By incorrectdloginerrormessage = By.id("login-error");

	public LogInPopUp(WebDriver driver) {
		super(driver);

	}

	public void enterUserName(String UserName) {
		modal.findElement(userName).sendKeys(UserName);
		

	}

	public void enterPassword(String Password) {
		modal.findElement(password).sendKeys(Password);
		
	}

	public void clickLogInButton() {
		modal.findElement(submitbutton).click();
		

	}

	public String getLoginIncorrectErrorMessage() {
		return modal.findElement(incorrectdloginerrormessage).getText();

	}
}
