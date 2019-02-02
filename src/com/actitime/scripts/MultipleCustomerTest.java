package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.pageobjects.ActiveProjAndCustPage;
import com.actitime.pageobjects.CreateNewCustPage;
import com.actitime.pageobjects.EditCustInfoPage;
import com.actitime.pageobjects.EnterTimeTrackPage;
import com.actitime.pageobjects.LoginPage;
import com.actitime.pageobjects.OpenTasksPage;
import com.actitime.utilities.BaseLib;
import com.actitime.utilities.ExcelUtilities;

public class MultipleCustomerTest extends BaseLib 
{
	@Test
	public void createMultiplecustomer()
	{
		String file="./testdata/actitimedata.xlsx";
		String username=ExcelUtilities.readData(file, "Sheet1", 12, 1);
		String password=ExcelUtilities.readData(file, "Sheet1", 12, 2);
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		
		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
		ettp.clickOnTasks();
		
		OpenTasksPage otp=new OpenTasksPage(driver);
		otp.clickOnProjAndCustLink();
		int row=12;
		int col=3;
		for(int i=0;i<=3;i++)
		{
			
			ActiveProjAndCustPage apcp=new ActiveProjAndCustPage(driver);
			apcp.clickOnCreateNewCustBtn();
			
			String customerName=ExcelUtilities.readData(file, "Sheet1", row, col);
			CreateNewCustPage cncp=new CreateNewCustPage(driver);
			cncp.createCustomer(customerName);
		
			apcp.verifyCreateCustMsg(customerName);
			
			col++;
		}
		row=12;
		col=3;
		for(int j=0;j<=3;j++)
		{
			String customerName=ExcelUtilities.readData(file, "Sheet1", row, col);
			ActiveProjAndCustPage apcp=new ActiveProjAndCustPage(driver);
			apcp.showCustomer(customerName);
			
			EditCustInfoPage edcip=new EditCustInfoPage(driver);
			edcip.deleteCustomer();
			
			apcp.verifyDeleteCustomer();
			
			col++;
			System.out.println(row);
		}
		
		
	}
	

}
