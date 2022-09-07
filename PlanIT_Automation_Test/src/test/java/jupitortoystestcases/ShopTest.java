package jupitortoystestcases;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ShopPage;

public class ShopTest extends BaseTest {
	
	@Test
	public  void verifyingCartItems() throws Exception  {
		
		//Navigating to the shop page
		HomePage homepage=new HomePage(driver);
		ShopPage shoppage=homepage.clickShopButton();
		
		
		// Adding items to the cart
		shoppage.buyItem("Stuffed Frog",2);
		shoppage.buyItem("Valentine Bear", 3);
		shoppage.buyItem("Fluffy Bunny", 5);
		
		//click on cart button
		CartPage cartpage=homepage.clickCartButton();
		
		// verifying the Subtotal for each product is correct
		assertEquals(cartpage.getItemSubtotal(" Stuffed Frog"),"$21.98");
		assertEquals(cartpage.getItemSubtotal(" Valentine Bear"),"$44.97");
		assertEquals(cartpage.getItemSubtotal(" Fluffy Bunny"),"$49.95");
		
		// Verifying price for each product
		assertEquals(cartpage.getItemPrice(" Stuffed Frog"),"$10.99");
		assertEquals(cartpage.getItemPrice(" Fluffy Bunny"),"$9.99");
		assertEquals(cartpage.getItemPrice(" Valentine Bear"),"$14.99");

		// Verifying the total price
		assertEquals(cartpage.getTotalPrice(),"Total: 116.9");
		
		//Removing stuffed frog from the cart 
		cartpage.removeStuffedFrog();
		cartpage.accept();
		assertEquals(cartpage.getStuffedFrog(),false);
		
	}
	
	}

	
	
		

