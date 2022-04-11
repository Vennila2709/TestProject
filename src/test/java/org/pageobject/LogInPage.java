package org.pageobject;

import org.baseClass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends BaseClass{
	
	public LogInPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="username")	private WebElement userName;
	@FindBy(id="password")	private WebElement passWord;
	@FindBy(xpath="//input[@id='login']")	private WebElement logInButton;
	
	public WebElement getUserName() {
		return userName;
	}

	public void setUserName(WebElement userName) {
		this.userName = userName;
	}

	public WebElement getPassWord() {
		return passWord;
	}

	public void setPassWord(WebElement passWord) {
		this.passWord = passWord;
	}

	public WebElement getLogInButton() {
		return logInButton;
	}

	public void setLogInButton(WebElement logInButton) {
		this.logInButton = logInButton;
	}
	
	
	
}
