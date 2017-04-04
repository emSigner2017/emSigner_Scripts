package Scripts_Onlinesigning;

import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Generic_Library.Basefunctions;
import Page_Factory.pf_Onlinesigningpage;

import Page_Factory.pf_loginpage;



public class Online_signing extends Basefunctions {

		Logger lg = Logger.getLogger(Online_signing.class);
		
		@Test(dataProvider="valid_login",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=1,groups={"SMK","REG"})
		public void logincheck(Map hm) throws Exception{
			
			String uid = hm.get("Uname").toString();
			System.out.println("UID is " +uid);
			String pas = hm.get("Pwd").toString();
			String exp = hm.get("Expected_Result").toString();
			tcid = hm.get("TC_ID").toString();
			order=hm.get("Order").toString();
			
			
			et =  es.startTest(tcid+"_" + order + "_" + browser_type);
			pf_Onlinesigningpage po = new pf_Onlinesigningpage(w);
			pf_loginpage pl = new pf_loginpage(w);
			pl.logincredentials(uid, pas);
			po.onlinesigningsection();
		}
}
