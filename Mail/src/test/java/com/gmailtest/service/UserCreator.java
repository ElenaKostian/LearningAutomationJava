package com.gmailtest.service;

import com.gmailtest.model.MailCredentials;

public class UserCreator {
	
	private static final String TESTDATA_USER_NAME = "testdata.user.name";
    private static final String TESTDATA_USER_PASSWORD = "testdata.user.password";

    
	public static MailCredentials withCredentialsFromProperty() {

		return new MailCredentials(TestDataReader.getTestData(TESTDATA_USER_NAME),
                TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
	}

	public static String getTestdataUserName() {
		return TestDataReader.getTestData(TESTDATA_USER_NAME);
	}

	public static String getTestdataPassword() {
		return TestDataReader.getTestData(TESTDATA_USER_PASSWORD);
	}
	
	
}
