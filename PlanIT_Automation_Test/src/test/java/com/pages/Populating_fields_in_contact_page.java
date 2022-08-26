package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.TestBase;

public class Populating_fields_in_contact_page extends TestBase{

	@FindBy(xpath = "//a[contains(@class,'primary')]")
	public  WebElement submit;

	@FindBy(id = "forename")
	public WebElement namep;

	@FindBy(id = "email")
	public  WebElement emailid;

	@FindBy(name = "message")
	public  WebElement messagee;

	public  Populating_fields_in_contact_page(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public  void clickSubmitBtn() {
		submit.click();

	}

	public  void enteringName() {
		namep.sendKeys(TestBase.property.getProperty("name"));
	}
	
	public  void enteringEmail() {
		emailid.sendKeys(TestBase.property.getProperty("email"));
	}
	public  void enteringMessage() {
		messagee.sendKeys(TestBase.property.getProperty("message"));

	}
	
	public  void pagedown(WebDriver driver1) {
		Actions actions = new Actions(driver1);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		
	}

}
