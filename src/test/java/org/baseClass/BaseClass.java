package org.baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

//Base class/Utility class/helper class/Reusable Class
public class BaseClass {
	public static WebDriver driver;
	public static void browserLaunch() {
		String path=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public static void getUrl(String url) {
		try {
		driver.get(url);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
   public static String getTitle() {
	  String text= driver.getTitle();
	  return text;
   }
   
   public static void enterText(WebElement e, String value) {
	   e.sendKeys(value);
   }
   
   public static void click(WebElement e) {
	   e.click();
   }
   
   public static void SBI(WebElement e, int index) {
	   Select s=new Select(e);
	   s.selectByIndex(index);
   }
   
   public static void SBV(WebElement e, String value) {
	   Select s=new Select(e);
	   s.selectByValue(value);
	   System.out.println("Vennila");
	   System.out.println("Vennila");
   }
   
   public static void rightClick(WebElement e) {
	 Actions a=new Actions(driver);
	 a.contextClick(e).perform();
	 System.out.println("Vennila");
	 System.out.println("Vennila");
   }
   
   public static String getCellString(int rowNo, int cellNo, String excelName, String SheetName) throws IOException {
	   String value=null;
	   String path=System.getProperty("user.dir");
		File excelLoc=new File(path+"\\Resource\\"+excelName);
		FileInputStream stream=new FileInputStream(excelLoc);
		Workbook w=new XSSFWorkbook(stream);
		Sheet s=w.getSheet(SheetName);
		Row r=s.getRow(rowNo);
		Cell c=r.getCell(cellNo);
		CellType type=c.getCellType();
		String cellType=String.valueOf(type).trim();
		
	if(cellType.equalsIgnoreCase("STRING")){
		value=c.getStringCellValue();
	}
	else if(cellType.equalsIgnoreCase("NUMERIC")) {
		if(DateUtil.isCellDateFormatted(c)) {
			Date dateCellValue=c.getDateCellValue();
			SimpleDateFormat sim=new SimpleDateFormat("dd-MM-YY");
			String name=sim.format(dateCellValue);
			value=name;
		}
		else {
			double numericCellValue = c.getNumericCellValue();
			long l=(long)numericCellValue;
			String name=String.valueOf(l);
			value=name;
		}
		w.close();
	}
		return value;   
   }
   
   public static void waitFor(int time) throws InterruptedException {
	   Thread.sleep(time);
   }
   
   public static void quitDriver() {
	   driver.quit();
   }
   
   public static void closeDriver() {
	   driver.close();
   }
}
