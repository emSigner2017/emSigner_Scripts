package PageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class pf_pendingpage extends pf_genericmethods {

	@FindBy(how = How.CLASS_NAME, using = "btn-login") WebElement loginbutton;
	@FindBy(how = How.ID, using = "UserName") WebElement Usernamebox;
	@FindBy(how = How.ID, using = "Password") WebElement Passwordbox;
	@FindBy(how = How.ID, using = "btnLogin") WebElement Loginsubmit;
	@FindAll({@FindBy(how = How.CLASS_NAME, using = "alertNote")}) public List<WebElement> Subscriptionalert;
	@FindBy(how = How.XPATH, using = "//div[@class ='quick-area']/div[1]/ul/li[1]/a/span") WebElement dashboardlink;
	@FindBy(how = How.ID, using = "Pendingcount") WebElement pending;
	@FindBy(how = How.ID, using = "status-pending-link") WebElement mysignatures;
	@FindBy(how = How.ID, using = "status-cosignpending-link") WebElement waitingforothers;
	@FindBy(how = How.XPATH, using = "//td[@id='pager_left']/table/tbody/tr/td[2]/div") WebElement togglesearch;
	@FindBy(how = How.XPATH, using = "//div[@class ='quick-area']/div[2]/ul/li/a/span") WebElement Logouticon;
	@FindBy(how = How.XPATH, using = "//div[@class ='quick-area']/div[2]/ul/li/ul/li[4]/a") WebElement logout;
	@FindBy(how = How.CLASS_NAME, using = "validation-summary-errors") public WebElement msgerror; 
	@FindBy(how = How.ID, using = "adminMenu4") WebElement manageworkflows;
	@FindAll({@FindBy(how = How.XPATH, using = "//div[@class='validation-summary-errors']/ul/li")}) public List<WebElement> loginerror;
	@FindBy(how = How.ID, using = "gs_CategoryName") WebElement categorysearch;
	
	
public pf_pendingpage(WebDriver driver){
		
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
		cl_click(dashboardlink);
		String pendingcount = pending.getText();
		System.out.println("Pending numbers :"+pendingcount);
		cl_click(waitingforothers);
		Thread.sleep(2000);
		cl_click(togglesearch);
		cl_entertext(categorysearch, "Department");
	}
	}
	/*cl_click(Logouticon);
	Thread.sleep(3000);
	cl_click(logout);
*/}
}
