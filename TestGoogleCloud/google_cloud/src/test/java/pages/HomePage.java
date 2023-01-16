package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage{
	private final static String URL_HOMEPAGE = "https://cloud.google.com/";
	@FindBy(xpath = "//input[@role='searchbox']") 
	private WebElement searchBox;
	@FindBy(xpath = "html/body/devsite-snackbar/div/div/button")
	private WebElement agreeCoockiesButton;
	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public HomePage agreeCoockies() {
		agreeCoockiesButton.click();
		return this;
	}
	public HomePage openPage() {
		driver.get(URL_HOMEPAGE);
		return this;
	}
	
	public HomePage enterValueInSearchBox(String text) {
		searchBox.sendKeys(text);
		return this;
	}
	
	public SearchPage submitSearch() {
		searchBox.submit();
		return new SearchPage(driver);
	}
	
}
