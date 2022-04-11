package org.test;

import java.util.Date;

import org.baseClass.BaseClass;
import org.pageobject.LogInPage;
import org.pageobject.SearchHotelPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifySearchHotelResetButton extends BaseClass{
	public static LogInPage login;
	public static SearchHotelPage search; 
	
	@BeforeClass
	public void browserStarts() {
		//browserLaunch();
		//getUrl("http://adactinhotelapp.com/HotelAppBuild2/");
	}
	
	@BeforeMethod
	public void startTime() {
		Date d=new Date();
		System.out.println(d);
	}

	@Test(priority=-1,dataProvider="input")
	public void enterCredentials(String name, String pass) {
		browserLaunch();
		getUrl("http://adactinhotelapp.com/HotelAppBuild2/");
		login=new LogInPage();
		enterText(login.getUserName(),name);
		enterText(login.getPassWord(),pass);
		click(login.getLogInButton());
	}
	
	@DataProvider(name="input")
	public Object[][] data() {
		return new Object[][] {{"Nave2709","Nave2792"},{"Nave2708","Nave279@"},{"Nave270","Nave279"},{"Nila2709","Nila279@"}};
	}
	
	@Test(priority=0,enabled=false)
	public void verifySearchHotelTitle() {
		search=new SearchHotelPage();
		SoftAssert s=new SoftAssert();
		s.assertTrue(search.getSearchTitle().isDisplayed(),"Search title is displayed");
	}
	
	
	@Test(priority=1,invocationCount=3,enabled=false)
	public void selectMandatoryFieldInSearchHotelPage() {
		SBV(search.getLocationDropDown(),"Sydney");
		SBV(search.getHotelsDropDown(),"Hotel Creek");
		SBV(search.getRoomTypeDropDown(),"Standard");
		SBV(search.getRoomnosDropDown(),"3");
		SBV(search.getChildRoomDropDown(),"2");
	}
	
	@Test(priority=2,enabled=false)
	public void clickResetButton() {
		click(search.getResetButton());
		SoftAssert s=new SoftAssert();
		s.assertTrue(!search.getSearchTitle().isDisplayed(),"Reset button working properly");
		s.assertTrue(search.getSearchTitle().isDisplayed(),"Reset button working properly");
		System.out.println("pass");
		s.assertAll();
	}
	
	@AfterMethod
	public void endTime(){
		Date d=new Date();
		System.out.println(d);
	}
	
	@AfterClass
	public void tearDown() {
		quitDriver();
	}

}
