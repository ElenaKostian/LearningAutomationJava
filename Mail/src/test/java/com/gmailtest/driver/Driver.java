package com.gmailtest.driver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	private static WebDriver driver;	
	public Driver() {}

	public static WebDriver getDriver() {
		if (driver == null) {
			switch (System.getProperty("browser")) {
			case "chrome": {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
				}
			case "firefox": {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
				}
			default: {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();}
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			
		}

		return driver;
	}
	
	public static void closeDriver() {
		driver.quit();
		driver = null;
	}

	
	
	
}
