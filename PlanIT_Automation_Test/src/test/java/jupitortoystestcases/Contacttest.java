package jupitortoystestcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import org.testng.annotations.Test;

import pages.Basepage;
import pages.Contactpage;

public class Contacttest extends Basetest {
	    String foreName = "John";

	    @Test
        public void verifyingErrorMessages() {

		// Navigating to contact page
		Basepage Bp = new Basepage(driver);
		Bp.clickContactBtn();

		// Submitting the form in contact page without any data
		Contactpage cp = new Contactpage(driver);
		cp.pagedown(driver);
		cp.clickSubmitBtn();

		// checking forename error message is displayed
		assertEquals(cp.getForenameError(), "Forename is required");

		// checking email error message is displayed
		assertEquals(cp.getEmailError(), "Email is required");

		// checking message error message is displayed
		assertEquals(cp.getMessageError(), "Message is required");

		// Entering invalidEmailid
		cp.enterInvalidEmail("john");

		// Verifying the InvalidEmailid error Message
		assertEquals(cp.invalidEmail(), "Please enter a valid email");

		// Populating mandatory fields in the contact page
		cp.enterforeName("John");
		cp.enterSurname("Skyes");
		cp.enterEmail("John@gmail.com");
		cp.enterTelephoneNum("021234567");
		cp.enterMessage("Hello");

		// Verifying the error messages are not present
		assertNull(cp.getForenameError());
		assertNull(cp.getEmailError());
		assertNull(cp.getMessageError());

	    }

	    @Test(invocationCount = 5)
	    public void validateSuccess() {

		// Populating Mandatory fields
		Basepage Bp = new Basepage(driver);
		Bp.clickContactBtn();
		Contactpage cp = new Contactpage(driver);
		cp.enterforeName(foreName);
		cp.enterSurname("Skyes");
		cp.enterEmail("John@email.com");
		cp.enterTelephoneNum("021234567");
		cp.enterMessage("Hello");
		cp.pagedown(driver);

		// Submitting the form with valid mandatory input
		cp.clickSubmitBtn();

		// Verifying the SuccessfulMessage

		assertEquals(cp.getSuccessfulMessage(), expectedSuccessfulMessage());

	    }

	    public String expectedSuccessfulMessage() {
		String expectedmessage = "Thanks " + foreName + ", we appreciate your feedback.";
		return expectedmessage;
	    }

}
