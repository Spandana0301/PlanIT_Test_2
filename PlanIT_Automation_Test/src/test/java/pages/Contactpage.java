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

	@FindBy(xpath = "//a[contains(@class,'primary')]")
	public WebElement submit;

	@FindBy(id = "forename")
	public WebElement foreName;

	@FindBy(id = "surname")
	public WebElement surname;

	@FindBy(id = "email")
	public WebElement emailId;

	@FindBy(id = "telephone")
	public WebElement telephone;

	@FindBy(name = "message")
	public WebElement messagee;

	@FindBy(xpath = "//span[@id='forename-err']")
	public WebElement forenameerror;

	@FindBy(xpath = "//span[@id='email-err']")
	public WebElement emailerror;

	
	@FindBy(xpath = "//span[@id='message-err']")
	public WebElement messageerror;

	@FindBy(xpath = "//div[contains(@class,'alert alert-success')]")
	public WebElement successfulMessage;

	


	public void clickSubmitBtn() {
		submit.click();

	}

	public void enterforeName(String ForName) {
		foreName.sendKeys(ForName);
	}

	public void enterSurname(String Surname) {
		surname.sendKeys(Surname);
	}

	public void enterEmail(String EmailId) {
		emailId.click();
		emailId.clear();
		emailId.sendKeys(EmailId);

	}

	public void enterInvalidEmail(String InvalidEmail) {
		emailId.sendKeys(InvalidEmail);

	}

	public void enterMessage(String Message) {
		messagee.sendKeys(Message);

	}

	public void enterTelephoneNum(String Telephonenum) {
		telephone.sendKeys(Telephonenum);

	}

	public String invalidEmail() {
		return emailerror.getText();
	}

	public String getForenameError() {
		try {
			return forenameerror.getText();
		} catch (Exception e) {
			String ForName = null;
			return ForName;
		}
	}

	public String getEmailError() {
		try {
			return emailerror.getText();
		} catch (Exception e) {
			String Emailid = null;
			return Emailid;

		}
	}

	public String getMessageError() {
		try {
			return messageerror.getText();
		} catch (Exception e) {
			String Message = null;
			return Message;
		}
	}

	public void pagedown(WebDriver driver1) {
		Actions actions = new Actions(driver1);
		actions.sendKeys(Keys.PAGE_DOWN).perform();

	}

	public String getSuccessfulMessage() {
		return successfulMessage.getText();

	}

}
