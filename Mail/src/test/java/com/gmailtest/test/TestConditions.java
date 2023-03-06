package com.gmailtest.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.gmailtest.driver.Driver;
import com.gmailtest.util.TestListener;

@Listeners({TestListener.class})
public class TestConditions {

    protected WebDriver driver;


    @BeforeMethod
    public void setUp()
    {
        driver = Driver.getDriver();
    }

    @AfterMethod
    public void stopBrowser()
    {
        Driver.closeDriver();
    }
}
