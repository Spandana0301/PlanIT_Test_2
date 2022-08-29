package jupitortoystestcases;

import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertNull;
import org.testng.annotations.Test;
import pages.Contactpage;
import pages.Homepage;

public class ContactPage extends Homepage {
@Test

	public void verifyingErrorMessages()  {

		// Navigating to contact page
		Contactpage cp = new Contactpage(driver);
		cp.clickContactBtn();
		
		// Submitting the form in contact page without any data
		
		cp.pagedown(driver);
		cp.clickSubmitBtn();
       
		// checking forename error message is displayed
		assertEquals(cp.forenameRequired(),"Forename is required");
		
		// checking email error message is displayed
		assertEquals(cp.emailRequired(),"Email is required");
		
		// checking message error message is displayed
		assertEquals(cp.messageRequired(),"Message is required" );
		
		// Entering invalidEmailid
		cp.enteringInvalidEmail("john");
		
		//Verifying the InvalidEmailid error Message
		assertEquals(cp.invalidEmail(),"Please enter a valid email" );
		
		// Populating mandatory fields in the contact page
		cp.enteringforeName("John");
		cp.enteringSurname("Skyes");
		cp.enteringEmail("John@gmail.com");
		cp.enteringTelephoneNum("021234567");
		cp.enteringMessage("Hello");
	
		// Verifying the error messages are not present
		assertNull(cp.forenameRequired());
		assertNull(cp.emailRequired());
		assertNull(cp.messageRequired());
	
	}
        
       @Test(invocationCount=5)
        public void validateSuccess() {
    	String forName="John";
    	//Populating Mandatory fields
        Contactpage cp = new Contactpage(driver);
        cp.clickContactBtn();
        cp.enteringforeName(forName);
        cp.enteringSurname("Skyes");
		cp.enteringEmail("John@email.com");
		cp.enteringTelephoneNum("021234567");
		cp.enteringMessage("Hello");
		cp.pagedown(driver);
		
		// Submitting the form with valid mandatory input
		cp.clickSubmitBtn();
		
		//Verifying the SuccessfulMessage
        assertEquals(cp.successfulMessage(),cp.expectedSuccessfulMessage(forName));
		

        }

}
