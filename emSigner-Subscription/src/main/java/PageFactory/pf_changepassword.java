package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class pf_changepassword extends pf_genericmethods{

	@FindBy(how = How.XPATH, using = "//div[@class='page-topbar']/div[2]/div[2]/ul/li/a/span") WebElement profileicon;
	@FindBy(how = How.XPATH, using = "//div[@class='page-topbar']/div[2]/div[2]/ul/li/ul/li[2]/a") WebElement changepasswordlink;
	@FindBy(how = How.ID, using = "OldPassword") WebElement currentpassword;
	@FindBy(how = How.ID, using = "NewPassword") WebElement newpassword;
	@FindBy(how = How.ID, using = "ConfirmPassword") WebElement confirmpassword;
	@FindBy(how = How.ID, using = "btnChangepwd") WebElement changepassbutton;
	@FindBy(how = How.ID, using = "btnClear") WebElement clearbutton;
	
public pf_changepassword(WebDriver driver){
		
		PageFactory.initElements(driver, this);
	}

public void changepass(String cp, String np, String cnp) throws Exception{
	
	cl_click(profileicon);
	Thread.sleep(2000);
	cl_click(changepasswordlink);
	Thread.sleep(2000);
	cl_entertext(currentpassword, cp);
	cl_entertext(newpassword, np);
	cl_entertext(confirmpassword, cnp);
	cl_click(changepassbutton);
	
}

}
