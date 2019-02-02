package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.utilities.SeleniumLib;

public class CreateNewProjPage {
	SeleniumLib slib;
	
	@FindBy(name="customerId")
	private  WebElement customerDrpDwnInCreateNewProj;
	
	@FindBy(name="name")
	private WebElement projNameTxtBx;
	
	@FindBy(name="createProjectSubmit")
	private WebElement createProjSubmitBtn;
	
	public CreateNewProjPage(WebDriver driver)
	{
		slib=new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	public void selectCustomer(String customerName)
	{
		slib.selectOptionByText(customerDrpDwnInCreateNewProj, customerName);
	}
	public void createProjrct(String projectName)
	{
		slib.enterData(projNameTxtBx, projectName);
		slib.clickButton(createProjSubmitBtn);
	}
	
	

}
