package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import data.ContactDetails;

public class ContactPage extends BasePage {

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
		super(driver);

	}

	public void enterforeName(String forName) {
		driver.findElement(foreName).sendKeys(forName);
	}

	public void enterSurname(String surName) {
		driver.findElement(surname).sendKeys(surName);
	}

	public void enterEmail(String email) {
		driver.findElement(emailId).click();
		driver.findElement(emailId).clear();
		driver.findElement(emailId).sendKeys(email);

	}

	public void enterInvalidEmail(String invalidEmail) {
		driver.findElement(emailId).sendKeys(invalidEmail);

	}

	public void enterMessage(String message) {
		driver.findElement(messagee).sendKeys(message);

	}

	public void enterTelephoneNum(String telephoneNumber) {
		driver.findElement(telephone).sendKeys(telephoneNumber);

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
		WebElement submitButton = driver.findElement(submit);
		js.executeScript("arguments[0].scrollIntoView()", submitButton);
		submitButton.click();
	}

	public void fillingTheForm(ContactDetails contactdetails) {
		enterforeName(contactdetails.getForeName());
		enterSurname(contactdetails.getSurName());
		enterEmail(contactdetails.getEmail());
		enterTelephoneNum(contactdetails.getTelephoneNumber());
		enterMessage(contactdetails.getMessage());

	}
}
