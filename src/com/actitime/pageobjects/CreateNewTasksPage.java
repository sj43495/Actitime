package com.actitime.pageobjects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.utilities.SeleniumLib;

public class CreateNewTasksPage {
	
	SeleniumLib slib;
	
	@FindBy(name="customerId")
	private WebElement customerDrpDwn;
	
	@FindBy(name="projectId")
	private WebElement projectDrpDwn;
	
	@FindBy(name="task[0].name")
	private WebElement taskNameTxtBx;
	
	@FindBy(name="task[0].deadline")
	private WebElement deadlineTxtBx;
	
	@FindBy(name="task[0].billingType")
	private WebElement billingTypeDrpDwn;
	
	@FindBy(name="task[0].markedToBeAddedToUserTasks")
	private WebElement addToMyTimeTrackChkBx;
	
	@FindBy(css="input[value='Create Tasks']")
	private WebElement createTasksBtn;
	
	@FindBy(id="ext-gen7")
	private WebElement datePicker;
	
	@FindBy(id="ext-gen136")
	private WebElement today;
	
	public CreateNewTasksPage(WebDriver driver)
	{
		slib=new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	public void selectCustomer(String customerName)
	{
		slib.selectOptionByText(customerDrpDwn, customerName);
	}
	public void selectProject(String projectName)
	{
		slib.selectOptionByText(projectDrpDwn, projectName);
	}
	public void createTask(String taskName)
	{
		slib.enterData(taskNameTxtBx, taskName);
		datePicker.click();
		today.click();
		slib.selectOptionByText(billingTypeDrpDwn, "Billable");
		slib.clickcheckbox(addToMyTimeTrackChkBx);
		slib.clickButton(createTasksBtn);
		
	}

}
