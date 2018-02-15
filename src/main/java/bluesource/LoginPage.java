package bluesource;

import org.openqa.selenium.support.FindBy;

import com.orasi.DriverManager;
import com.orasi.web.OrasiDriver;
import com.orasi.web.webelements.Button;
import com.orasi.web.webelements.Textbox;
import com.orasi.web.webelements.impl.internal.ElementFactory;

public class LoginPage {
	private OrasiDriver driver = null;
	
	@FindBy(id = "employee_username") private Textbox txtUsername;
	@FindBy(id = "employee_password") private Textbox txtPassword;
	@FindBy(name = "commit") private Button btnLogin;
	
	
	
	public LoginPage() {
		this.driver = DriverManager.getDriver();
		ElementFactory.initElements(driver, this);
		
	}
	
	public void login(){
		txtUsername.set("company.admin");
		txtPassword.set("LOL");
		btnLogin.click();
	}
	
	public boolean assertLogin() {
		if(btnLogin.isDisplayed())
			return false;
		else
			return true;
	}
	
}
