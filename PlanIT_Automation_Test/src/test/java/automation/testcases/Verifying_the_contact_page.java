package automation.testcases;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import com.assertions.Contact_Page_Expected_Actual_values;
import com.base.TestBase;
import com.pages.Contact_page;
import com.pages.Populating_fields_in_contact_page;

public class Verifying_the_contact_page extends TestBase {
	@Test

	public void validateErrors()  {

		// Navigating to contact page
		Contact_page cp = new Contact_page(driver);
		cp.clickContact();

		// Submitting the form in contact page without any data
		Populating_fields_in_contact_page pc = new Populating_fields_in_contact_page(driver);
		pc.pagedown(driver);
		pc.clickSubmitBtn();

		Contact_Page_Expected_Actual_values validations = new Contact_Page_Expected_Actual_values(driver);
		// checking forename error message is displayed
		assertEquals(validations.forNameError(), validations.forenameerror);

		// checking email error message is displayed
		assertEquals(validations.emailError(), validations.emailerror);

		// checking message error message is displayed
		assertEquals(validations.messageError(), validations.messageerror);

		// Populating mandetory fields in the contact page
		pc.enteringName();
		pc.enteringEmail();
		pc.enteringMessage();

		// Verifing the error messages are not present
		assertEquals(validations.fornamePresent(),validations.notDisplayed);
		
		assertEquals(validations.emailPresent(), validations.notDisplayed);
		
        assertEquals(validations.messagePresent(), validations.notDisplayed);

	}

}
