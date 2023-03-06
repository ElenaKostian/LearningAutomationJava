package com.gmailtest.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {
	protected WebDriver driver;
	protected final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(10);
	
	public AbstractPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
