package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import driver.SingaltoneDriver;

public class CommonConditions {
	protected WebDriver driver;
	
@BeforeMethod
public void setUpDriver() {
	driver = SingaltoneDriver.getDriver();
}

@AfterMethod
public void stopBrowser() {
	SingaltoneDriver.closeDriver();
}

}
