package forTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page{
	private final static String URL = "https://gazetawroclawska.pl";
	private final static By buttonAgreeCookies = By.id("didomi-notice-agree-button");
	private final static By navigationImageToHomePage = By.className("componentsNavigationNavbar__href");
	private final static By navigationNewsPage = By.xpath("/html/body/div[5]/nav/div/div[2]/div[2]/div/ul[1]/li[1]/a");
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void openHomePage () {
		getDriver().get(URL);
	}
	
	public void agreeCookies() {
		getDriver().findElement(buttonAgreeCookies).click();
	}
	
	public  void returnToHomePage(){
		getDriver().findElement(navigationImageToHomePage).click();
	}
	
	public NewsPage openNewsPage() {
		driver.findElement(navigationNewsPage).click();
		return new NewsPage(driver);
	}
}
