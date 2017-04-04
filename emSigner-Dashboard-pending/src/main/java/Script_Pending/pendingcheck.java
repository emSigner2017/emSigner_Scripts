package Script_Pending;

import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import GenericLibrary.Base;
import PageFactory.pf_pendingpage;

public class pendingcheck extends Base{
	
	Logger lg = Logger.getLogger(pendingcheck.class);
	
	@Test(dataProvider="invalidLogin",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=1,groups={"Smk","Reg"})
	public void logincheck(Map hm) throws Exception{
		
//		System.out.println("invalid login test");
		String uid = hm.get("Uname").toString();
		System.out.println(uid);
		String pas = hm.get("Pwd").toString();
		String exp = hm.get("Expected_Result").toString();
		tcid = hm.get("TC_ID").toString();
		order=hm.get("Order").toString();
		System.out.println(uid + " "+ pas );
		
		ett =  etr.startTest(tcid+"_" + order + "_" + browser_type);
		pf_pendingpage ph = new pf_pendingpage(fd);
//		System.out.println("pf_homepage");
//		ph.signinftn();
		ph.login_credentials(uid, pas);
		
		String Actual = ph.msgerror.getText();
		if(Actual.equals(exp)){
			ett.log(LogStatus.PASS, "Validate Login msg","Passed");
			System.out.println(" Pass");
		}else{
			ett.log(LogStatus.FAIL, "Validate Login msg","Failed");
			System.out.println("Fail");
		}
	}
	
//	Valid scenario
	@Test(dataProvider="validLogin",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=2,groups={"Smk","Uat"})
	public void loginvalidcheck(Map hm) throws Exception{
		
		String uid = hm.get("Uname").toString();
		String pas = hm.get("Pwd").toString();
		String exp = hm.get("Expected_Result").toString();
		tcid = hm.get("TC_ID").toString();
		order=hm.get("Order").toString();
		
		ett =  etr.startTest(tcid+"_" + order + "_" + browser_type);
		pf_pendingpage ph = new pf_pendingpage(fd);
//		ph.signinftn();
		ph.login_credentials(uid, pas);
		
		
		String Actual = fd.getTitle();
		
		System.out.println("Actual title :" +Actual);
		if(Actual.equals(exp)){
			ett.log(LogStatus.PASS, "Logged in and the user is in Dashboard","Passed");
			System.out.println("Pass");
		}else{
			ett.log(LogStatus.FAIL, "Login failed or user redirected to other page","Failed");
			System.out.println("Fail");
		}
	}

}
