package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YopmailHomePage extends AbstractPage{
	private final String URL = "https://yopmail.com/";
	private String newMailAdress;
	
	@FindBy(xpath = "//button[@id='accept']")
	WebElement buttonAgreeCookies;
	
	@FindBy(xpath = "//*[@id='login']")
	WebElement inputNewEmailName;
	
	@FindBy(xpath = "//*[@id='ddom']")
	WebElement dailyDomain;
	
	@FindBy(xpath = "//*[@id='refreshbut']/button")
	WebElement buttonCreateEmail;
	
	public YopmailHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public YopmailHomePage openHomePage() {
		driver.get(URL);
		buttonAgreeCookies.click();
		return this;
	}
	
	public MyEmailPage createNewEmail(String emailName) {
		inputNewEmailName.sendKeys(emailName);
		newMailAdress = dailyDomain.getText();
		buttonCreateEmail.click();
		return new MyEmailPage(driver);
	}

}
