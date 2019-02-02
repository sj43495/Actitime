package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.utilities.SeleniumLib;

public class CreateNewUserPage {
	SeleniumLib slib;
	
	@FindBy(name="username")
	private WebElement userNameTxtBx;
	@FindBy(name="passwordText")
	private WebElement passwordTxtBx;
	@FindBy(name="passwordTextRetype")
	private WebElement retypePwdTxtBx;
	@FindBy(name="firstName")
	private WebElement firstNamaeTxtBx;
	@FindBy(name="lastName")
	private WebElement lastNameTxtBx;
	@FindBy(name="email")
	private WebElement emailAddTxtBx;
	@FindBy(css="input[value*='Create User']")
	private WebElement createUserBtn;
	
	public CreateNewUserPage(WebDriver driver)
	{
		slib=new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void createUser(String userName,String pwd,String retypePwd,String firstName,String lastName,String email)
	{
		slib.enterData(userNameTxtBx, userName);
		slib.enterData(passwordTxtBx, pwd);
		slib.enterData(retypePwdTxtBx, retypePwd);
		slib.enterData(firstNamaeTxtBx, firstName);
		slib.enterData(lastNameTxtBx, lastName);
		slib.enterData(emailAddTxtBx, email);
		slib.clickButton(createUserBtn);
	}
}
