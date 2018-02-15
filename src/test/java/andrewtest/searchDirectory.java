package andrewtest;

import org.testng.annotations.Test;

import com.orasi.utils.TestReporter;
import com.orasi.web.WebBaseTest;

import bluesource.DirectoryPage;
import bluesource.LoginPage;
import bluesource.TopNavigationBarPage;

public class searchDirectory extends WebBaseTest {

	@Test
	public void testSearchDirectory() {
		TestReporter.setDebugLevel(2);
		
		TestReporter.logScenario("Verify search results from the directories searchbar");
		setPageURL("https://bluesourcestaging.herokuapp.com/directory");
		testStart("Search Directory");
		
		LoginPage loginPage = new LoginPage();
		loginPage.login();
		TestReporter.logStep("Successfully logged into Blue Source.");
		
		TopNavigationBarPage topNavigationBarPage = new TopNavigationBarPage();
		topNavigationBarPage.clickDirectory();
		TestReporter.logStep("Successfully navigated to the Directory Page.");
		
		DirectoryPage directoryPage = new DirectoryPage();
		directoryPage.search();
		TestReporter.assertTrue(directoryPage.assertSearch(), "Assert if the person searched for is displayed.");
	}
}
