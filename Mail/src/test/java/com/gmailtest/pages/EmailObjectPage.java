package com.gmailtest.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gmailtest.model.MailObject;


public class EmailObjectPage extends AbstractPage {
	private final Logger logger = LogManager.getRootLogger();
	
	@FindBy(xpath = "//div[@data-type='to']//input[@type='text']")
	private WebElement addressToInput;

	@FindBy(xpath = "//input[@name='Subject']")
	private WebElement subjectInput;

	@FindBy(xpath = "//div[@class='editable-container-8y57']/div/div[1]/br") /////////////////// doesn't work
	private WebElement bodyInput;

	@FindBy(xpath = "//span[@class='vkuiButton__in']")
	private List<WebElement> emailButtons;

	@FindBy(xpath = "//button[@data-test-id='send']")
	private WebElement sendButton;

	public EmailObjectPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public EmailObjectPage fillInAdressEmail(String addressTo) {
		addressToInput.sendKeys(addressTo);
		return this;
	}

	public EmailObjectPage fillInSubjectEmail(String subject) {
		subjectInput.sendKeys(subject);
		return this;
	}

	public EmailObjectPage fillInBodyEmail(String bodyText) {
		bodyInput.sendKeys(bodyText);
		return this;
	}

	public EmailObjectPage saveDraftEmail() {
		emailButtons.get(1).click();
		logger.info("Email is saved as Draft");
		return this;
	}

	public HomePage cancelEmail() {
		emailButtons.get(2).click();
		return new HomePage(driver);
	}

	public HomePage sendDraftEmail() {
		
		new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-test-id='send']")));

		sendButton.click();
		logger.info("Draft email is sent");
		return new HomePage(driver);
	}

	private String getAdress(Boolean isSentEmail) {
		WebElement adress = null;
		StringBuilder string = new StringBuilder("");
		if (isSentEmail == false) {
			adress = driver.findElement(By.xpath("//div[@class='container--wpBSx']/div"));
			string = string.append(adress.getAttribute("data-test-id"));
			string.delete(0, 16);
		}else {
			adress = driver.findElement(By.xpath("//*[@class='letter__recipient-type']/following-sibling::*[@class = 'letter-contact']"));
			string = string.append(adress.getAttribute("title"));
		}
		logger.info("adress data [" + string + "] is taken from the email");
		return string.toString();
	}

	private String getSubject(Boolean isSentEmail) {
		WebElement subject = null;
		String string = "";
		if (isSentEmail == false) {
			subject = driver.findElement(By.xpath("//*[@name='Subject']"));
			string = subject.getAttribute("value");
		}else {
			subject = driver.findElement(By.xpath("//h2"));
			string = subject.getText();
		}
		logger.info("subject data [" + string + "] is taken from the email");
		return string;
	}

	public MailObject getEmailData(Boolean isSentEmail) {
		MailObject email = new MailObject(getAdress(isSentEmail), getSubject(isSentEmail), "");
		return email;
	}

}
