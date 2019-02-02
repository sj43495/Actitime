package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.pageobjects.CreateNewUserPage;
import com.actitime.pageobjects.EditUserSettingPage;
import com.actitime.pageobjects.EnterTimeTrackPage;
import com.actitime.pageobjects.LoginPage;
import com.actitime.pageobjects.UserList;
import com.actitime.utilities.BaseLib;
import com.actitime.utilities.ExcelUtilities;

public class UserTest extends BaseLib 
{
	@Test(description="verifying create new user")
	public void createNewUser()
	{
		String file="./testdata/actitimedata.xlsx";
		String username=ExcelUtilities.readData(file, "Sheet1", 9, 1);
		String password=ExcelUtilities.readData(file, "Sheet1", 9, 2);
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		
		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
		ettp.clickOnUsers();
		
		UserList ul=new UserList(driver);
		ul.clickOnCreateNewUserBtn();
		
		String userName=ExcelUtilities.readData(file, "Sheet1", 9, 3);
		String pwd=ExcelUtilities.readData(file, "Sheet1", 9, 4);
		String retypePwd=ExcelUtilities.readData(file, "Sheet1", 9, 4);
		String firstName=ExcelUtilities.readData(file, "Sheet1", 9, 5);
		String lastName=ExcelUtilities.readData(file, "Sheet1", 9, 6);
		String email=ExcelUtilities.readData(file, "Sheet1", 9, 7);
		CreateNewUserPage cnup=new CreateNewUserPage(driver);
		cnup.createUser(userName, pwd, retypePwd, firstName, lastName, email);
		
		ul.verifyCreateUser();
		ul.clickOnLogout();
	}
	@Test(dependsOnMethods={"createNewUser"},description="verifying delete user")
	public void deleteUser()
	{
		String file="./testdata/actitimedata.xlsx";
		String username=ExcelUtilities.readData(file, "Sheet1", 11, 1);
		String password=ExcelUtilities.readData(file, "Sheet1", 11, 2);
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		
		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
		ettp.clickOnUsers();
		
		UserList ul=new UserList(driver);
		ul.clickOnUserNameLink();
		
		EditUserSettingPage eusp=new EditUserSettingPage(driver);
		eusp.clickOnDelThisUser();
		
		ul.verifyDeleteUser();
		ul.clickOnLogout();
	}

}
