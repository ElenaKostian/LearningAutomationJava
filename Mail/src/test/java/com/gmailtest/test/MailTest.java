package com.gmailtest.test;

import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.gmailtest.model.MailObject;
import com.gmailtest.pages.EmailObjectPage;
import com.gmailtest.pages.HomePage;
import com.gmailtest.service.UserCreator;
import com.gmailtest.util.UserUtils;

public class MailTest extends TestConditions {
	private final Logger logger = LogManager.getRootLogger();
	private static ResourceBundle resourceTestData = ResourceBundle.getBundle("test-data");
	/*
	 * 
	 * • Login to the mail box. • Assert, that the login is successful. • Create a
	 * new mail (fill addressee, subject and body fields).
	 * 
	 * • Save the mail as a draft. • Verify, that the mail presents in ‘Drafts’
	 * folder. • Verify the draft content (addressee, subject and body – should be
	 * the same as in 3).
	 * 
	 * • Send the mail. • Verify, that the mail disappeared from ‘Drafts’ folder. •
	 * Verify, that the mail is in ‘Sent’ folder. • Log off.
	 * 
	 */

 @Test(priority=1)
 public void loginSuccessfulTest() {
	 HomePage emailHomePage = UserUtils.LogIn(driver);
	 Assert.assertTrue(emailHomePage.getEndpoint().startsWith("https://e.mail.ru"));
	 Assert.assertTrue(emailHomePage.getUserMailAdress().equals(UserCreator.getTestdataUserName() + "@mail.ru"));
	 UserUtils.LogOut(driver); 
 }
 
 @Test(priority=2)
 public void saveDraftEmailTest() {
	 MailObject mailInternals = new MailObject(resourceTestData.getString("addressee"), resourceTestData.getString("subject"),"");
	 HomePage mailPage = UserUtils.LogIn(driver);
	 
	 EmailObjectPage email = mailPage.createNewMail();
	 email.fillInAdressEmail(mailInternals.getAddressee())
	 						.fillInSubjectEmail(mailInternals.getSubject())
	 						//.fillInBodyEmail(mailInternals.getBody())
	 						.saveDraftEmail();
	 mailPage = email.cancelEmail()
	 				.openDrafts();
	 
	 EmailObjectPage draftEmail =  mailPage.openFirstDraft();
	 MailObject actualEmailObject = draftEmail.getEmailData(false);

	 Assert.assertEquals(actualEmailObject, mailInternals);	 
 }

	@Test(priority=3)
	public void sandDraftEmail() {

		MailObject mailInternals = new MailObject(resourceTestData.getString("addressee"), resourceTestData.getString("subject"),"");
		
		HomePage mailPage = UserUtils.LogIn(driver);
		EmailObjectPage existedDraftEmail = mailPage.openDrafts().openFirstDraft();
		mailPage = existedDraftEmail.sendDraftEmail();
		
		//wait when email will be sent
		try {
			Thread.sleep(21000);
		} catch (InterruptedException e) {
			logger.info("InterruptedException [" + e+ "] on waiting of sending draft Email");
			e.printStackTrace();
		}
		
		HomePage newMailPage = new HomePage(driver).openSentPageEndpoint();
		EmailObjectPage sentMail = newMailPage.openFirstSentItems();
		MailObject actualEmailObject = sentMail.getEmailData(true);
		
		Assert.assertEquals(mailInternals, actualEmailObject);
		
		EmailObjectPage draftEmail =  mailPage.openDraftsPageEndpoint().openFirstDraft();
		MailObject actualDraftEmailObject = draftEmail.getEmailData(false);
		
		Assert.assertNotEquals(mailInternals, actualDraftEmailObject);

	}

}
