package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.utilities.SeleniumLib;

public class UserList extends BasePage {
	SeleniumLib slib;
	
	@FindBy(id="createNewUserButtonDiv")
	private WebElement createNewUserBtn;
	
	@FindBy(className="successmsg")
	private WebElement successmsg;
	
	@FindBy(xpath="//a[text()='Devgan, Ajay (Ajay_Dev)']")
	private WebElement userNameLink;
	
	public UserList(WebDriver driver)
	{
		super(driver);
		slib= new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnCreateNewUserBtn()
	{
		createNewUserBtn.click();
	}
	
	public void verifyCreateUser()
	{
		String expected="User account has been successfully created.";
		String actual=successmsg.getText();
		slib.validate(expected, actual, expected);
	}
	public void clickOnUserNameLink()
	{
		userNameLink.click();
	}
	public void verifyDeleteUser()
	{
		String expected="User account has been successfully deleted.";
		String actual=successmsg.getText();
		slib.validate(expected, actual, expected);
	}

}
