package com.gmailtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MailRuPage extends AbstractPage {
	
	public MailRuPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
}
