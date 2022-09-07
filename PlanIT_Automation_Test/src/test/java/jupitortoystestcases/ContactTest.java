package jupitortoystestcases;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.ContactPage;
import pages.ContactSuccessfulPage;

public class ContactTest extends BaseTest {
	    String foreName = "John";

	   @Test
        public void verifyingErrorMessages() {

		// Navigating to contact page
		BasePage basepage = new BasePage(driver);
		basepage.clickContactButton();

		// Submitting the form in contact page without any data
		ContactPage contactpage = new ContactPage(driver);
		contactpage.clickSubmitButton();

		// checking forename error message is displayed
		assertEquals(contactpage.getForenameError(), "Forename is required");

		// checking email error message is displayed
		assertEquals(contactpage.getEmailError(), "Email is required");

		// checking message error message is displayed
		assertEquals(contactpage.getMessageError(), "Message is required");

		// Entering invalidEmailid
		contactpage.enterInvalidEmail("john");

		// Verifying the InvalidEmailid error Message
		assertEquals(contactpage.invalidEmail(), "Please enter a valid email");

		// Populating mandatory fields in the contact page
		contactpage.enterforeName("John");
		contactpage.enterSurname("Skyes");
		contactpage.enterEmail("John@gmail.com");
		contactpage.enterTelephoneNum("021234567");
		contactpage.enterMessage("Hello");

		// Verifying the error messages are not present
		assertNull(contactpage.getForenameError());
		assertNull(contactpage.getEmailError());
		assertNull(contactpage.getMessageError());

	    }

	    @Test(invocationCount=5)
	    public void validateSuccess() throws Exception {

		// Populating Mandatory fields
		BasePage basepage = new BasePage(driver);
		basepage.clickContactButton();
		ContactPage contactpage= new ContactPage(driver);
		contactpage.enterforeName(foreName);
		contactpage.enterSurname("Skyes");
		contactpage.enterEmail("John@email.com");
		contactpage.enterTelephoneNum("021234567");
		contactpage.enterMessage("Hello");
		
		// Submitting the form with valid mandatory input
		contactpage.clickSubmitButton();
		
		// Verifying the SuccessfulMessage
		ContactSuccessfulPage contactsuccessfulpage=new ContactSuccessfulPage(driver);
		assertEquals(contactsuccessfulpage.getSuccessfulMessage(),  "Thanks " + foreName + ", we appreciate your feedback.");
	
	    
	    }

}
