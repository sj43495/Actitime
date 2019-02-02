package com.actitime.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.utilities.SeleniumLib;
import com.gargoylesoftware.htmlunit.javascript.host.event.PageTransitionEvent;

public class EnterTimeTrackPage extends BasePage
{
	SeleniumLib slib;
	
	@FindBy(xpath="//td[@class='pagetitle']")
	private List<WebElement> pageTitle;
	
	public EnterTimeTrackPage(WebDriver driver)
	{
		super(driver);
		slib=new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	//feature
	public void verifyHomePage()
	{
		String expected="Enter Time-Track";
		String actual=pageTitle.get(1).getText();
		slib.validate(expected, actual, "Home Page Text Verifed");
		
		/*String expectedTitle="actiTIME - Enter Time-Track";
		String actualTitle = slib.getPageTitle();
		slib.validate(expectedTitle, actualTitle, "Home Page Title Is Verified");*/
	}

}
