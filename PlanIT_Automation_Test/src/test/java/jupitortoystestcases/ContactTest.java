package jupitortoystestcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import data.ContactDetails;
import data.DataProviderforcontact;
import pages.BasePage;
import pages.ContactPage;
import pages.ContactSuccessfulPage;

public class ContactTest extends BaseTest {
	ContactDetails contactdetails = new ContactDetails("John", "Skys", "John@gmail.com", "0459354577", "Hello");

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
		contactdetails.setEmail("John");
		contactpage.enterInvalidEmail(contactdetails.getEmail());

		// Verifying the InvalidEmailid error Message
		assertEquals(contactpage.invalidEmail(), "Please enter a valid email");
		contactdetails.setEmail("John@gmail.com");

		// Populating mandatory fields in the contact page
		contactpage.fillingTheForm(contactdetails);

		// Verifying the error messages are not present
		assertNull(contactpage.getForenameError());
		assertNull(contactpage.getEmailError());
		assertNull(contactpage.getMessageError());

	}

	// Verifying Successful message 
	@Test(invocationCount = 5)
	public void validateSuccess() {
		// Click on contact Button
		BasePage basepage = new BasePage(driver);
		basepage.clickContactButton();

		// Populating Mandatory fields
		ContactPage contactpage = new ContactPage(driver);
		contactpage.fillingTheForm(contactdetails);

		// Submitting the form with valid mandatory input
		contactpage.clickSubmitButton();

		// Verifying the SuccessfulMessage
		ContactSuccessfulPage contactsuccessfulpage = new ContactSuccessfulPage(driver);
		assertEquals(contactsuccessfulpage.getSuccessfulMessage(),"Thanks " + contactdetails.getForeName() + ", we appreciate your feedback.");

	}
	// Excercise 15 data provider for contact details

	@Test(dataProvider = "contactDetails")
	public void enteringDetails(String foreName, String surName, String email, String telephoneNumber, String message){
		BasePage basepage = new BasePage(driver);
		basepage.clickContactButton();
		ContactPage contactpage = new ContactPage(driver);
		contactpage.enterforeName(foreName);
		contactpage.enterSurname(surName);
		contactpage.enterEmail(email);
		contactpage.enterTelephoneNum(telephoneNumber);
		contactpage.enterMessage(message);
		contactpage.clickSubmitButton();
	}

	@DataProvider(name = "contactDetails")
	public Object[][] enteringContactDetails() {
		Object[][] data=null;
		try {
			 data=DataProviderforcontact.getTest("./src/main/resources/ContactDetails.csv");
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return data;
		

	}

}
