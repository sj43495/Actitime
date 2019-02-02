package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.utilities.SeleniumLib;

public class LoginPage 
{
	SeleniumLib slib;
	@FindBy(name="username")
	private WebElement unTxtBx;
	
	@FindBy(name="pwd")
	private WebElement pwdTxtBx;
	
	@FindBy(id="loginButton")
	private WebElement loginBtn;
	
	@FindBy(xpath="//div[@id='ServerSideErrorMessage']//span[@class='errormsg']")
	private WebElement invalidLoginMsg;
	
	public LoginPage(WebDriver driver)
	{
		slib=new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	public void login(String username,String password)
	{
		slib.enterData(unTxtBx, username);
		slib.enterData(pwdTxtBx, password);
		loginBtn.click();
	}
	public void verifyInvalidLoginMsg()
	{
		String expected="Username or Password is invalid. Please try again.";
		String actual=invalidLoginMsg.getText();
		slib.validate(expected, actual, "invalid Login message is verified");
	}
	

}
