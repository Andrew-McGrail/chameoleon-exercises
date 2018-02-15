package bluesource;

import org.openqa.selenium.support.FindBy;

import com.orasi.DriverManager;
import com.orasi.web.OrasiDriver;
import com.orasi.web.webelements.Button;
import com.orasi.web.webelements.Listbox;
import com.orasi.web.webelements.impl.internal.ElementFactory;

public class TopNavigationBarPage {
	private OrasiDriver driver = null;
	
	@FindBy(xpath = "/html/body/header/div/nav/ul/li[1]/a") private Button lbAdmin;
	@FindBy(xpath = "/html/body/header/div/nav/ul/li[2]/a") private Button btnMessageCenter;
	@FindBy(xpath = "/html/body/header/div/nav/ul/li[3]/a") private Button btnCalendar;
	@FindBy(xpath = "/html/body/header/div/nav/ul/li[4]/a") private Listbox lbArrow;
	@FindBy(xpath = "/html/body/header/div/nav/ul/li[5]/a") private Button btnDirectory;
	@FindBy(xpath = "/html/body/header/div/nav/ul/li[6]/a") private Button btnProjects;
	@FindBy(xpath = "/html/body/header/div/nav/ul/li[7]/a") private Button btnEmployees;
	@FindBy(xpath = "/html/body/header/div/nav/ul/li[8]/a") private Button btnLogout;
	@FindBy(xpath = "//*[@id=\'help-btn\']") private Button btnHelp;
	@FindBy(xpath = "/html/body/header/div/nav/ul/li[1]/ul/li/a[2]") private Button btnTitles;
	
	
	public TopNavigationBarPage() {
		this.driver = DriverManager.getDriver();
		ElementFactory.initElements(driver, this);
	}
	
	public void clickDirectory() {
		btnDirectory.click();
	}
	
	public void clickProjects() {
		btnProjects.click();
	}
	
	public void clickTitle() {
		lbAdmin.click();
		btnTitles.syncVisible();
		btnTitles.click();
	}
	
	
}
