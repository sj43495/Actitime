package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.pageobjects.ActiveProjAndCustPage;
import com.actitime.pageobjects.CreateNewCustPage;
import com.actitime.pageobjects.CreateNewProjPage;
import com.actitime.pageobjects.CreateNewTasksPage;
import com.actitime.pageobjects.EditCustInfoPage;
import com.actitime.pageobjects.EnterTimeTrackPage;
import com.actitime.pageobjects.LoginPage;
import com.actitime.pageobjects.OpenTasksPage;
import com.actitime.utilities.BaseLib;
import com.actitime.utilities.ExcelUtilities;

public class CreateMultipleTask extends BaseLib {
	
	
	@Test
	public void createMutipleTask()
	{
		String file="./testdata/actitimedata.xlsx";
		String username=ExcelUtilities.readData(file, "Sheet1", 13, 1);
		String password=ExcelUtilities.readData(file, "Sheet1", 13, 2);
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		
		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
		ettp.clickOnTasks();
		
		OpenTasksPage otp=new OpenTasksPage(driver);
		otp.clickOnProjAndCustLink();
		
		ActiveProjAndCustPage apcp=new ActiveProjAndCustPage(driver);
		apcp.clickOnCreateNewCustBtn();
		
		String customerName=ExcelUtilities.readData(file, "Sheet1", 13, 3);
		CreateNewCustPage cncp=new CreateNewCustPage(driver);
		cncp.createCustomer(customerName);
		apcp.verifyCreateCustMsg(customerName);
		
		apcp.clickOnCreateNewProjBtn();
		String projectName=ExcelUtilities.readData(file, "Sheet1", 13, 4);
		CreateNewProjPage cnpp=new CreateNewProjPage(driver);
		cnpp.selectCustomer(customerName);
		cnpp.createProjrct(projectName);
		apcp.verifyCreateProject(projectName);
		
		apcp.clickOnOpenTask();
		int col=5;
		for(int i=0;i<=3;i++)
		{
		otp.clickOnCreateNewTaskBtn();
		String taskName=ExcelUtilities.readData(file, "Sheet1", 13, col);
		CreateNewTasksPage cntp=new CreateNewTasksPage(driver);
		cntp.selectCustomer(customerName);
		cntp.selectProject(projectName);
		cntp.createTask(taskName);
		otp.verifyCreateTaskMsg(customerName, projectName);
		col++;
		}
		otp.clickOnProjAndCustLink();
		apcp.showCustomer(customerName);
		
		EditCustInfoPage ecip=new EditCustInfoPage(driver);
		ecip.deleteCustomer();
		
		
	}

}
