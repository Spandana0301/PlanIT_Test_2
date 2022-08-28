package automation.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.Contactpage;

public class Verifying_the_contact_page extends TestBase {
	/*@Test()

	public void validateErrors()  {

		// Navigating to contact page
		Contactpage cp = new Contactpage(driver);
		cp.clickContactBtn();
		System.out.println("a1");
		// Submitting the form in contact page without any data
		
		cp.pagedown(driver);
		cp.clickSubmitBtn();
       
		System.out.println("a2");
		// checking forename error message is displayed
		assertEquals(cp.forenameerror,cp.fornameRequired());
		System.out.println("a3");
		// checking email error message is displayed
		assertEquals(cp.emailerror,cp.emailRequired());
		System.out.println("a4");
		// checking message error message is displayed
		assertEquals(cp.messageerror,cp.messageRequired() );
		System.out.println("a5");
		// Populating mandetory fields in the contact page
		cp.enteringName("John");
		cp.enteringEmail("John@email.com");
		cp.enteringMessage("Hello");
		System.out.println("a6");
		// Verifing the error messages are not present
		assertNull(cp.fornameRequired());
		System.out.println("a7");
		assertNull(cp.emailRequired());
		System.out.println("a8");
		assertNull(cp.messageRequired());
		System.out.println("a9");
	}*/
        
       @Test(invocationCount=1)
        public void validateSuccess() {
        Contactpage cp = new Contactpage(driver);
        cp.clickContactBtn();
        cp.enteringName("John");
		cp.enteringEmail("John@email.com");
		cp.enteringMessage("Hello");
		cp.pagedown(driver);
		
		// Submitting the form with valid mandetory input
		cp.clickSubmitBtn();
		 
		
        assertEquals(cp.expectedMessage(),cp.successfulMessage());
		

        }

}
