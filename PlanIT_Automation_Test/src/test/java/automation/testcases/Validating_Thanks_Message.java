package automation.testcases;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import com.assertions.Cart_Page_Expected_Actual_values;
import com.base.TestBase;
import com.pages.Contact_page;
import com.pages.Populating_fields_in_contact_page;



public class Validating_Thanks_Message extends TestBase {

	@Test(invocationCount=5)

	public void validateSuccess()  {
		
		// Navigating to Contact page from Home page
		Contact_page cp = new Contact_page(driver);
		cp.clickContact();
		
		// Populating contact form with mandetory fields
		Populating_fields_in_contact_page mf = new Populating_fields_in_contact_page(driver);
		mf.enteringName();
		mf.enteringEmail();
		mf.enteringMessage();
		mf.pagedown(driver);
		
		// Submitting the form with valid mandetory input
		mf.clickSubmitBtn();
		
		// Verifying the successful submission message
		 
		Cart_Page_Expected_Actual_values expectedresult=new Cart_Page_Expected_Actual_values(driver);
        assertEquals(expectedresult.actualSucessfullMessage(), expectedresult.expectedsuccessfulmes);
		
		
	}

}
