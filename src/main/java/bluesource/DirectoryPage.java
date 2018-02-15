package bluesource;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import com.orasi.DriverManager;
import com.orasi.web.OrasiDriver;
import com.orasi.web.webelements.Textbox;
import com.orasi.web.webelements.impl.internal.ElementFactory;

public class DirectoryPage {
	private OrasiDriver driver = null;
	
	@FindBy(tagName="input") private Textbox txtSearchBar;
	
	public DirectoryPage() {
		this.driver = DriverManager.getDriver();
		ElementFactory.initElements(driver, this);
		
	}
	
	public void search() {
		txtSearchBar.set("Jimmy Johns");
	}
	
	public boolean assertSearch() {
		if(driver.findLink(By.partialLinkText("Jimmy")).isDisplayed())
			return true;
		else return false;
	}
	

}
