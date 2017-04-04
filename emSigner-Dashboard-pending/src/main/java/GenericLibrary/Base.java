package GenericLibrary;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


import com.beust.jcommander.Parameter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Base {

	public WebDriver fd;
	public static ExtentReports etr;
	public static ExtentTest ett;
	public String tcid;
	public String order;
	public String browser_type;
	
	
	@BeforeSuite(groups = {"Smk","Uat","Reg"})
	public void createreport(){
//		System.out.println("Before suite");
		
		etr = new ExtentReports("D:\\mayil\\HPEdrive\\Selenium Scripts\\emSigner scripts\\Report\\emsigner_"+get_datetimestamp()+".html",false);
		
	}

	@Parameters({"browser"})
	@BeforeMethod(groups={"Smk", "Uat", "Reg"})
	public void launchapp(String btype) throws Exception{
		
//		System.out.println("Before method");
		browser_type = btype;
		if(btype.equalsIgnoreCase("ff")){
//			System.out.println("Firefox Browser");
			fd = new FirefoxDriver();
		}else if (btype.equalsIgnoreCase("ch")){
			System.setProperty("webdriver.chrome.driver","D:\\mayil\\Downloads Lenovo\\chromedriver_win32\\chromedriver.exe");
			fd = new ChromeDriver();
		}else if(btype.equalsIgnoreCase("ie")){
			
			System.setProperty("webdriver.ie.driver","D:\\mayil\\Downloads Lenovo\\IEDriverServer_x64_2.53.1\\IEDriverServer.exe");
			fd = new InternetExplorerDriver();
		}
//		System.out.println("env value is "+Utility.propertyvalue("env"));
		fd.get(Utility.propertyvalue(Utility.propertyvalue("env")));
		fd.manage().window().maximize();
		fd.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	@AfterMethod(groups={"Smk","Uat","Reg"})
	public void closeapp(){
		
		fd.close();
		etr.endTest(ett);
		etr.flush();
	}
	
	public String get_datetimestamp(){
		Date date = new Date();
//		format date
		 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy hh-mm-ss");
//		
		 String format = dateFormat.format(date);
		 return format;
		
	}
	
//	capture snapshot
	public String getScreenshot() throws Exception{
		
		TakesScreenshot sc=(TakesScreenshot)fd;
		File screenshotAs = sc.getScreenshotAs(OutputType.FILE);
		
		String fpath = Utility.propertyvalue("Screenshotpath") + tcid + "_" + order + "_" + get_datetimestamp() +".png";
		FileUtils.copyFile(screenshotAs, new File(fpath));
		return fpath;
				
	}
//	Common Validation
//	equals
	public void cv_equals(String actual,String expected,String stepname) throws Exception{
		
		if(actual.equals(expected)){
			ett.log(LogStatus.PASS, stepname , "Passed as the Step "  + stepname + " ." + ett.addScreenCapture(getScreenshot()));
			
		}else{
			
			ett.log(LogStatus.FAIL, stepname , "Failed the Step " +stepname+ " as the actual value is " + actual + " and the expected is " + expected  + ett.addScreenCapture(getScreenshot()));
		}
		
				
	}
	
	
//	contains
public void cv_contains(String actual,String expected,String stepname) throws Exception{
		
		if(actual.contains(expected)){
			ett.log(LogStatus.PASS, stepname , "Passed as the Step "  + stepname + " ." + ett.addScreenCapture(getScreenshot()));
			
		}else{
			
			ett.log(LogStatus.FAIL, stepname , "Failed the Step " +stepname+ " as the actual value is " + actual + " and the expected is " + expected  + ett.addScreenCapture(getScreenshot()));
		}
		
				
	}
}
