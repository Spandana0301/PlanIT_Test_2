package automation.testcases;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import com.assertions.Cart_Page_Expected_Actual_values;
import com.base.TestBase;
import com.pages.Adding_items_in_cart_page;


public class Verifying_items_in_cart extends TestBase {

	@Test
	public  void verifying_Cart_Items() {
		
		// Adding items to the cart
		Adding_items_in_cart_page ai = new Adding_items_in_cart_page(driver);
		ai.clickShopBtn();
		ai.addingStuffedfrogToCart();
		ai.addingFluffybunnyTocart();
		ai.addingValentinebearToCart();
		ai.clickCartBtn();
		
		// verifying the Subtotal for each product is correct
		Cart_Page_Expected_Actual_values result=new Cart_Page_Expected_Actual_values(driver);
		assertEquals(result.stuffedFrogSubtotal(),result.StuffedFrogsubtotal);
		assertEquals(result.valentineBearsubtotal(), result.ValentineBearsubtotal);
		assertEquals(result.fluffybunnySubtotal(), result.FluffyBunnysubtotal);
		
		// Verifying price for each product
		assertEquals( result.stuffedFrogPrices(),result.StuffedFrogprice);
		assertEquals( result.fluffyBunnyPrices(),result.FluffyBunnyprice);
		assertEquals(result.valentineBearPrices(), result.ValentineBearprice );

		// Verifying the total price
		assertEquals( result.totalPrice(),result.price);
		
		

	}
}
