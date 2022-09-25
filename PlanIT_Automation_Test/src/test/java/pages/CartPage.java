package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import data.ProductDetails;

public class CartPage extends BasePage {

	By totalPrice = By.xpath("//strong[@class='total ng-binding']");

	By checkOut = By.xpath("//a[text()='Check Out']");

	By emptycart = By.xpath("//a[@class='btn btn-danger ng-scope']");

	By cartEmptyMessage = By.className("alert"); 
	

	public CartPage(WebDriver driver) {
		super(driver);

	}

	public String getItemSubtotal(String itemName) {
		WebElement itemContainer = findItem(itemName);
		WebElement productSubtotal = itemContainer.findElement(By.xpath(".//td[4]"));
		String itemSubtotal = productSubtotal.getText();
		return itemSubtotal;

	}

	private WebElement findItem(String itemName) {
		return driver.findElement(By.xpath("//tr[./td[normalize-space(text())='" + itemName + "']]"));
	}

	public String getItemPrice(String itemName) {
		WebElement itemContainer = findItem(itemName);
		WebElement productPrice = itemContainer.findElement(By.xpath(".//td[2]"));
		String itemPrice = productPrice.getText();
		return itemPrice;

	}

	public String getItemQuantity(String itemName) {
		WebElement itemContainer = findItem(itemName);
		WebElement productQuantity = itemContainer.findElement(By.xpath(".//td[3]/input"));
		String itemQuantity = productQuantity.getAttribute("value");
		return itemQuantity;

	}

	public String getTotalPrice() {
		return driver.findElement(totalPrice).getText();
	}

	public int getDecimalsinTotalPrice() {

		String[] splitter = driver.findElement(totalPrice).getText().substring(7).split("\\.");
		return splitter[1].length();
	}

	public void clickRemoveItem(String itemName) {
		WebElement itemContainer = findItem(itemName);
		WebElement removingItem = itemContainer.findElement(By.xpath(".//i[@class='icon-remove icon-white']"));
		removingItem.click();
	}

	public boolean checkingItemInCart(String itemName) {

		try {
			WebElement itemContainer = findItem(itemName);
			return itemContainer.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean checkingIteminCart(String itemName) {
		WebElement itemContainer = findItem(itemName);
		return itemContainer.isDisplayed();
	}

	public void ClickCheckOutButton() {

		driver.findElement(checkOut).click();
	}

	public void clickEmptyCartButton() {
		driver.findElement(emptycart).click();
	}

	public String getcartEmptyMessage() {
		return driver.findElement(cartEmptyMessage).getText();
	}

	public void findQuantity(String itemName, int quantity) {
		WebElement itemContainer = findItem(itemName);
		WebElement productQuantity = itemContainer.findElement(By.xpath(".//td[3]/input"));
		productQuantity.click();
		productQuantity.clear();
		productQuantity.sendKeys(String.valueOf(quantity));

	}

	public void changingQuantities(ProductDetails productdetails) {
		findQuantity(productdetails.getitemName1(), productdetails.getQuantityForItem1());
		findQuantity(productdetails.getitemName2(), productdetails.getQuantityForItem2());
	}

}
