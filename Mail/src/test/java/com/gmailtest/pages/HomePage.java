package com.gmailtest.pages;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {
	private static final String URL_HomePage = "https://myaccount.google.com/?pli=1";
	private static final String URL_INBOX = "https://e.mail.ru/inbox/";
	private static final String URL_DRAFTS = "https://e.mail.ru/drafts/";
	private static final String URL_SENT = "https://e.mail.ru/sent/";
	
	private final Logger logger = LogManager.getRootLogger();
	
	
	@FindBy(xpath="//h1[@class='XY0ASe']")
	private WebElement greetingText;
	
	@FindBy(xpath="//*[@id='cmpbntyestxt']")
	private WebElement acceptAllCookiesButton;
	
	@FindBy(xpath="//div/img[@class='ph-avatar-img svelte-dfhuqc']")
	private WebElement iconDropdownMenu;
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div/div[3]/div/div[2]/div/div[2]/div")
	private WebElement singOutLink;
	
	@FindBy(xpath="//div[@class='ph-desc__email svelte-1popff4']")
	private WebElement userMailAdress;
	
	@FindBy(xpath="//a[@href='/compose/']")
	private WebElement newEmailCreationButton;
	
	@FindBy(xpath="//*[@id='sideBarContent']/div/nav/a[9]/div/div[2]/div")
	private WebElement openDraftsButton;
	
	@FindBy(xpath="//div[@class='ReactVirtualized__Grid__innerScrollContainer']/a")
	private List<WebElement> emailList;
	
	@FindBy(xpath="//*[@href='/inbox/?']")
	private WebElement sentItemsLink;
	
	@FindBy(xpath="//*[@class='button2__ico']")
	private WebElement closeWaitingMark;
	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public HomePage openInboxPageEndpoint() {
		driver.get(URL_INBOX);
		logger.info("Page [" + URL_INBOX + "] is open" );
		return this;
	}
	public HomePage openDraftsPageEndpoint() {
		driver.get(URL_DRAFTS);
		logger.info("Page [" + URL_DRAFTS + "] is open" );
		return this;
	}
	
	public HomePage openSentPageEndpoint() {
		driver.get(URL_SENT);
		logger.info("Page [" + URL_SENT + "] is open" );
		return this;
	}
	
	public String getGreetingText() {
		return greetingText.getText();
	}

	public HomePage acceptAllCookies() {
		acceptAllCookiesButton.click();
		logger.info("all cookies are accepted" );
		return this;
	}
	
	public MailRuPage singOut() {
		iconDropdownMenu.click();
		singOutLink.click();
		logger.info("the user is logout");
		return new MailRuPage(driver);
	}
	
	public String getUserMailAdress() {
		iconDropdownMenu.click();
		String user = userMailAdress.getAttribute("aria-label");
		iconDropdownMenu.click();
		logger.info("taken UserMailAdress is [" + user + "]");
		return user;
		}
	
	public EmailObjectPage createNewMail() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		newEmailCreationButton.click();
		logger.info("New mail is opened");
		return new EmailObjectPage(driver);
	}
	
	public HomePage openDrafts() {
		openDraftsButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
//			.until(ExpectedConditions.urlToBe(URL_DRAFTS));
		logger.info("Page Drafts is open" );
		return this;
	}
	
	public EmailObjectPage openFirstDraft() {
	
		emailList.get(0).click();
		logger.info("Last saved draft mail is open" );
		return new EmailObjectPage(driver);
	}

	public EmailObjectPage openFirstSentItems() {
		emailList.get(0).click();
		logger.info("Last send mail is open" );
		return new EmailObjectPage(driver);
	}

	public HomePage openSentItems() {
		sentItemsLink.click();
		logger.info("Page with sent mails is open" );
		return this;
	}

	public HomePage closeWaitingNatification() {
		closeWaitingMark.click();
		logger.info("pop-up with waiting 20 sec to send mail is closed" );
		return this;
	}

	public String getEndpoint() {
		String endpoint =  driver.getCurrentUrl();
		logger.info("taken endpoint is [" + endpoint + "]");
		return endpoint;
	}
	



	
	

	
	
}
