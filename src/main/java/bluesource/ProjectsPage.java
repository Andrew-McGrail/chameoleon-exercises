package bluesource;

import org.openqa.selenium.support.FindBy;

import com.orasi.DriverManager;
import com.orasi.web.OrasiDriver;
import com.orasi.web.webelements.Button;
import com.orasi.web.webelements.Element;
import com.orasi.web.webelements.Label;
import com.orasi.web.webelements.Listbox;
import com.orasi.web.webelements.Textbox;
import com.orasi.web.webelements.Webtable;
import com.orasi.web.webelements.impl.internal.ElementFactory;

public class ProjectsPage {
	private OrasiDriver driver = null;

	@FindBy(id="search-bar") private Textbox txtSearchTerm;
	@FindBy(xpath="//*[@id=\'resource-content\']/div[1]/table/tbody/tr[2]/td[1]") private Element eCell;
	@FindBy(xpath="//*[@id=\'all-content\']/div[2]/div/div[2]/button") private Button btnAdd;
	@FindBy(id="project_name") private Textbox txtProjectName;
	@FindBy(id="project_client_partner_id") private Listbox lbClientPartner;
	@FindBy(id="add-team-lead") private Button btnAddTeamLead;
	@FindBy(id="project_leads") private Listbox lbProjectLeads;
	@FindBy(id="project_status") private Listbox lbProjectStatus;
	@FindBy(id="project_start_date") private Textbox txtStartDate;
	@FindBy(id="project_end_date") private Textbox txtEndDate;
	@FindBy(name="commit") private Button btnCreateProject;
	@FindBy(xpath="//*[@id=\'all-content\']/div[1]") private Label lSuccess;
	@FindBy(xpath="//*[@id=\'all-content\']/div[2]/div/div[1]/label") private Button btnShowInactives;
	@FindBy(xpath="//*[@id=\'resource-content\']/div[1]") private Webtable wtProjects;
	
	public ProjectsPage() {
		this.driver = DriverManager.getDriver();
		ElementFactory.initElements(driver, this);
	}
	
	public void addProject() {
		btnAdd.syncVisible();
		btnAdd.click();
	}
	
	public boolean assertAdd() {
		btnCreateProject.syncVisible(5);
		return btnCreateProject.isDisplayed();
	}
	
	public void addProjectInfo() {
		txtProjectName.set("This is a fun game.");
		lbClientPartner.sendKeys("abbrow");
		btnAddTeamLead.click();
		lbProjectLeads.sendKeys("12345 N");
		lbProjectStatus.sendKeys("Active");
		txtStartDate.sendKeys("04201969");
		txtEndDate.sendKeys("06092420");
		btnCreateProject.click();
	}
	
	public boolean assertProjectAdd() {
		return lSuccess.isDisplayed();
	}
	
	public void toggleInactive() {
		if(btnShowInactives.isDisplayed())
			btnShowInactives.click();
	}
	public boolean assertNoInactivesDisplayed() {
		//if(driver.findLabel(By.partialLinkText("Inactive")).isDisplayed())
		if(wtProjects.getRowWithCellText("Inactive")>0) {
			System.out.println("The row is: " + wtProjects.getRowWithCellText("Inactive"));
			System.out.println("The row is: " + wtProjects.getSize());
			return false;
		}
		else {
			System.out.println("The row is: " + wtProjects.getRowWithCellText("Inactive"));
			System.out.println("The row is: " + wtProjects.getSize());
			return true;
		}
	}

}
