package forTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebDriverChrome {
	private static WebDriver driver;
	
	WebDriverChrome(WebDriver driver){
	}
	
	public static WebDriver getDriver() {
		if (driver == null) {
			driver = new ChromeDriver();
		}
		return driver;
	}
	
}
