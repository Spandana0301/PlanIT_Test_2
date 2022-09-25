package jupitortoystestcases;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import data.LogInDetails;
import pages.BasePage;
import pages.LogInPopUp;
import pages.LogOutPopUp;

public class HomeTest extends BaseTest {
	LogInDetails logInDetails=new LogInDetails("John@gmail.com", "letmei");
	
	//Exercise 17 login and logout from homepage
    @Test
	public void logInLogOut() throws Exception {
		BasePage basepage = new BasePage(driver);
		basepage.clickLoginButton();
		LogInPopUp loginpopup = new LogInPopUp(driver);
		loginpopup.enterUserName(logInDetails.getUserName());
		logInDetails.setPassword("letmein");
		loginpopup.enterPassword(logInDetails.getPassword());
		loginpopup.clickLogInButton();
		basepage.clickLogoutButton();
		LogOutPopUp logoutpopup = new LogOutPopUp(driver);
		logoutpopup.clickLogOutButtonOnPopUp();
	}


	//Exercise 16 Failed login by giving incorrect Password
	@Test
	public void failedLogIn(){
		BasePage basepage = new BasePage(driver);
		basepage.clickLoginButton();
		LogInPopUp loginpopup = new LogInPopUp(driver);
		loginpopup.enterUserName(logInDetails.getUserName());
		loginpopup.enterPassword(logInDetails.getPassword());
		loginpopup.clickLogInButton();
		assertEquals(loginpopup.getLoginIncorrectErrorMessage(), "Your login details are incorrect");
		
	}

}
