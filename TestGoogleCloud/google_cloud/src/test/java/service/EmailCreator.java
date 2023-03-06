package service;


import model.Email;

public class EmailCreator {
	public static final String TESTDATA_USER_NAME = "testdata.user.name";
    public static final String TESTDATA_USER_PASSWORD = "testdata.user.password";
    
    
	public static Email withCredentials() {
		Email user = new Email(TestDataReader.getTestData(TESTDATA_USER_NAME),  TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
		return user;
	}
	public static Email withEmptyUsername() {
		Email user = new Email("", TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
		return user;
	}
	public static Email withEmptyPassword() {
		Email user = new Email(TestDataReader.getTestData(TESTDATA_USER_NAME), "");
		return user;
	}
	

}
