package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.utilities.SeleniumLib;

public class ActiveProjAndCustPage extends BasePage
{
	SeleniumLib slib;
	@FindBy(xpath="//input[@value='Create New Customer']")
	private WebElement createNewCustBtn;
	
	@FindBy(className="successmsg")
	private WebElement successmsg;
	
	@FindBy(name="selectedCustomer")
	private WebElement customerDrpDwn;
	
	@FindBy(css="input[value*='Show']")
	private WebElement showBtn;
	
	@FindBy(xpath="//td[starts-with(@id,'customerNameCell')]//a[contains(@href,'customerId')]")
	private WebElement custNameLink;
	
	@FindBy(css="input[value='Create New Project']")
	private WebElement createNewProjBtn;
	
	@FindBy(xpath="//td[starts-with(@id,'projectNameCell')]//a[contains(@href,'projectId')]")
	private WebElement projNameLink;
	
	@FindBy(xpath="//a[text()='Open Tasks']")
	private WebElement openTaskBtn;
	
	
	public ActiveProjAndCustPage(WebDriver driver)
	{
		super(driver);
		slib=new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	//step
	public void clickOnCreateNewCustBtn()
	{
		slib.clickButton(createNewCustBtn);
	}
	public void verifyCreateCustMsg(String customerName)
	{
		slib.validateElementDisplayed(successmsg, customerName, successmsg.getText());
	}
	public void showCustomer(String customerName)
	{
		slib.selectOptionByText(customerDrpDwn, customerName);
		slib.clickButton(showBtn);
		if(custNameLink.getText().equalsIgnoreCase(customerName))
		{
		custNameLink.click();
		}
		else
		{
			System.out.println("Customer Not Matching");
		}
	}
	//feature
	public void verifyDeleteCustomer()
	{
		String expected="Customer has been successfully deleted.";
		String actual=successmsg.getText();
		slib.validate(expected, actual, expected);
	}
	public void clickOnCreateNewProjBtn()
	{
		slib.clickButton(createNewProjBtn);
	}
	//feature
	public void verifyCreateProject(String projectName)
	{
		slib.validateElementDisplayed(successmsg, projectName, successmsg.getText());
	}
	public void clickOnProjNameLink(String projectName)
	{
		if(projNameLink.getText().equalsIgnoreCase(projectName))
		{
		projNameLink.click();
		}
		else
		{
			System.out.println("Project Not Matching");
		}
	}
	public void verifyDeleteProjectMsg()
	{
		String expected="Project has been successfully deleted.";
		String actual=successmsg.getText();
		slib.validate(expected, actual, expected);
	}
	public void clickOnOpenTask()
	{
		openTaskBtn.click();
	}
	
	

}
