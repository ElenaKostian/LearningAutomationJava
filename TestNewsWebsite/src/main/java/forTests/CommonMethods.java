package forTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CommonMethods {


	public static void openApp (WebDriver driver, String URL) {
		driver.get(URL);
	}
	
	public static void agreeCookies(WebDriver driver) {
		WebElement elementAgreeCookies = driver.findElement(By.id("didomi-notice-agree-button"));
		elementAgreeCookies.click();
	}
	
	public static void openMainPage(WebDriver driver){
		WebElement elementLinkToMainPage = driver.findElement(By.className("componentsNavigationNavbar__href"));
		elementLinkToMainPage.click();
		
	
	}
	public static void openNewsPage(WebDriver driver) {
		WebElement elementLinkToNewspage = driver.findElement(By.xpath("/html/body/div[5]/nav/div/div[2]/div[2]/div/ul[1]/li[1]/a"));
		elementLinkToNewspage.click();	
	}
}
