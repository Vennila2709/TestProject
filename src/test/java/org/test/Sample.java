package org.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sample {
	@Parameters({"browser"})
	@Test()
	public void test1(String name) {
		WebDriver driver=null;
		if(name.equals("chrome")) {
		String path=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		}
		else if(name.equals("ff")) {
			String path=System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", path+"\\drivers\\gecko.exe");
			driver=new FirefoxDriver();
		}
		else if(name.equals("ie")) {
			String path=System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", path+"\\drivers\\ie.exe");
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.get("http://adactinhotelapp.com/HotelAppBuild2/");
		System.out.println(Thread.currentThread().getId());
		driver.quit();
	}
	
	

}
