package jupitortoystestcases;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.Shoppage;

public class ShopPage extends Homepage {

	@Test
	public  void verifyingCartItems() {
		
		// Adding items to the cart
		Shoppage sp = new Shoppage(driver);
		sp.clickShopBtn();
		sp.addingStuffedfrogToCart();
		sp.addingFluffybunnyTocart();
		sp.addingValentinebearToCart();
		sp.clickCartBtn();
		
		// verifying the Subtotal for each product is correct
	
		assertEquals(sp.stuffedFrogSubtotal(),"$21.98");
		assertEquals(sp.valentineBearSubtotal(),"$44.97");
		assertEquals(sp.fluffyBunnySubtotal(),"$49.95");
		
		// Verifying price for each product
		assertEquals(sp.stuffedFrogPrice(),"$10.99");
		assertEquals(sp.fluffyBunnyPrice(),"$9.99");
		assertEquals(sp.valentineBearPrice(),"$14.99");

		// Verifying the total price
		assertEquals(sp.totalPrice(), 116.9);
		
		

	}

	
	
		
	
}
