package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import data.ProductDetails;

public class ShopPage extends BasePage {

	By logIn = By.xpath("//i[(@class='icon icon-user icon-white')]");

	By logOut = By.xpath(".//span[(@class='action')]");

	public ShopPage(WebDriver driver) {

		super(driver);
	}

	public void buyItem(String itemName, int numberOfItems) {
		WebElement itemContainer = findItem(itemName);
		WebElement buyButton = itemContainer.findElement(By.xpath(".//a[text()='Buy']"));
		for (int i = numberOfItems; i > 0; i--) {
			buyButton.click();
		}

	}

	private WebElement findItem(String itemName) {
		return driver.findElement(By.xpath("//h4[text()='" + itemName + "']/ancestor::li"));

	}

	public void addItemstoCart(ProductDetails productdetails) {
		buyItem(productdetails.getitemName1(), 2);
		buyItem(productdetails.getitemName2(), 3);
		buyItem(productdetails.getitemName3(), 5);
	}

	public void addingItemsToCart(ProductDetails productdetails) {
		buyItem(productdetails.getitemName1(), 1);
		buyItem(productdetails.getitemName2(), 1);
	}

	public ProductDetails getProductDetails() {
		List<WebElement> productPrices = driver.findElements(By.xpath("//span[(@class='product-price ng-binding')]"));
		List<WebElement> productNames = driver.findElements(By.xpath("//h4[(@class='product-title ng-binding')]"));
		ProductDetails allProductDetails = new ProductDetails();
		double[] itemPrices = new double[productPrices.size()];
		String[] itemNames = new String[productNames.size()];
		for (int i = 0; i < productPrices.size(); i++) {
			itemPrices[i] = Double.valueOf(productPrices.get(i).getText().substring(1));
			itemNames[i] = productNames.get(i).getText();
		}
		allProductDetails.setProductNames(itemNames);
		allProductDetails.setProductPrices(itemPrices);
		return allProductDetails;

	}

	public String[] getProductPrices() {
		List<WebElement> prices = driver.findElements(By.xpath("//span[(@class='product-price ng-binding')]"));
		String[] itemPrice = new String[prices.size()];
		for (int i = 0; i < prices.size(); i++) {
			itemPrice[i] = prices.get(i).getText();
		}
		return itemPrice;
	}

	public String[] getProductNames() {
		List<WebElement> productNames = driver.findElements(By.xpath("//h4[(@class='product-title ng-binding')]"));
		String[] itemName = new String[productNames.size()];
		for (int i = 0; i < productNames.size(); i++) {
			itemName[i] = productNames.get(i).getText();
		}
		return itemName;

	}

}
