package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import jupitortoystestcases.BaseTest;

public class ContactPage extends BaseTest {

	By submit = By.xpath("//a[contains(@class,'primary')]");

	By foreName = By.id("forename");

	By surname = By.id("surname");

	By emailId = By.id("email");

	By telephone = By.id("telephone");

	By messagee = By.name("message");

	By forenameerror = By.xpath("//span[@id='forename-err']");

	By emailerror = By.xpath("//span[@id='email-err']");

	By messageerror = By.xpath("//span[@id='message-err']");

	public ContactPage(WebDriver driver) {
		this.driver = driver;

	}

	public void enterforeName(String ForName) {
		driver.findElement(foreName).sendKeys(ForName);
	}

	public void enterSurname(String Surname) {
		driver.findElement(surname).sendKeys(Surname);
	}

	public void enterEmail(String EmailId) {
		driver.findElement(emailId).click();
		driver.findElement(emailId).clear();
		driver.findElement(emailId).sendKeys(EmailId);

	}

	public void enterInvalidEmail(String InvalidEmail) {
		driver.findElement(emailId).sendKeys(InvalidEmail);

	}

	public void enterMessage(String Message) {
		driver.findElement(messagee).sendKeys(Message);

	}

	public void enterTelephoneNum(String Telephonenum) {
		driver.findElement(telephone).sendKeys(Telephonenum);

	}

	public String invalidEmail() {
		return driver.findElement(emailerror).getText();

	}

	public String getForenameError() {
		try {
			return driver.findElement(forenameerror).getText();

		} catch (Exception e) {
			String ForName = null;
			return ForName;
		}
	}

	public String getEmailError() {
		try {
			return driver.findElement(emailerror).getText();
		} catch (Exception e) {
			String Emailid = null;
			return Emailid;

		}
	}

	public String getMessageError() {
		try {
			return driver.findElement(messageerror).getText();
		} catch (Exception e) {
			String Message = null;
			return Message;
		}
	}

	public void clickSubmitButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(submit);
		js.executeScript("arguments[0].click();", element);
	}

}
