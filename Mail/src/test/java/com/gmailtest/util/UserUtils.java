package com.gmailtest.util;

import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;

import com.gmailtest.pages.HomePage;
import com.gmailtest.pages.LoginPage;
import com.gmailtest.pages.MailRuPage;
import com.gmailtest.service.UserCreator;

public class UserUtils {
	public static HomePage LogIn(WebDriver driver) {
		 LoginPage loginPage = new LoginPage(driver).openLoginPage()
				 									.enterAdress(UserCreator.getTestdataUserName());
		 HomePage homepage = loginPage.enterPassword(UserCreator.getTestdataPassword());
		 homepage.acceptAllCookies();
		 return homepage;
	}
	
	public static MailRuPage LogOut(WebDriver driver) {
		HomePage homepage = new HomePage(driver);
		MailRuPage page = homepage.singOut(); 
		 return page;
	}
}
