package jupitortoystestcases;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.Basepage;
import pages.Cartpage;
import pages.Shoppage;

public class Shoptest extends Basetest {
	
	@Test
	public  void verifyingCartItems() {
		
		// Adding items to the cart
		
		Basepage Bs=new Basepage(driver);
		Bs.clickShopBtn();
		
		Shoppage sp = new Shoppage(driver);
		sp.addStuffedfrogToCart();
		sp.addFluffybunnyTocart();
		sp.addValentinebearToCart();
		
		Cartpage Cp=new Cartpage(driver);
		Cp.clickCartBtn();
		
		// verifying the Subtotal for each product is correct
	
		assertEquals(Cp.getStuffedFrogSubtotal(),"$21.98");
		assertEquals(Cp.getValentineBearSubtotal(),"$44.97");
		assertEquals(Cp.getFluffyBunnySubtotal(),"$49.95");
		
		// Verifying price for each product
		assertEquals(Cp.getStuffedFrogPrice(),"$10.99");
		assertEquals(Cp.getFluffyBunnyPrice(),"$9.99");
		assertEquals(Cp.getValentineBearPrice(),"$14.99");

		// Verifying the total price
		assertEquals(Cp.gettotalPrice(),"Total: 116.9");
		
		

	}

	
	
		
	
}
