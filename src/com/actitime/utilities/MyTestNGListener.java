package com.actitime.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.google.common.io.Files;

public class MyTestNGListener implements ITestListener
{
	public static int scriptExeCount, passCount, failCount, skipCount=0;

	@Override
	public void onTestStart(ITestResult result) 
	{
		scriptExeCount++;
		Reporter.log(result.getName()+" Script Execution starts"+new Date(),true);
	}
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		passCount++;
		Reporter.log(result.getName()+" Script is passed :",true);
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		failCount++;
		Reporter.log(result.getName()+" Script failed",true);
		TakesScreenshot ts=(TakesScreenshot) BaseLib.driver;
		File srcFile=ts.getScreenshotAs(OutputType.FILE);
		File destFile=new File("./screenshots/"+result.getName()+".png");
		try {
			Files.copy(srcFile, destFile);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	@Override
	public void onTestSkipped(ITestResult result) 
	{
		skipCount++;
		Reporter.log(result.getName()+"Script skipped",true);
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) 
	{
		Reporter.log("Suite Execution starts"+new Date(),true);
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		Reporter.log("Suite Execution ends"+new Date(), true);
		Reporter.log("Total Script Executed:"+scriptExeCount,true);
		Reporter.log("Total Script Passed:"+passCount,true);
		Reporter.log("Total Script Failed:"+failCount,true);
		Reporter.log("Total Script Skipped:"+skipCount,true);
	}

}
