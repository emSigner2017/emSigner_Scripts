package PageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class pf_login_dashboardpage extends pf_genericmethods {

	@FindBy(how = How.CLASS_NAME, using = "btn-login") WebElement loginbutton;
	@FindBy(how = How.ID, using = "UserName") WebElement Usernamebox;
	@FindBy(how = How.ID, using = "Password") WebElement Passwordbox;
	@FindBy(how = How.ID, using = "btnLogin") WebElement Loginsubmit;
	@FindAll({@FindBy(how = How.CLASS_NAME, using = "alertNote")}) public List<WebElement> Subscriptionalert;
	@FindBy(how = How.CLASS_NAME, using = "fa fa-user icon-xs icon-rounded") WebElement Logouticon;
	@FindBy(how = How.CLASS_NAME, using = "dropdown-menu dropdown-menu-right profile animated fadeIn") WebElement logout;
	@FindBy(how = How.CLASS_NAME, using = "validation-summary-errors") public WebElement msgerror; 
	@FindBy(how = How.ID, using = "adminMenu4") WebElement manageworkflows;
	@FindAll({@FindBy(how = How.XPATH, using = "//div[@class='validation-summary-errors']/ul/li")}) public List<WebElement> loginerror;
	
	
public pf_login_dashboardpage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
	}

public void login_credentials(String uname,String pass) throws Exception{
	
	cl_click(loginbutton);
	cl_entertext(Usernamebox, uname);
	cl_entertext(Passwordbox, pass);
	cl_click(Loginsubmit);
	
	if(loginerror.size()>0){
		System.out.println("Login Failed. Please check the credentials");
	}else{
	System.out.println("Logged in successfully");
	if(Subscriptionalert.size()>0){
		System.out.println("Subscription expired. Please renew the account");
	}else{
		System.out.println("Subscription Active");
		Thread.sleep(3000);
//		cl_click(manageworkflows);
	}
	}
/*	cl_click(Logouticon);
	Thread.sleep(3000);
	cl_click(logout);
*/}
}
