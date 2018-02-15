package bluesource;

import org.openqa.selenium.support.FindBy;

import com.orasi.DriverManager;
import com.orasi.web.OrasiDriver;
import com.orasi.web.webelements.Button;
import com.orasi.web.webelements.Label;
import com.orasi.web.webelements.Textbox;
import com.orasi.web.webelements.impl.internal.ElementFactory;

public class NewTitlePage {
	private OrasiDriver driver = null;
	
	@FindBy(id="title_name") private Textbox txtTitleName;
	@FindBy(xpath="//*[@id=\'new_title\']/div[3]/input") private Button btnCreateTitle;
	@FindBy(xpath="//*[@id=\'content\']/div") private Label lSuccessMessage;
	
	
	public void NewTitlesPage() {
		this.driver = DriverManager.getDriver();
		ElementFactory.initElements(driver, this);
	}
	
	public void createTitle() {
		txtTitleName.set("This is a title");			// <-- NullPointerException, can't find the textbox.
		btnCreateTitle.click();
	}
	
	public boolean assertTitleCreation() {
		if(lSuccessMessage.getText().equals("Title successfully created."))
			return true;
		else
			return false;
	}

}
