package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.utilities.SeleniumLib;

public class EditProjInfoPage 
{
	SeleniumLib slib;
	
	@FindBy(css="input[value='Delete This Project']")
	private WebElement delThisProjBtn;
	
	@FindBy(css="input[value='Delete Project']")
	private WebElement delProjConfirmBtn;
	
	public EditProjInfoPage(WebDriver driver)
	{
		slib=new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	public void deleteProject()
	{
		slib.clickButton(delThisProjBtn);
		slib.clickButton(delProjConfirmBtn);
	}
	

}
