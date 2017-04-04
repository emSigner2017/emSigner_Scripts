package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_t {
	public static WebDriver d;
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","D:\\mayil\\Downloads Lenovo\\chromedriver_win32\\chromedriver.exe");
		d = new ChromeDriver();
		d.get("http://www.emsigner.com");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		d.findElement(By.className("btn-login")).click();
		d.findElement(By.id("UserName")).sendKeys("myananth@gmail.com");
		d.findElement(By.id("Password")).sendKeys("welcome");
		d.findElement(By.id("btnLogin")).click();
		d.findElement(By.xpath("//div[@class='page-topbar']/div[2]/div[2]/ul/li/a/span")).click();
		d.findElement(By.xpath("html/body/div[4]/div[2]/div[2]/ul/li/ul/li[3]/a")).click();
		d.findElement(By.xpath("//*[@id='adminMenu4']/a")).click();
		d.findElement(By.xpath("//*[@id='li_1486_anchor']")).click();
		d.findElement(By.xpath("//input[@id='btnStep1Continue']")).click();
		
	}

}
