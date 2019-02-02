package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.utilities.SeleniumLib;

public class ViewOpenTaskPage {
	
	SeleniumLib slib;
	
	@FindBy(css="input[value='Delete This Task']")
	private WebElement delThisTaskBtn;
	
	@FindBy(css="input[value='Delete Task']")
	private WebElement deleteTaskBtn;
	
	public ViewOpenTaskPage(WebDriver driver)
	{
		slib=new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	public void clickOnDelThisTaskBtn()
	{
		slib.clickButton(delThisTaskBtn);
	}
	public void deleteTask()
	{
		slib.clickButton(deleteTaskBtn);
	}

}
