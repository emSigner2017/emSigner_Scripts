package PageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class pf_storage {
	
	@FindAll({@FindBy(how= How.XPATH, using = "//div[@id = 'main-menu-wrapper']/div[1]/div[3]/b")}) public List<WebElement> storagemsg;
	@FindBy(how= How.XPATH, using = "//div[@id = 'main-menu-wrapper']/div[1]/div[3]/b") WebElement storagemessage;
	
public pf_storage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
	}

public void storagetest(){
	
	if(storagemsg.size()>0){
		
		System.out.println("Storage Message displayed is :" +storagemessage.getText());
	}
}
}
