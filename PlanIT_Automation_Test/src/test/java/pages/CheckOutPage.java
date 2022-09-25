package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import data.DeliveryDetails;
import data.PaymentDetails;

public class CheckOutPage extends BasePage {

	By foreName = By.id("forename");

	By surname = By.id("surname");

	By emailId = By.id("email");

	By telephone = By.id("telephone");

	By Address = By.name("address");

	By card = By.id("cardType");

	By cardnumber = By.id("card");

	By submitButton = By.id("checkout-submit-btn");

	public CheckOutPage(WebDriver driver) {

		super(driver);
	}

	public void enterforeName(String forName) {
		driver.findElement(foreName).sendKeys(forName);
	}

	public void enterSurname(String surName) {
		driver.findElement(surname).sendKeys(surName);
	}

	public void enterEmail(String email) {
		driver.findElement(emailId).sendKeys(email);

	}

	public void enterTelephoneNum(String telephoneNumber) {
		driver.findElement(telephone).sendKeys(telephoneNumber);

	}

	public void enterAddress(String address) {
		driver.findElement(Address).sendKeys(address);
	}

	public void cardSelect(String Cardselect) {
		WebElement element = driver.findElement(card);
		Select select = new Select(element);
		select.selectByValue(Cardselect);

	}

	public void enterCardNumber(String cardNumber) {
		driver.findElement(cardnumber).sendKeys(cardNumber);
	}

	public void clickCheckoutSubmitButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement submitbutton = driver.findElement(submitButton);
		js.executeScript("arguments[0].scrollIntoView();", submitbutton);
		submitbutton.click();
	}

	public void enteringDeliveryDetails(DeliveryDetails deliverydetails) {
		enterforeName(deliverydetails.getForeName());
		enterSurname(deliverydetails.getSurName());
		enterEmail(deliverydetails.getEmail());
		enterTelephoneNum(deliverydetails.getTelephoneNumber());
		enterAddress(deliverydetails.getAddress());
	}

	public void enteringPaymentDetails(PaymentDetails paymentdetails) {
		cardSelect(paymentdetails.getCardSelect());
		enterCardNumber(paymentdetails.getCardNumber());
	}

}
