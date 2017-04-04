package Dataproviders;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

import GenericLibrary.Utility;

public class dp_login {
	@DataProvider(name="invalidLogin")
	public static Iterator<Object[]> dp_invalidLogin() throws Exception{
//		System.out.println("Invalid login DP");
		return Utility.dp_commonlogic("Credentials","InvalidLogin");
		
		
	}
	
//	DP for valid login
	
	@DataProvider(name="validLogin")
	public static Iterator<Object[]> dp_validLogin() throws Exception{
		
		return Utility.dp_commonlogic("Credentials", "ValidLogin");
		
		
	}

}
