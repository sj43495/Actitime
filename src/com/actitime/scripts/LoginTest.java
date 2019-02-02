package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.pageobjects.EnterTimeTrackPage;
import com.actitime.pageobjects.LoginPage;
import com.actitime.utilities.BaseLib;
import com.actitime.utilities.ExcelUtilities;

public class LoginTest extends BaseLib 
{
	@Test(priority=1, description="verifying Home Page")
	public void validLogin()
	{
		String file="./testdata/actitimedata.xlsx";
		String username=ExcelUtilities.readData(file, "Sheet1", 1, 1);
		String password=ExcelUtilities.readData(file, "Sheet1", 1, 2);
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		
		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
		ettp.verifyHomePage();
		
	}
	@Test(priority=2, description="verifying invalid login message")
	public void invalidLogin()
	{
		String file="./testdata/actitimedata.xlsx";
		String username=ExcelUtilities.readData(file, "Sheet1", 2, 1);
		String password=ExcelUtilities.readData(file, "Sheet1", 2, 2);
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		lp.verifyInvalidLoginMsg();
	}
	@Test(enabled=false,description="verifying Login with New User")
	public void LoginNewUser()
	{
		String file="./testdata/actitimedata.xlsx";
		String username=ExcelUtilities.readData(file, "Sheet1", 10, 1);
		String password=ExcelUtilities.readData(file, "Sheet1", 10, 2);
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		
		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
		ettp.verifyHomePage();
		
	}

}
