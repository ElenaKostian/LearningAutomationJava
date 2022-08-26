package forTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebDriverChrome {
	private static WebDriver driver;
	
	WebDriverChrome(){
	}
	
	public static WebDriver getDriver() {
		if (driver == null) {
			driver = new ChromeDriver();
		}
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
}
