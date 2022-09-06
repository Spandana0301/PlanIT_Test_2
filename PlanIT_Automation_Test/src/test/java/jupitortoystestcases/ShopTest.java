package jupitortoystestcases;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CartPage;
import pages.ShopPage;

public class ShopTest extends BaseTest {
	
	@Test
	public  void verifyingCartItems()  {
		
		//Navigating to the shop page
		BasePage basepage=new BasePage(driver);
		basepage.clickShopButton();
		
		// Adding items to the cart
		ShopPage shoppage = new ShopPage(driver);
		shoppage.addStuffedfrogToCart(2);
		shoppage.addValentinebearToCart(3);
		shoppage.addFluffybunnyTocart(5);
		
		//click on cart button
		CartPage cartpage=new CartPage(driver);
		cartpage.clickCartBtn();
		
		// verifying the Subtotal for each product is correct
		assertEquals(cartpage.getStuffedFrogSubtotal(),"$21.98");
		assertEquals(cartpage.getValentineBearSubtotal(),"$44.97");
		assertEquals(cartpage.getFluffyBunnySubtotal(),"$49.95");
		
		// Verifying price for each product
		assertEquals(cartpage.getStuffedFrogPrice(),"$10.99");
		assertEquals(cartpage.getValentineBearPrice(),"$14.99");
		assertEquals(cartpage.getFluffyBunnyPrice(),"$9.99");

		// Verifying the total price
		assertEquals(cartpage.gettotalPrice(),"Total: 116.9");
		
		//Removing stuffed frog from the cart 
		cartpage.removeItem();
		cartpage.accept();
		assertEquals(cartpage.checkRemovedItem(),false);
		
	}
	
	}

	
	
		

