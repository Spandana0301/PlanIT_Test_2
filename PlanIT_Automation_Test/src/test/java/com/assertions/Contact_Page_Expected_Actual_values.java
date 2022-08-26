package com.assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.base.TestBase;

public class Contact_Page_Expected_Actual_values extends TestBase{

	WebDriver driver;
	
	public Contact_Page_Expected_Actual_values (WebDriver driver) {
		this.driver=driver;
	}

	//Expected error messages
	public  String messageerror = "Message is required";
	public  String forenameerror = "Forename is required";
	public  String emailerror = "Email is required";
	
	public Boolean notDisplayed=false;
	
	
	
	//Actual error Messages
	public String forNameError() {
	String forname = driver.findElement(By.xpath("//span[@id='forename-err']")).getText();
		return forname;
	}
	
    public String emailError() {
	String email = driver.findElement(By.xpath("//span[@id='email-err']")).getText();
		return email;
	}

    public String messageError() {
	String errormessage = driver.findElement(By.xpath("//span[@id='message-err']")).getText();
		return errormessage;
	}
	
    
    public Boolean fornamePresent() {
	Boolean fornamepresent =driver.getPageSource().contains(forenameerror) ;
		return fornamepresent;
	}
    public Boolean emailPresent() {
	Boolean emailpresent = driver.getPageSource().contains(emailerror);
		return emailpresent;
	}
    public Boolean messagePresent() {
	Boolean messagepresent = driver.getPageSource().contains(messageerror);
		return messagepresent;
	}
	
	
	
}
