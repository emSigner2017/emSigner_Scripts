package Page_Factory;

import org.openqa.selenium.WebElement;

public class pf_genericmethods {
	
//	Entering text
	
	public void cl_entertext(WebElement el, String input){
		
		el.sendKeys(input);
	}
	
//	Click on element
	
	public void cl_click(WebElement el){
		
		el.click();
	}

}
