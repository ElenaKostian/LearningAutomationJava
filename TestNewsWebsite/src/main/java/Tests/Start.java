package Tests;

import org.openqa.selenium.WebDriver;
import forTests.CommonMethods;
import forTests.WebDriverChrome;

public class Start {
	
	public static void main(String[] args) {
		String URL = "https://gazetawroclawska.pl";
		System.setProperty("webdriver.chrome.driver","D:/java/chromedriver.exe");
		WebDriver driver = WebDriverChrome.getDriver();
		CommonMethods.openApp(driver, URL);
		CommonMethods.agreeCookies(driver);
		CommonMethods.openNewsPage(driver);
		CommonMethods.openMainPage(driver);
		driver.close();
	}
}
