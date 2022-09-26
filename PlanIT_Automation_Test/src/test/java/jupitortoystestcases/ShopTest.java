package jupitortoystestcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import data.DeliveryDetails;
import data.LogInDetails;
import data.PaymentDetails;
import data.ProductDetails;
import pages.CartPage;
import pages.CheckOutPage;
import pages.CheckoutSuccessfulPage;
import pages.ContactSuccessfulPage;
import pages.EmptyCartPopUp;
import pages.HomePage;
import pages.LogInPopUp;
import pages.LogOutPopUp;
import pages.RemoveItemPopUp;
import pages.ShopPage;

public class ShopTest extends BaseTest {
	ProductDetails productdetails = new ProductDetails("Stuffed Frog", "Valentine Bear", "Fluffy Bunny");
	ProductDetails productdetailsforQuantity = new ProductDetails("Stuffed Frog", "Valentine Bear", 5, 11);
	PaymentDetails paymentdetails = new PaymentDetails("Visa", "2345678998765432");
	DeliveryDetails deliverydetails = new DeliveryDetails("John", "Skyes", "John@gmail.com", "045678345","110 Keilor Road, Essendon, VIC -3041");
	LogInDetails logindetails = new LogInDetails("John@gmail.com", "letmein");

	@Test
	public void verifyingCartItems() {
		HomePage homepage = new HomePage(driver);
		CheckOutPage checkoutpage = new CheckOutPage(driver);

		// Navigating to the shop page ContactSuccessfulPage
		ContactSuccessfulPage contactsuccessfulpage = new ContactSuccessfulPage(driver);
		CheckoutSuccessfulPage checkoutsuccessfulpage = new CheckoutSuccessfulPage(driver);

		// click on shop button
		ShopPage shoppage = homepage.clickShopButton();

		// Adding items to the cart
		shoppage.addItemstoCart(productdetails);

		// click on cart button
		CartPage cartpage = shoppage.clickCartButton();

		// verifying the Subtotal for each product is correct
		assertEquals(cartpage.getItemSubtotal(productdetails.getitemName1()), "$21.98");
		assertEquals(cartpage.getItemSubtotal(productdetails.getitemName2()), "$44.97");
		assertEquals(cartpage.getItemSubtotal(productdetails.getitemName3()), "$49.95");

		// Verifying price for each product
		assertEquals(cartpage.getItemPrice(productdetails.getitemName1()), "$10.99");
		assertEquals(cartpage.getItemPrice(productdetails.getitemName2()), "$14.99");
		assertEquals(cartpage.getItemPrice(productdetails.getitemName3()), "$9.99");

		// Verifying items Quantity
		assertEquals(cartpage.getItemQuantity(productdetails.getitemName1()), "2");
		assertEquals(cartpage.getItemQuantity(productdetails.getitemName2()), "3");
		assertEquals(cartpage.getItemQuantity(productdetails.getitemName3()), "5");

		// Verifying the total price decimal places
		assertTrue(cartpage.getDecimalsinTotalPrice() <= 2);

		// Verifying the total price
		assertEquals(cartpage.getTotalPrice(), "Total: 116.9");

		// Exercise 10 Removing item from the cart
		cartpage.clickRemoveItem(productdetails.getitemName1());
		RemoveItemPopUp removeitempopup = new RemoveItemPopUp(driver);
		removeitempopup.clickYesButton();

		// verifying removed item from the cart
		assertFalse(cartpage.checkingItemInCart(productdetails.getitemName1()));

		// Verifying the other 2 items remain in the cart
		assertTrue(cartpage.checkingIteminCart(productdetails.getitemName2()));
		assertTrue(cartpage.checkingIteminCart(productdetails.getitemName3()));

		// Click on checkout button
		cartpage.ClickCheckOutButton();

		// Enter the fields
		checkoutpage.enteringDeliveryDetails(deliverydetails);
		checkoutpage.enteringPaymentDetails(paymentdetails);

		// click on submit button
		checkoutpage.clickCheckoutSubmitButton();

		// verifying the successful message and order number
		assertEquals(contactsuccessfulpage.getSuccessfulMessage(), "Thanks " + deliverydetails.getForeName()+ ", your order has been accepted. Your order nuumber is " + checkoutsuccessfulpage.getOrderNumber());

	}

	// Exercise 12 quantity validation
	@Test
	public void quntityValidation() {
		HomePage homepage = new HomePage(driver);
		ShopPage shoppage = homepage.clickShopButton();
		shoppage.addingItemsToCart(productdetailsforQuantity);
		CartPage cartpage = shoppage.clickCartButton();
		cartpage.changingQuantities(productdetailsforQuantity);
		assertTrue(cartpage.getDecimalsinTotalPrice() <= 2);
		
	}

	// Exercise 14 verifying product prices > $11.00
	@Test
	public void validateProductPrices() {
		HomePage homepage = new HomePage(driver);
		ShopPage shoppage = homepage.clickShopButton();
		ProductDetails allProductDetails = shoppage.getProductDetails();
		SoftAssert sa = new SoftAssert();
		for (int i = 0; i < allProductDetails.getNumberofproducts(); i++) {
			sa.assertTrue(allProductDetails.getProductPrices(i) > 11.00, "Product price for: "+ allProductDetails.getProductNames(i) + " is $" + allProductDetails.getProductPrices(i));
		}
		sa.assertAll();
	}

	// Exercise17 Login and Logout from Shop Page
	@Test
	public void loginAndLogOutFromShopPage() {
		HomePage homepage = new HomePage(driver);
		ShopPage shoppage = homepage.clickShopButton();
		shoppage.clickLoginButton();
		LogInPopUp loginpopup = new LogInPopUp(driver);
		loginpopup.enterUserName(logindetails.getUserName());
		loginpopup.enterPassword(logindetails.getPassword());
		loginpopup.clickLogInButton();
		shoppage.clickLogoutButton();
		LogOutPopUp logoutpopup = new LogOutPopUp(driver);
		logoutpopup.clickLogOutButtonOnPopUp();
	}

	// Exercise 18 empty cart
	@Test
	public void emptyCart() {
		HomePage homepage = new HomePage(driver);
		ShopPage shoppage = homepage.clickShopButton();
		shoppage.addItemstoCart(productdetails);
		CartPage cartpage = shoppage.clickCartButton();
		cartpage.clickEmptyCartButton();
		EmptyCartPopUp emptycartpopup = new EmptyCartPopUp(driver);
		emptycartpopup.clickYesButton();
		assertEquals(cartpage.getcartEmptyMessage(), "×\r\n"+ "Your cart is empty - there's nothing to see here.");

	}

	// Exercise 19 Click No for Remove item in the cart
	@Test
	public void notRemovingItemInCart() {
		HomePage homepage = new HomePage(driver);
		ShopPage shoppage = homepage.clickShopButton();
		shoppage.addItemstoCart(productdetails);
		CartPage cartpage = shoppage.clickCartButton();
		cartpage.clickRemoveItem(productdetails.getitemName1());
		RemoveItemPopUp removeitempopup = new RemoveItemPopUp(driver);
		removeitempopup.clickNoButton();
		assertTrue(cartpage.checkingIteminCart(productdetails.getitemName1()));

	}

}
