package Generic_Library;

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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Generic_Library.Utility;

public class Basefunctions {

	public WebDriver w;
	public static ExtentReports es;
	public static ExtentTest et;
	public String browser_type;
	public String tcid;
	public String order;
	@BeforeSuite (groups = {"SMK","UAT","REG"})
	public void createreport(){
//		System.out.println("Before Suite");
		es = new ExtentReports("D:\\mayil\\HPEdrive\\Selenium Scripts\\emSigner scripts\\Report\\emSigner-DB_"+get_datetimestamp()+".html",false);
		
		}
	@Parameters({"browser"})
	@BeforeMethod(groups = {"SMK","UAT","REG"})
	public void launch(String btype) throws Exception{
		browser_type = btype;
//		System.out.println("Before Method");
		if(btype.equalsIgnoreCase("ff")){

			w = new FirefoxDriver();
		}else if (btype.equalsIgnoreCase("ch")){
			System.setProperty("webdriver.chrome.driver","D:\\mayil\\Downloads Lenovo\\chromedriver_win32\\chromedriver.exe");
			w = new ChromeDriver();
		}else if(btype.equalsIgnoreCase("ie")){
			
			System.setProperty("webdriver.ie.driver","D:\\mayil\\Downloads Lenovo\\IEDriverServer_x64_2.53.1\\IEDriverServer.exe");
			w = new InternetExplorerDriver();
		}

		w.get(Utility.getpropertydetails((Utility.getpropertydetails(("env")))));
		w.manage().window().maximize();
		w.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	@AfterMethod(groups={"SMK","UAT","REG"})
	public void closeapp(){
		
		w.close();
		es.endTest(et);
		es.flush();
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
		
		TakesScreenshot sc=(TakesScreenshot)w;
		File screenshotAs = sc.getScreenshotAs(OutputType.FILE);
		
		String fpath = Utility.getpropertydetails("Screenshotpath") + tcid + "_" + order + "_" + get_datetimestamp() +".png";
		FileUtils.copyFile(screenshotAs, new File(fpath));
		return fpath;
				
	}
//	Common Validation
//	equals
	public void cv_equals(String actual,String expected,String stepname) throws Exception{
		
		if(actual.equals(expected)){
			et.log(LogStatus.PASS, stepname , "Passed as the Step "  + stepname + " ." + et.addScreenCapture(getScreenshot()));
			
		}else{
			
			et.log(LogStatus.FAIL, stepname , "Failed the Step " +stepname+ " as the actual value is " + actual + " and the expected is " + expected  + et.addScreenCapture(getScreenshot()));
		}
		
				
	}
	
	
//	contains
public void cv_contains(String actual,String expected,String stepname) throws Exception{
		
		if(actual.contains(expected)){
			et.log(LogStatus.PASS, stepname , "Passed as the Step "  + stepname + " ." + et.addScreenCapture(getScreenshot()));
			
		}else{
			
			et.log(LogStatus.FAIL, stepname , "Failed the Step " +stepname+ " as the actual value is " + actual + " and the expected is " + expected  + et.addScreenCapture(getScreenshot()));
		}
		
				
	}
	}

