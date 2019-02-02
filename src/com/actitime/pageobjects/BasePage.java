package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.utilities.SeleniumLib;

public abstract class BasePage 
{
	SeleniumLib slib;
	@FindBy(xpath="//div[text()='Tasks']")
	private WebElement tasks;
	@FindBy(id="logoutLink")
	private WebElement logout;
	
	@FindBy(xpath="//div[text()='Users']")
	private WebElement users;
	
	public BasePage(WebDriver driver)
	{
		slib=new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	//Steps
	public void clickOnTasks()
	{
		tasks.click();
	}
	public void clickOnLogout()
	{
		logout.click();
	}
	public void clickOnUsers()
	{
		users.click();
	}

}
