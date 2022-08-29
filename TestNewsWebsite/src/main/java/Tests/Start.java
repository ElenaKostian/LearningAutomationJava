package Tests;

import org.openqa.selenium.WebDriver;
import forTests.HomePage;
import forTests.WebDriverChrome;

public class Start {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:/java/chromedriver.exe");
		
		WebDriver driver = WebDriverChrome.getDriver();
		
		HomePage homePage = new HomePage(driver);
		homePage.openHomePage();
		homePage.agreeCookies();
		homePage.openNewsPage();
		homePage.returnToHomePage();
		driver.close();
	}
}
