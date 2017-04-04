package Script_Pending;

import java.util.Map;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import GenericLibrary.Base;
import PageFactory.pf_pendingpage;
import PageFactory.pf_storage;

public class Storagemsgcheck extends Base{
	
	@Test(dataProvider="validLogin",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=2,groups={"Smk","Uat"})
	public void loginvalidcheck(Map hm) throws Exception{
		
		String uid = hm.get("Uname").toString();
		String pas = hm.get("Pwd").toString();
		String exp = hm.get("Expected_Result").toString();
		tcid = hm.get("TC_ID").toString();
		order=hm.get("Order").toString();
		
		ett =  etr.startTest(tcid+"_" + order + "_" + browser_type);
		pf_pendingpage ph = new pf_pendingpage(fd);
		pf_storage st = new pf_storage(fd);
//		ph.signinftn();
		ph.login_credentials(uid, pas);
		st.storagetest();
		
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
