package andrewtest;

import org.testng.annotations.Test;

import com.orasi.utils.TestReporter;
import com.orasi.web.WebBaseTest;

import bluesource.LoginPage;

public class successfulLogin extends WebBaseTest {
	
	@Test
	public void testSuccessfulLogin() {
		TestReporter.setDebugLevel(2);
		
		TestReporter.logScenario("Verify a successful login to BlueSource");
		setPageURL("https://bluesourcestaging.herokuapp.com");
		testStart("Successful Login");
		
		LoginPage loginPage = new LoginPage();
		TestReporter.logStep("Login Page successfully reached");
		loginPage.login();
		TestReporter.assertTrue(loginPage.assertLogin(), "Assert the sumbit button has been pushed.");
	}
}
