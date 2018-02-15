package andrewtest;

import org.testng.annotations.Test;

import com.orasi.utils.TestReporter;
import com.orasi.web.WebBaseTest;

import bluesource.LoginPage;
import bluesource.ProjectsPage;
import bluesource.TopNavigationBarPage;

public class inactiveProjects extends WebBaseTest{

	@Test
	public void testAddProject() {
		TestReporter.setDebugLevel(2);
		
		TestReporter.logScenario("Verify the projects list doesn't display inactive projects.");
		setPageURL("https://bluesourcestaging.herokuapp.com/projects");
		testStart("Inactive Projects");
		
		LoginPage loginPage = new LoginPage();
		loginPage.login();
		
		TopNavigationBarPage topNavigationBarPage = new TopNavigationBarPage();
		topNavigationBarPage.clickProjects();
		
		ProjectsPage projectsPage = new ProjectsPage();
		TestReporter.logStep("Projects page successfully Reached.");
		TestReporter.assertTrue(projectsPage.assertNoInactivesDisplayed(), "Assert there are no inactive projects initially displayed");
		projectsPage.toggleInactive();
		TestReporter.logStep("Toggle the display of inactive projects.");
		TestReporter.assertFalse(projectsPage.assertNoInactivesDisplayed(), "Assert that there are now inactive projects displayed.");
		
		
	}
	
}
