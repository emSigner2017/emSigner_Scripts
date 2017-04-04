package Generic_Library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Properties;

public class Utility {
	
	public static ListIterator<Object[]> dp_commonlogic(String sheetname, String scriptname) throws Exception{
		
		ExcelRw er = new ExcelRw(System.getProperty("user.dir")+"\\src\\main\\resources\\emsigner-credentials.xlsx");
		
//		Get the Row count and column count
		
		int rc = er.getrowcount(sheetname);
		int cc = er.getcolumncount(sheetname);		
		
//		Creation of list object array
		
		List<Object[]> al = new ArrayList<Object[]>();
		
		for(int i=1;i<=rc;i++){
			
//			Getting the Flag & Scriptname
			
			String flag = er.readvalue(i,1, sheetname);
//				System.out.println("Flag is : "+flag );
			String script = er.readvalue(i, 3, sheetname);
			
			if(flag.equals("Y") && script.equalsIgnoreCase(scriptname)){
				
			Map<String, String> hp = new HashMap<String, String>();
			Object[] o = new Object[1];
			
			for(int j=0;j<cc;j++){
				
				String Key = er.readvalue(0, j,sheetname);
				String Value = er.readvalue(i,j, sheetname);
				hp.put(Key, Value);
			}
			o[0]=hp;
			al.add(o);
		}
		}
		return al.listIterator();
	}

	
//	Getting Property data
	
	public static String getpropertydetails(String Key) throws Exception{
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\emSigner-Config.properties");
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(Key);
	}
}

