package com.gmailtest.util;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.gmailtest.driver.Driver;

public class TestListener implements ITestListener {
	  private Logger log = LogManager.getRootLogger();

	    public void onTestStart(ITestResult iTestResult) {

	    }

	    public void onTestSuccess(ITestResult iTestResult) {

	    }

	    public void onTestFailure(ITestResult iTestResult) {
	        saveScreenshot();
	    }

	    public void onTestSkipped(ITestResult iTestResult) {

	    }

	    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

	    }

	    public void onStart(ITestContext iTestContext) {

	    }

	    public void onFinish(ITestContext iTestContext) {

	    }

	    private void saveScreenshot(){
	        File screenCapture = ((TakesScreenshot)Driver
	                .getDriver())
	                .getScreenshotAs(OutputType.FILE);
	        String screenshotName = getCurrentTimeAsString();
	        try {
	            FileUtils.copyFile(screenCapture, new File(
	                    ".//target/screenshots/"
	                    + screenshotName +
	                    ".png"));
	            log.info("Screenshot is saved: [" + screenshotName + "]");
	        } catch (IOException e) {
	            log.error("Failed to save screenshot: " + e.getLocalizedMessage());
	        }
	    }

	    private String getCurrentTimeAsString(){
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "uuuu-MM-dd_HH-mm-ss" );
	        return ZonedDateTime.now().format(formatter);
	    }
}
