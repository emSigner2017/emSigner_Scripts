package Scripts;

import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Generic_Library.Basefunctions;
import Page_Factory.pf_dashboardpage;
import Page_Factory.pf_loginpage;



public class Dashboard_Script extends Basefunctions {

		Logger lg = Logger.getLogger(Dashboard_Script.class);
		
		@Test(dataProvider="valid_login",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=1,groups={"SMK","REG"})
		public void logincheck(Map hm) throws Exception{
			
			String uid = hm.get("Uname").toString();
			System.out.println("UID is " +uid);
			String pas = hm.get("Pwd").toString();
			String exp = hm.get("Expected_Result").toString();
			tcid = hm.get("TC_ID").toString();
			order=hm.get("Order").toString();
			
			
			et =  es.startTest(tcid+"_" + order + "_" + browser_type);
			pf_dashboardpage ph = new pf_dashboardpage(w);
			pf_loginpage pl = new pf_loginpage(w);
			pl.logincredentials(uid, pas);
			/*String Actual = pl.msgerror.getText();
			if(Actual.equals(exp)){
				et.log(LogStatus.PASS, "Validate Login msg","Passed");
				System.out.println(" Pass");
			}else{
				et.log(LogStatus.FAIL, "Validate Login msg","Failed");
				System.out.println("Fail");
			}*/
			ph.dashboardpageftn();
		}
}
