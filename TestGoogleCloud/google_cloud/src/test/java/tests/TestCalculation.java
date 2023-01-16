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
	public void runTest() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		HomePage homePage = new HomePage(driver);
		homePage.openPage().agreeCoockies().enterValueInSearchBox("Google Cloud Pricing Calculator");
		
		SearchPage searchPage = homePage.submitSearch();

		CalculatorPage calculator = searchPage.openCalculatorPage();

		calculator.useComputerEngineTab(driver).addNumberOfInstens(4).chooseOperatorSystem(1).chooseProvisioningModel(1)
				.chooseSeries(1).chooseMachineType(4).chooseAddGPUs("Add GPUs").chooseGPU(4).chooseNumberOfGPUs(1)
				.addToEstimate();

		Assert.assertEquals("Provisioning model: Regular", calculator.getTextEstemateResultProvisioningModel());
		driver.quit();
	}

}
