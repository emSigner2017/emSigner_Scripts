package Page_Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class pf_loginpage extends pf_genericmethods {
	
	
	@FindBy(how = How.CLASS_NAME, using = "btn-login") WebElement loginbutton;
	@FindBy(how = How.ID, using = "UserName") WebElement Usernamebox;
	@FindBy(how = How.ID, using = "Password") WebElement Passwordbox;
	@FindBy(how = How.ID, using = "btnLogin") WebElement Loginsubmit;
	@FindBy(how = How.XPATH, using = "//div[@class='validation-summary-errors']/ul/li") public WebElement msgerror; 
	
	public pf_loginpage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
	}


	
	public void logincredentials(String uname,String pass){
		
		cl_click(loginbutton);
		cl_entertext(Usernamebox, uname);
		cl_entertext(Passwordbox, pass);
		cl_click(Loginsubmit);
	}

}
