package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmptyCartPopUp extends BaseModal {

	By yes = By.xpath(".//a[@class='btn btn-success']");

	By no = By.xpath(".//a[@class='btn btn-cancel btn-danger']");

	public EmptyCartPopUp(WebDriver driver) {
		super(driver);

	}

	public void clickYesButton() {
		modal.findElement(yes).click();
	}

	public void clickNoButton() {
		modal.findElement(no);
	}

}
