package Dataproviders;

import java.util.ListIterator;

import org.testng.annotations.DataProvider;

import Generic_Library.Utility;

public class dp_login {

	@DataProvider(name = "invalid_login")
	public static ListIterator<Object[]> dp_invalid() throws Exception
	{
		return Utility.dp_commonlogic("Credentials","invalidlogin");
	}
	
	@DataProvider(name = "valid_login")
	public static ListIterator<Object[]> dp_valid() throws Exception
	{
		return Utility.dp_commonlogic("Credentials", "validlogin");
	}
}
