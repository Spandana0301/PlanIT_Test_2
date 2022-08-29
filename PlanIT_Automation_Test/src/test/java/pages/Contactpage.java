package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactpage {
	
	public Contactpage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[contains(@href,'contact')]")
	public WebElement contact;

	@FindBy(xpath = "//a[contains(@class,'primary')]")
	public WebElement submit;

	@FindBy(id = "forename")
	public WebElement foreName;

	@FindBy(id = "surname")
	public WebElement Surname;

	@FindBy(id = "email")
	public WebElement emailId;

	@FindBy(id = "telephone")
	public WebElement Telephone;

	@FindBy(name = "message")
	public WebElement messagee;

	@FindBy(xpath = "//span[@id='forename-err']")
	public WebElement Forenamerequired;

	@FindBy(xpath = "//span[@id='email-err']")
	public WebElement Emailrequired;

	@FindBy(xpath = "//span[text()='Please enter a valid email']")
	public WebElement invalidemail;

	@FindBy(xpath = "//span[@id='message-err']")
	public WebElement Messagerequired;

	@FindBy(xpath = "//div[contains(@class,'alert alert-success')]")
	public WebElement SuccessfulMessage;

	

	public void clickContactBtn() {
         contact.click();
	}

	public void clickSubmitBtn() {
		submit.click();

	}

	public void enteringforeName(String ForName) {
		foreName.sendKeys(ForName);
	}

	public void enteringSurname(String surname) {
		Surname.sendKeys(surname);
	}

	public void enteringEmail(String EmailId) {
		emailId.click();
		emailId.clear();
		emailId.sendKeys(EmailId);

	}

	public void enteringInvalidEmail(String InvalidEmail) {
		emailId.sendKeys(InvalidEmail);

	}

	public void enteringMessage(String Message) {
		messagee.sendKeys(Message);

	}

	public void enteringTelephoneNum(String Telephonenum) {
		Telephone.sendKeys(Telephonenum);

	}

	public String invalidEmail() {
		return invalidemail.getText();
	}

	public String forenameRequired() {
		try {
			return Forenamerequired.getText();
		} catch (Exception e) {
			String ForName = null;
			return ForName;
		}
	}

	public String emailRequired() {
		try {
			return Emailrequired.getText();
		} catch (Exception e) {
			String Emailid = null;
			return Emailid;

		}
	}

	public String messageRequired() {
		try {
			return Messagerequired.getText();
		} catch (Exception e) {
			String Message = null;
			return Message;
		}
	}

	public void pagedown(WebDriver driver1) {
		Actions actions = new Actions(driver1);
		actions.sendKeys(Keys.PAGE_DOWN).perform();

	}

	public String successfulMessage() {
		return SuccessfulMessage.getText();

	}

	public String expectedSuccessfulMessage(String ForeName) {
        String expectedmessage = "Thanks " + ForeName + ", we appreciate your feedback.";
		return expectedmessage;
	}

}
