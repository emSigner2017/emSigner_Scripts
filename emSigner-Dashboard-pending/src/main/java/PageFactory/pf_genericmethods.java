package PageFactory;

import org.openqa.selenium.WebElement;

public class pf_genericmethods {
	
	// to enter text in text box
	
	public void cl_entertext(WebElement ele, String input){
		
		ele.sendKeys(input);
	}
	
	// to click any element
	
	public void cl_click(WebElement ele){
		
		ele.click();
	}

}
