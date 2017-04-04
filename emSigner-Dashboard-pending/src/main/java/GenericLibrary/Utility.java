package GenericLibrary;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Utility {
	
	public static Iterator<Object[]> dp_commonlogic(String sheetname, String scriptname) throws Exception{
		
		
		ExcelRW ex = new ExcelRW(System.getProperty("user.dir")+ "\\src\\main\\resources\\emsigner-credentials.xlsx");
		
//		getting the row and column count
		
		int rowcount = ex.getrowcount(sheetname);
		int columncount = ex.columncount(sheetname);
		
//		creating list
		
		List<Object[]> ls = new ArrayList<Object[]>();
		
		for(int i =1; i<=rowcount;i++){
			
			String flag = ex.readvalue(sheetname, i,1);
//			System.out.println("Flag is : " +flag);
			String script = ex.readvalue(sheetname, i,3);
//			System.out.println("Scriptname is : " +script);
//			System.out.println("Parameter scriptname : "+scriptname);
			if(flag.equals("Y") && script.equals(scriptname)){
				
				Map<String, String> hm = new HashMap<String, String>();
				Object[] ob = new Object[1];
				
				for(int j =0;j<columncount;j++){
					
					String key = ex.readvalue(sheetname, 0, j);
					String value = ex.readvalue(sheetname, i, j);
					hm.put(key, value);
//					System.out.println("Key is :"+key+ ","+ "Value is :"+value);
				}
				ob[0] =hm;
				ls.add(ob);
			}
		}
		return ls.iterator();
		
		
		}
		
//		Get the properties data
		
		public static String propertyvalue(String Key) throws Exception{
			
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\resources\\emSigner-Config.properties");
			Properties pr = new Properties();
			pr.load(fs);
			return pr.getProperty(Key);
		}

}
