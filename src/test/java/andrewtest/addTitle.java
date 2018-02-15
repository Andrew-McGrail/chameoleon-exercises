package andrewtest;

import org.testng.annotations.Test;

import com.orasi.utils.TestReporter;
import com.orasi.web.WebBaseTest;

import bluesource.LoginPage;
import bluesource.NewTitlePage;
import bluesource.TitlesPage;
import bluesource.TopNavigationBarPage;

public class addTitle extends WebBaseTest{
	
	@Test
	public void testAddTitle() {
		TestReporter.setDebugLevel(2);
		
		TestReporter.logScenario("Verify a Title was successfully added.");
		setPageURL("https://bluesourcestaging.herokuapp.com/admin/titles");
		testStart("Adding a Title.");
		
		LoginPage loginPage = new LoginPage();
		loginPage.login();
		
		TopNavigationBarPage topNavigationBarPage = new TopNavigationBarPage();
		topNavigationBarPage.clickTitle();
		
		TitlesPage titlesPage = new TitlesPage();
		TestReporter.logStep("Titles page was reached.");
		titlesPage.clickAdd();
		
		NewTitlePage newTitlePage = new NewTitlePage();
		TestReporter.logStep("New Titles page was reached.");
		newTitlePage.createTitle();
		TestReporter.assertTrue(newTitlePage.assertTitleCreation(), "Assert the new title was created and added to the list.");
		
		
	}
}
