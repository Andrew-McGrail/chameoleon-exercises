package andrewtest;

import org.testng.annotations.Test;

import com.orasi.utils.TestReporter;
import com.orasi.web.WebBaseTest;

import bluesource.LoginPage;
import bluesource.ProjectsPage;
import bluesource.TopNavigationBarPage;

public class addProject extends WebBaseTest{
	@Test
	public void testAddProject() {
		TestReporter.setDebugLevel(2);
		
		TestReporter.logScenario("Verify a Project was successfully created.");
		setPageURL("https://bluesourcestaging.herokuapp.com/projects");
		testStart("Adding a Project");
		
		LoginPage loginPage = new LoginPage();
		loginPage.login();
		
		TopNavigationBarPage topNavigationBarPage = new TopNavigationBarPage();
		topNavigationBarPage.clickProjects();
		
		ProjectsPage projectsPage = new ProjectsPage();
		TestReporter.logStep("Projects page successfully Reached.");		
		projectsPage.addProject();
		TestReporter.assertTrue(projectsPage.assertAdd(), "Assert that the Add projects button was pushed.");
		projectsPage.addProjectInfo();
		TestReporter.logStep("Project information was successfully added to form.");
		TestReporter.assertTrue(projectsPage.assertProjectAdd(), "Assert that the project has been created.");
	}
}
