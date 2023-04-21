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
		
		 try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		 HomePage homepage = loginPage.enterPassword(UserCreator.getTestdataPassword());
		 homepage.acceptAllCookies();
		 
		 try {
				Thread.sleep(1000);;
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 
		 return homepage;
	}
	
	public static MailRuPage LogOut(WebDriver driver) {
		HomePage homepage = new HomePage(driver);
		MailRuPage page = homepage.singOut(); 
		 return page;
	}
}
