package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class Contactpage {
   
	
	// expected values
	public  String messageerror = "Message is required";
	public  String forenameerror = "Forename is required";
	public  String emailerror = "Email is required";
	
	
	@FindBy(xpath = "//a[contains(@href,'contact')]")
	public  WebElement contact;
	
	@FindBy(xpath = "//a[contains(@class,'primary')]")
	public  WebElement submit;

	@FindBy(id = "forename")
	public WebElement foreName;

	@FindBy(id = "email")
	public  WebElement emailId;

	@FindBy(name = "message")
	public  WebElement messagee;
	
	@FindBy(xpath="//span[@id='forename-err']")
	public WebElement Forenamerequired;
	
	@FindBy(xpath="//span[@id='email-err']")
	public WebElement Emailrequired;
	
	@FindBy(xpath="//span[@id='message-err']")
	public WebElement Messagerequired;
	
	@FindBy(xpath = "//strong[contains(@class,'ng-binding')]")
	public WebElement SuccessfulMessage;
	

	
	
	public Contactpage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public void clickContactBtn() {

		contact.click();	
	}
	public  void clickSubmitBtn() {
		submit.click();

	}

	public  void enteringName(String ForName) {
		foreName.sendKeys(ForName);
	}
	
	public  void enteringEmail(String EmailId) {
		emailId.sendKeys(EmailId);
	}
	public  void enteringMessage(String Message) {
		messagee.sendKeys(Message);

	}
	
	public String fornameRequired() {
		try {
			//System.out.println("b1");
		return Forenamerequired.getText();
		
		}
		
		catch (Exception e){
			//System.out.println("b2");
			String forname = null;
			//System.out.println("b3");
			return forname;
			
		}
		
	}
	
	public String emailRequired() {
		try {
		return Emailrequired.getText();
	}
	catch (Exception e) {
		String Emailid = null;
		return Emailid;
			
	}
	}
	
	public String messageRequired() {
		try {
			return Messagerequired.getText();
		}
		catch (Exception e) {
			String Message=null;
			return Message;
		}
	}
	
	public  void pagedown(WebDriver driver1) {
		Actions actions = new Actions(driver1);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		
	}
	
	public String successfulMessage() {
	   return SuccessfulMessage.getText();
		
	}
	
	public String expectedMessage() {
		 String s1= "Thanks ";
		 String s2= ", we appreciate your feedback.";
		 String s= s1+ foreName.getText()+s2;
		 return s;
	}
	
}
