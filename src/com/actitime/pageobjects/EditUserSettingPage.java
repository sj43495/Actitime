package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.utilities.SeleniumLib;

public class EditUserSettingPage {
	SeleniumLib slib;
	
	
	@FindBy(css="input[value='Delete This User']")
	private WebElement delThisUserBtn;
	
	public EditUserSettingPage(WebDriver driver)
	{
		slib=new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	public void clickOnDelThisUser()
	{
		delThisUserBtn.click();
		String expectedMsg="Are you sure you want to delete this user account?";
		slib.handleAlert(expectedMsg);
	}

}
