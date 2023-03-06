package com.gmailtest.pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {
	private static final String URL_LOGIN_PAGE = "https://account.mail.ru/";
	private final Logger logger = LogManager.getRootLogger();
	
	@FindBy(xpath="//*[text()='Enter password']")
	private WebElement enterPasswordButton;
	
	@FindBy(xpath="//button[@data-test-id='submit-button']")
	private WebElement singInButton;
	
	private final By adressLocator = By.xpath("//input[@name='username']");
	private final By passwordLocator = By.xpath("//input[@name='password']");
	
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	public LoginPage openLoginPage() {
		driver.get(URL_LOGIN_PAGE);
		logger.info("Page " + URL_LOGIN_PAGE + "is opened");
		return this;
	}
	
	public LoginPage enterAdress(String adress) {
		WebElement inputAdress = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.presenceOfElementLocated(adressLocator));
		inputAdress.sendKeys(adress);
		enterPasswordButton.click();
		logger.info("Login: adress is filled");
		return this;
	}
	
	public HomePage enterPassword(String password) {	
		WebElement inputPassword = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.presenceOfElementLocated(passwordLocator));
		inputPassword.sendKeys(password);
		singInButton.click();
		logger.info("Login: password is entered");
		return new HomePage(driver);
	}
	

}
