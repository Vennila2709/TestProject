package org.test;

import org.baseClass.BaseClass;
import org.pageobject.LogInPage;
import org.pageobject.SearchHotelPage;

public class HotelBooking extends BaseClass{
	public static void main(String[] args) throws InterruptedException {
		browserLaunch();
		getUrl("http://adactinhotelapp.com/HotelAppBuild2/");
		LogInPage login=new LogInPage();
		enterText(login.getUserName(),"Nila2709");
		enterText(login.getPassWord(),"Nila279@");
		click(login.getLogInButton());
		SearchHotelPage search=new SearchHotelPage();
		if(search.getSearchTitle().isDisplayed()) {
			System.out.println("Successfully login into application");
		}
		else {
			System.out.println("Successfully not login into application");
		}
		
		SBV(search.getLocationDropDown(),"Sydney");
		SBV(search.getHotelsDropDown(),"Hotel Creek");
		SBV(search.getRoomTypeDropDown(),"Standard");
		SBV(search.getRoomnosDropDown(),"3");
		SBV(search.getChildRoomDropDown(),"2");
		click(search.getSearchButton());
	}

}
