package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import driver.SingaltoneDriver;
import model.Email;
import pages.CalculatorPage;
import pages.HomePage;
import pages.MyEmailPage;
import pages.SearchPage;
import pages.YopmailHomePage;
import service.EmailCreator;

public class TestCalculation extends CommonConditions {
	private final Logger logger = LogManager.getRootLogger();
	
	public String createEmail() {
		Email email = EmailCreator.withEmptyPassword();
		
		YopmailHomePage yopmailHomePage = new YopmailHomePage(driver).openHomePage();
		MyEmailPage yopmail = yopmailHomePage.createNewEmail(email);
		return email.getUsername() + yopmail.getAliasAddres();
	}

	@Test
	public void culculateCloudPricingTest() {
		logger.info("Test is started");
		String emailAdress = createEmail();

		HomePage homePage = new HomePage(driver);
		homePage.openPage().agreeCoockies().enterValueInSearchBox("Google Cloud Pricing Calculator");

		SearchPage searchPage = homePage.submitSearch();

		CalculatorPage calculator = searchPage.openCalculatorPage();

		calculator.useComputerEngineTab(driver).addNumberOfInstens(4).chooseOperatorSystem(1);
//		
//		.chooseProvisioningModel(1)
//				.chooseSeries(1).chooseMachineType(4).chooseAddGPUs().chooseGPU(4).chooseNumberOfGPUs(1)
//				.chooseDatacenterLocation(1).chooseCommittetUsage(2).addToEstimate();
//
//		Assert.assertEquals("Provisioning model: Regular", calculator.getTextEstemateResult("Provisioning model"));
//		Assert.assertEquals("Instance type: n1-standard-1d", calculator.getTextEstemateResult("Instance type"));
//		Assert.assertEquals("Region: Iowa", calculator.getTextEstemateResult("Region"));
//		Assert.assertEquals("Commitment term: 1 Year", calculator.getTextEstemateResult("Commitment term"));
//		Assert.assertEquals("Operating System / Software: Free",
//				calculator.getTextEstemateResult("Operating System / Software"));
//		Assert.assertEquals("GPU dies: 1 NVIDIA TESLA V100d", calculator.getTextEstemateResult("GPU"));
//
//		calculator.sendEmail(emailAdress);

	}

}
