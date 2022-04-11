package org.pageobject;

import org.baseClass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPage extends BaseClass {

	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//select[@id='location']")   private WebElement locationDropDown;
	@FindBy(xpath="//select[@id='hotels']")	    private WebElement hotelsDropDown;
	@FindBy(xpath="//select[@id='room_type']")  private WebElement roomTypeDropDown;
	@FindBy(xpath="//select[@id='room_nos']")	private WebElement roomnosDropDown;
	@FindBy(xpath="//select[@id='child_room']")	private WebElement childRoomDropDown;
	@FindBy(xpath="//input[@name='Submit']")	private WebElement searchButton;
	@FindBy(xpath="//input[@name='Reset']") 	private WebElement resetButton;
	@FindBy(xpath="//td[@class='login_title']") private WebElement searchTitle;
	
	public WebElement getLocationDropDown() {
		return locationDropDown;
	}
	public void setLocationDropDown(WebElement locationDropDown) {
		this.locationDropDown = locationDropDown;
	}
	public WebElement getSearchTitle() {
		return searchTitle;
	}
	public void setSearchTitle(WebElement searchTitle) {
		this.searchTitle = searchTitle;
	}
	
	public WebElement getHotelsDropDown() {
		return hotelsDropDown;
	}
	public void setHotelsDropDown(WebElement hotelsDropDown) {
		this.hotelsDropDown = hotelsDropDown;
	}
	public WebElement getRoomTypeDropDown() {
		return roomTypeDropDown;
	}
	public void setRoomTypeDropDown(WebElement roomTypeDropDown) {
		this.roomTypeDropDown = roomTypeDropDown;
	}
	public WebElement getRoomnosDropDown() {
		return roomnosDropDown;
	}
	public void setRoomnosDropDown(WebElement roomnosDropDown) {
		this.roomnosDropDown = roomnosDropDown;
	}
	public WebElement getChildRoomDropDown() {
		return childRoomDropDown;
	}
	public void setChildRoomDropDown(WebElement childRoomDropDown) {
		this.childRoomDropDown = childRoomDropDown;
	}
	public WebElement getSearchButton() {
		return searchButton;
	}
	public void setSearchButton(WebElement searchButton) {
		this.searchButton = searchButton;
	}
	public WebElement getResetButton() {
		return resetButton;
	}
	public void setResetButton(WebElement resetButton) {
		this.resetButton = resetButton;
	}
	
	
	
	
	
	
	
}
