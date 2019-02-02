package com.actitime.utilities;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class SeleniumLib {
	WebDriver driver;
/***************Constructor*****************/
	public SeleniumLib(WebDriver driver)
	{
		this.driver=driver;
	}
/*******************************************/
	public void enterData(WebElement textbox,String input)
	{
		if(textbox.getAttribute("value")!=null)
		{
			textbox.clear();
			textbox.sendKeys(input);
		}
		else
		{
			textbox.sendKeys(input);
		}
	}
/****************Click Button*********************/
	public void clickButton(WebElement button)
	{
		if(button.getAttribute("type").equalsIgnoreCase("button"))
		{
			button.click();
		}
		else if(button.getAttribute("type").equalsIgnoreCase("submit"))
		{
			button.submit();
		}
	}
/***************click CheckBox*******************/
	public void clickcheckbox(WebElement checkbox)
	{
		if(checkbox.isSelected()==false)
		{
			checkbox.click();
		}
	}
/*****************Mouse Over*********************/
	public void mouseOver(WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
/*****************Select Option By Text**********/
	public void selectOptionByText(WebElement dropDown,String text)
	{
		Select sel=new Select(dropDown);
		sel.selectByVisibleText(text);
	}
/**************hard code wait*************/
	public void iSleep(int seconds)
	{
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/*****************explicit Wait************/
	public void eWaitForVisible(int seconds,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
/*****************assert*********************/
	public void validate(String expected,String actual,String msg)
	{
		Assert.assertEquals(actual, expected);
		Reporter.log(msg,true);
	}
	
/***************get Title********************/
	public String getPageTitle()
	{
		String title=driver.getTitle();
		return title;
	}
/***************assert displayed*************/
	public void validateElementDisplayed(WebElement element,String exptext, String msg)
	{
		Assert.assertTrue(element.isDisplayed());
		Assert.assertTrue(element.getText().contains(exptext));
		Reporter.log(msg,true);
	}
/****************Alert Handle****************/
	public void handleAlert(String expectedMsg)
	{
		Alert alt=driver.switchTo().alert();
		if(expectedMsg.equals(alt.getText()))
		{
			System.out.println("Alert Msg is Verified");
		}
		else
		{
			System.out.println("Alert Msg is not Verified");
		}
		alt.accept();
			
	}

}
