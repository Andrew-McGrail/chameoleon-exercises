package bluesource;

import org.openqa.selenium.support.FindBy;

import com.orasi.DriverManager;
import com.orasi.web.OrasiDriver;
import com.orasi.web.webelements.Button;
import com.orasi.web.webelements.impl.internal.ElementFactory;

public class TitlesPage {
	private OrasiDriver driver = null;
		
		@FindBy(xpath = "//*[@id=\"content\"]/a") private Button btnAddTitle;
		
		
		public TitlesPage() {
			this.driver = DriverManager.getDriver();
			ElementFactory.initElements(driver, this);
		}
		
		public void clickAdd() {
			btnAddTitle.click();
		}
	}
