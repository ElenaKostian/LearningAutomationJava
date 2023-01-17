package tests;

import java.time.Duration;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CalculatorPage;
import pages.HomePage;
import pages.SearchPage;

public class TestCalculation {
	private WebDriver driver = new ChromeDriver();

	@Test
	public void culculateCloudPricingTest() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		HomePage homePage = new HomePage(driver);
		homePage.openPage().agreeCoockies().enterValueInSearchBox("Google Cloud Pricing Calculator");
		
		SearchPage searchPage = homePage.submitSearch();

		CalculatorPage calculator = searchPage.openCalculatorPage();

		calculator.useComputerEngineTab(driver).addNumberOfInstens(4).chooseOperatorSystem(1).chooseProvisioningModel(1)
				.chooseSeries(1).chooseMachineType(4).chooseAddGPUs("Add GPUs").chooseGPU(4).chooseNumberOfGPUs(1)
				.chooseDatacenterLocation(1).chooseCommittetUsage(2).addToEstimate();

		Assert.assertEquals("Provisioning model: Regular", calculator.getTextEstemateResult("Provisioning model"));
		Assert.assertEquals("Instance type: n1-standard-1d", calculator.getTextEstemateResult("Instance type"));
		Assert.assertEquals("Region: Iowa", calculator.getTextEstemateResult("Region"));
		Assert.assertEquals("Commitment term: 1 Year", calculator.getTextEstemateResult("Commitment term"));
		Assert.assertEquals("Operating System / Software: Free", calculator.getTextEstemateResult("Operating System / Software"));
		Assert.assertEquals("GPU dies: 1 NVIDIA TESLA P4d", calculator.getTextEstemateResult("GPU"));
		
		/*Next task:
	  	Select 'EMAIL ESTIMATE'.
		In a new tab, open https://yopmail.com/ or a similar temporary email–generating service.
		Copy the email generated in yopmail.com.
		Return to the calculator and enter the above email into the email field.
		Press 'SEND EMAIL'.
		Wait for the cost estimate email and check that the emailed 'Total Estimated Monthly Cost' matches the result in the calculator.*/
		driver.quit();
	}

}
