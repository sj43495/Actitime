package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.utilities.BaseLib;
import com.actitime.utilities.SeleniumLib;

public class OpenTasksPage extends BasePage
{
	SeleniumLib slib;
	@FindBy(linkText="Projects & Customers")
	private WebElement projAndCustLink;
	
	@FindBy(css="input[value='Create New Tasks']")
	private WebElement createNewTaskBtn;
	
	@FindBy(className="successmsg")
	private WebElement successmsg;
	
	@FindBy(xpath="//td[starts-with(@id,'taskNameCell')]//a[contains(@href,'taskId')]")
	private WebElement taskNameLink;
	
	public OpenTasksPage(WebDriver driver)
	{
		super(driver);
		slib=new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	//step
	public void clickOnProjAndCustLink()
	{
		projAndCustLink.click();
	}
	
	public void clickOnCreateNewTaskBtn()
	{
		slib.clickButton(createNewTaskBtn);
	}
	public void verifyCreateTaskMsg(String customerName, String projectName)
	{
		slib.validateElementDisplayed(successmsg, customerName, successmsg.getText());
		slib.validateElementDisplayed(successmsg, projectName, successmsg.getText());	
	}
	public void clickOnTaskNameLink(String taskName)
	{
		if(taskNameLink.getText().equalsIgnoreCase(taskName))
		{
			taskNameLink.click();
		}
		else
		{
			System.out.println("Task Not Matching");
		}
	}
	public void verifyDeleteTask()
	{
		String expected="Task has been successfully deleted.";
		String actual=successmsg.getText();
		slib.validate(expected, actual, expected);
	}

}
