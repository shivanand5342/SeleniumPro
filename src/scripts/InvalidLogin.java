package scripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pom.LoginPage;

public class InvalidLogin extends BaseTest {
	@Test
	public void testInvalidLogin() {
		SoftAssert sa=new SoftAssert();
		//Enter Valid User name and Password
		LoginPage l=new LoginPage(driver);
		l.login("abc", "xyz");
		
		//Verify error message
		l.verifyErrorMessage(driver,sa);
		sa.assertAll();
	}

}
