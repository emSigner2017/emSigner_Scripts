package Page_Factory;


import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Generic_Library.Basefunctions;

public class pf_Onlinesigningpage extends pf_genericmethods {

	Basefunctions bs = new Basefunctions();
//	Dashboard elements
	
	@FindBy(how = How.ID, using ="Signonline") WebElement initiate_adhoc_signing;
	@FindBy(how = How.ID, using = "Signonlinelvl") WebElement Onlinesigning;
	
//	Online signing page Elements
	
	@FindBy(how = How.ID, using = "sample") WebElement uploaddocuments;
	@FindBy(how = How.ID, using = "textRefernceno") WebElement referencenumber_field;
	@FindBy(how = How.ID, using = "btnStep1Continue") WebElement continuebutton;
	
//	Signatory elements
	
	@FindBy(how = How.CLASS_NAME, using = "add-signatory") WebElement add_signatory;
	@FindBy(how = How.ID, using = "draggableDiv_1_1") WebElement signatory1;
	@FindBy(how = How.ID, using = "draggableDiv_2_1") WebElement signatory2;
	
//	Signatory assign elements
	
	@FindBy(how = How.XPATH, using = "//div[@id = 'signer-menu-wrapper']/ul/li/ul/li[2]/a") WebElement signatory1_assign;
	@FindBy(how = How.CLASS_NAME, using = "details") WebElement signatoryselection1;
	@FindBy(how = How.XPATH, using = "//div[@id = 'signer-menu-wrapper']/ul/li/ul/li[3]/a") WebElement signatory2_assign;
	@FindBy(how = How.ID, using = "ddlPageSelection") WebElement select_page_dropdown;
	@FindBy(how = How.ID, using = "btnSignatorySave") WebElement Applybutton;
	@FindAll({@FindBy(how = How.CLASS_NAME, using = "alertContent")}) public List<WebElement> alertmsg;
	@FindBy(how = How.ID, using = "btnmsgok") WebElement okbutton;
	@FindAll({@FindBy(how = How.CLASS_NAME, using = "details")}) public List<WebElement> signatorylist;
	@FindBy(how = How.ID, using = "addnewsigner") WebElement addsignatory;
	@FindBy(how = How.XPATH, using = "//div[@id = 'adhocDiv']/div[1]/input") WebElement namefield;
	@FindBy(how = How.XPATH, using = "//div[@id = 'adhocDiv']/div[2]/input") WebElement emailfield;
	@FindBy(how = How.ID, using = "btnRegister1") WebElement submitbutton;
	@FindBy(how = How.XPATH, using = "//ul[@id='profileListScroll']/li[2]/label/span[2]") WebElement signatoryselection2;
	@FindBy(how = How.ID, using = "btnstep1") WebElement save_continuebutton;
	@FindAll({@FindBy(how = How.XPATH, using = "//div[@class = 'alertContent']/div")}) public List<WebElement> templatealertmsg;
	@FindBy(how = How.XPATH, using = "//div[@class = 'alertContent']/div") WebElement templatemsg;
	@FindBy(how = How.XPATH, using = "//*[@class='temp-name']/input") WebElement templatename;
	@FindBy(how = How.ID, using = "txtPageNumber") WebElement pagenumberfield;
	@FindBy(how = How.ID, using = "btnApply") WebElement pageapplybutton;
	@FindBy(how = How.CLASS_NAME, using = "alertContent") WebElement msgofalert;
	
	
public pf_Onlinesigningpage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
	}

public void onlinesigningsection() throws Exception{
	
	cl_click(initiate_adhoc_signing);
	Thread.sleep(3000);
	cl_click(Onlinesigning);
	Thread.sleep(2000);
	cl_click(uploaddocuments);
	Thread.sleep(3000);
	Runtime.getRuntime().exec("D:\\mayil\\HPEdrive\\Selenium Scripts\\emSigner scripts\\autoit scripts\\uploadfiles.exe");
	cl_entertext(referencenumber_field, "20150322test");
	Thread.sleep(5000);
	cl_click(continuebutton);
	Thread.sleep(2000);
	cl_click(add_signatory);
	Thread.sleep(2000);
	cl_click(add_signatory);
	Thread.sleep(2000);
	WebElement dragelement = signatory1;
	WebElement dragelement1 = signatory2;
	Actions ac = new Actions(bs.w);
	ac.dragAndDropBy(dragelement,365,700).build().perform();
	Thread.sleep(2000);
	ac.dragAndDropBy(dragelement1,-20,750).build().perform();
	cl_click(signatory1_assign);
	Thread.sleep(2000);
	cl_click(signatoryselection1);
	Select se = new Select(select_page_dropdown);
	se.selectByIndex(new Random().nextInt(se.getOptions().size()));
	cl_click(Applybutton);
	Thread.sleep(2000);
	if(alertmsg.size()>0){
		if(msgofalert.getText().contentEquals("Please enter page numbers.")){
		cl_click(okbutton);
		Thread.sleep(2000);
		cl_entertext(pagenumberfield, "1");
		cl_click(pageapplybutton);
		Thread.sleep(2000);
		cl_click(Applybutton);
		}
		
		cl_click(okbutton);
	}
	cl_click(signatory2_assign);
	Thread.sleep(2000);
	if(signatorylist.size()<1){
		
		cl_click(addsignatory);
		Thread.sleep(2000);
		cl_entertext(namefield, "Tester1");
		cl_entertext(emailfield, "tendulkar@gmx.com");
		cl_click(submitbutton);
		if(alertmsg.size()>0){
			cl_click(okbutton);
		}
	}
	cl_click(signatoryselection2);
	Select se1 = new Select(select_page_dropdown);
	se1.selectByIndex(new Random().nextInt(se1.getOptions().size()));
	cl_click(Applybutton);
	Thread.sleep(2000);
	if(alertmsg.size()>0){
		if(msgofalert.getText().contentEquals("Please enter page numbers.")){
			cl_click(okbutton);
			cl_entertext(pagenumberfield, "1");
			cl_click(pageapplybutton);
			}

		
		cl_click(okbutton);
	}
	cl_click(save_continuebutton);
	Thread.sleep(2000);
	if(templatealertmsg.size()>0){
		String msgcontent = templatemsg.getText();
		cl_click(okbutton);
		Thread.sleep(3000);
		cl_entertext(templatename, "Testtemp");
		cl_click(save_continuebutton);
	}
	
}
}
