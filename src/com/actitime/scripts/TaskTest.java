package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.pageobjects.ActiveProjAndCustPage;
import com.actitime.pageobjects.CreateNewCustPage;
import com.actitime.pageobjects.CreateNewProjPage;
import com.actitime.pageobjects.CreateNewTasksPage;
import com.actitime.pageobjects.EditCustInfoPage;
import com.actitime.pageobjects.EditProjInfoPage;
import com.actitime.pageobjects.EnterTimeTrackPage;
import com.actitime.pageobjects.LoginPage;
import com.actitime.pageobjects.OpenTasksPage;
import com.actitime.pageobjects.ViewOpenTaskPage;
import com.actitime.utilities.BaseLib;
import com.actitime.utilities.ExcelUtilities;

public class TaskTest extends BaseLib
{
	@Test(description="verify create customer")
	public void createCustomer()
	{
	String file="./testdata/actitimedata.xlsx";
	String username=ExcelUtilities.readData(file, "Sheet1", 3, 1);
	String password=ExcelUtilities.readData(file, "Sheet1", 3, 2);
	LoginPage lp=new LoginPage(driver);
	lp.login(username, password);
	
	EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
	ettp.clickOnTasks();
	
	OpenTasksPage otp=new OpenTasksPage(driver);
	otp.clickOnProjAndCustLink();
	
	ActiveProjAndCustPage apcp=new ActiveProjAndCustPage(driver);
	apcp.clickOnCreateNewCustBtn();
	
	String customerName=ExcelUtilities.readData(file, "Sheet1", 3, 3);
	CreateNewCustPage cncp=new CreateNewCustPage(driver);
	cncp.createCustomer(customerName);
	
	apcp.verifyCreateCustMsg(customerName);
	apcp.clickOnLogout();
	}
	@Test(enabled = false,dependsOnMethods={"createCustomer"},description="verifying delete customer")
	public void deleteCustomer()
	{
		String file="./testdata/actitimedata.xlsx";
		String username=ExcelUtilities.readData(file, "Sheet1", 4, 1);
		String password=ExcelUtilities.readData(file, "Sheet1", 4, 2);
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		
		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
		ettp.clickOnTasks();
		
		OpenTasksPage otp=new OpenTasksPage(driver);
		otp.clickOnProjAndCustLink();
		
		String customerName=ExcelUtilities.readData(file, "Sheet1", 4, 3);
		ActiveProjAndCustPage apcp=new ActiveProjAndCustPage(driver);
		apcp.showCustomer(customerName);
		
		EditCustInfoPage edcip=new EditCustInfoPage(driver);
		edcip.deleteCustomer();
		
		apcp.verifyDeleteCustomer();
		apcp.clickOnLogout();
		
	}
	@Test(dependsOnMethods={"createCustomer"},description="verifying Create project")
	public void createProject()
	{
		String file="./testdata/actitimedata.xlsx";
		String username=ExcelUtilities.readData(file, "Sheet1", 5, 1);
		String password=ExcelUtilities.readData(file, "Sheet1", 5, 2);
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		
		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
		ettp.clickOnTasks();
		
		OpenTasksPage otp=new OpenTasksPage(driver);
		otp.clickOnProjAndCustLink();
		
		ActiveProjAndCustPage apcp=new ActiveProjAndCustPage(driver);
		apcp.clickOnCreateNewProjBtn();
		
		String customerName=ExcelUtilities.readData(file, "Sheet1", 5, 3);
		String projectName=ExcelUtilities.readData(file, "Sheet1", 5, 4);
		CreateNewProjPage cnpp=new CreateNewProjPage(driver);
		cnpp.selectCustomer(customerName);
		cnpp.createProjrct(projectName);
		
		apcp.verifyCreateProject(projectName);
		apcp.clickOnLogout();
	}
	@Test(enabled=false,dependsOnMethods={"createProject"},description="verifying delete Project")
	public void deleteProject()
	{
		String file="./testdata/actitimedata.xlsx";
		String username=ExcelUtilities.readData(file, "Sheet1", 6, 1);
		String password=ExcelUtilities.readData(file, "Sheet1", 6, 2);
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		
		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
		ettp.clickOnTasks();
		
		OpenTasksPage otp=new OpenTasksPage(driver);
		otp.clickOnProjAndCustLink();
		
		String projectName=ExcelUtilities.readData(file, "Sheet1", 6, 4);
		ActiveProjAndCustPage apcp=new ActiveProjAndCustPage(driver);
		apcp.clickOnProjNameLink(projectName);
		
		EditProjInfoPage epip=new EditProjInfoPage(driver);
		epip.deleteProject();
		
		apcp.verifyDeleteProjectMsg();
		apcp.clickOnLogout();
				
		
	}
	@Test(dependsOnMethods={"createProject"},description="verifying create tasks")
	public void createTask()
	{
		String file="./testdata/actitimedata.xlsx";
		String username=ExcelUtilities.readData(file, "Sheet1", 7, 1);
		String password=ExcelUtilities.readData(file, "Sheet1", 7, 2);
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		
		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
		ettp.clickOnTasks();
		
		OpenTasksPage otp=new OpenTasksPage(driver);
		otp.clickOnCreateNewTaskBtn();
		
		String customerName=ExcelUtilities.readData(file, "Sheet1", 7, 3);
		String projectName=ExcelUtilities.readData(file, "Sheet1", 7, 4);
		String taskName=ExcelUtilities.readData(file, "Sheet1", 7, 5);
		CreateNewTasksPage cntp=new CreateNewTasksPage(driver);
		cntp.selectCustomer(customerName);
		cntp.selectProject(projectName);
		cntp.createTask(taskName);
		
		otp.verifyCreateTaskMsg(customerName,projectName);
		otp.clickOnLogout();
	}
	@Test(dependsOnMethods={"createTask"},description="verifying delete tasks")
	public void deleteTask()
	{
		String file="./testdata/actitimedata.xlsx";
		String username=ExcelUtilities.readData(file, "Sheet1", 8, 1);
		String password=ExcelUtilities.readData(file, "Sheet1", 8, 2);
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		
		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
		ettp.clickOnTasks();
		
		String taskName=ExcelUtilities.readData(file, "Sheet1", 8, 5);
		OpenTasksPage otp=new OpenTasksPage(driver);
		otp.clickOnTaskNameLink(taskName);

		ViewOpenTaskPage votp=new ViewOpenTaskPage(driver);
		votp.clickOnDelThisTaskBtn();
		votp.deleteTask();
		
		otp.verifyDeleteTask();
		otp.clickOnLogout();
	}

	

}
