package driver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SingaltoneDriver {
	private static WebDriver driver;
	
	private SingaltoneDriver() {}
	
	public static WebDriver getDriver() {
		if(driver == null) {
            switch (System.getProperty("browser")){
            case "firefox": {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
				break;
				}
			case "edge":{
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			}
			default: {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		}
		return driver;
	}

	public static void closeDriver() {
		driver.quit();
		driver = null;
		
	}
public static void openNewTab() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"T");
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabs.size()-1));
	}
	
	public static void changeTab(int tabNumber) {
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(tabNumber-1));
	}
}
