package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
		logger.info("Homepage: cookies are agreed");
		return this;
	}
	public HomePage openPage() {
		driver.get(URL_HOMEPAGE);
		logger.info("HomePage: page is oppened");
		return this;
	}
	
	public HomePage enterValueInSearchBox(String text) {
		searchBox.sendKeys(text);
		logger.info("HomePage: Value ["+ text + "] is enter in search box");
		return this;
	}
	
	public SearchPage submitSearch() {
		searchBox.submit();
		logger.info("HomePage: Search function is used");
		return new SearchPage(driver);
	}
	
}
