package pages;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class CalculatorPage extends AbstractPage{
	
	@FindBy(xpath = "//md-tab-item/div[@title='Compute Engine']")
	WebElement computerEngineTab;

	@FindBy(xpath = "//input[@id='input_94']")
	WebElement numberOfInstens;
	
	@FindBy(xpath = "//*[@id='select_value_label_86']/span[2]")
	WebElement operatorSystemDropdown;
	
	@FindBy(xpath = "//*[@id='select_container_108']//md-option") // +1
	List<WebElement> operatorSystems;
	
	@FindBy(xpath = "//*[@id=\"select_value_label_87\"]/span[2]") 
	WebElement provisioningModelDropdown;
	
	@FindBy(xpath = "//*[@id='select_container_112']//md-option/div")
	List<WebElement> provisioningModels;
 
	@FindBy(xpath = "//*[@id='select_value_label_90']/span[2]")
	WebElement machineTypeDropdown;
	
	@FindBy(xpath = "//*[@id='select_container_122']//md-option/div[1]")
	List<WebElement> machineTypes;
	
	@FindBy(xpath = "//*[@id=\"mainForm\"]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[12]/div[1]/md-input-container/md-checkbox/div[1]")
	WebElement tickAddGPUs;
 
	@FindBy(xpath = "//*[@id='select_464']")
	WebElement gPUDropdawn;
	
	@FindBy(xpath = "//*[@id='select_container_465']//md-option") 
	List<WebElement> gPUDs;
	
	@FindBy(xpath = "//*[@id='select_466']/md-select-value")
	WebElement gPUNumberDropdawn;
	
	@FindBy(xpath = "//*[@id='select_container_467']//md-option")
	List<WebElement> gPUDNumbers;
	
	@FindBy(xpath="//*[@id='select_value_label_89']")
	WebElement seriesDropdown;
	
	@FindBy(xpath="//*[@id='select_container_120']/md-select-menu//md-option")
	List<WebElement> series;
	
	@FindBy(xpath="//div[@class='layout-align-end-start layout-row']/button")
	WebElement submitButton;
	
	@FindBy(xpath="//*[@id='compute']/md-list/md-list-item/div[1]")
	List<WebElement> estemateResults;
	
	@FindBy(xpath="//*[@id='select_value_label_92']")
	WebElement datacenterLocationDropdown;
	
	@FindBy(xpath="//*[@id='select_container_128']//md-option")
	List<WebElement> datacenterLocations;

	@FindBy(xpath="//*[@id='select_134']")
	WebElement committetUsageDropdown;
	
	@FindBy(xpath="//*[@id='select_container_135']/md-select-menu//md-option")
	List<WebElement> committetUsages;
	
	@FindBy(xpath="//*[@id='Email Estimate']")
	WebElement buttonSendEmail;
	
	@FindBy(xpath="//*[@id='input_546']")
	WebElement inputEmailName;
	
	@FindBy(xpath = "//md-dialog-actions/button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']")
	WebElement buttonSendEstimationToEmal;
	
//	@FindBy(xpath="//*[@id='compute']/md-list/md-list-item[4]/div[1]/text()")
//	WebElement textEstemateInstanceType;
	
	public CalculatorPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
			
	}
	
	private static void switchToCalculateFrame(WebDriver driver) {
		driver.switchTo().defaultContent(); 
		driver.switchTo().frame(driver.findElement(By.xpath("/html/body/section/section/main/devsite-content/article/div[2]/article/devsite-iframe/iframe")));
		driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div/div/div/iframe")));
	}
	
	public CalculatorPage useComputerEngineTab(WebDriver driver) {
		switchToCalculateFrame(driver);
		computerEngineTab.click();
		logger.info("CalculatorPage: computerEngineTab is selected");
		return this;
	}

	public CalculatorPage addNumberOfInstens(int i) {
		numberOfInstens.sendKeys(""+i);
		logger.info("CalculatorPage: select numberOfInstens: [" + i + "]");
		return this;
	}

	public CalculatorPage chooseOperatorSystem(int n) {
		operatorSystemDropdown.click();
		operatorSystems.get(n-1).click();
		logger.info("CalculatorPage: selected operator System: [" + n + "]");
		return this;
	}
	

	public CalculatorPage chooseProvisioningModel(int n) {
		provisioningModelDropdown.click();
		provisioningModels.get(n-1).click();
		logger.info("CalculatorPage: selected Provisioning Model: [" + n + "]");
		return this;
		
	}
	
	public CalculatorPage chooseSeries(int i) {
		seriesDropdown.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		series.get(i-1).click();
		logger.info("CalculatorPage: selected Series: [" + i + "]");
		return this;
	}

	public CalculatorPage chooseMachineType(int n) {
		machineTypeDropdown.click();
		machineTypes.get(n-1).click();
		logger.info("CalculatorPage: selected Machine Type: [" + n + "]");
		return this;
		
	}

	public CalculatorPage chooseAddGPUs() {
		tickAddGPUs.click();
		logger.info("CalculatorPage: selected Add GPUs");
		return this;
	}

	public CalculatorPage chooseNumberOfGPUs(int i) {
		gPUNumberDropdawn.click();
		gPUDNumbers.get(i).click();
		logger.info("CalculatorPage: selected Number of GPUs: [" + i + "]");
		return this;
	}

	public CalculatorPage chooseGPU(int n) {
		gPUDropdawn.click();
		gPUDs.get(n-1).click();
		logger.info("CalculatorPage: selected GPU: [" + n + "]");
		return this;
	}

	public CalculatorPage addToEstimate() {
		submitButton.click();
		logger.info("CalculatorPage: estimate the form");
		return this;
	}

	public CalculatorPage chooseDatacenterLocation(int i) {
		datacenterLocationDropdown.click();
		datacenterLocations.get(i-1).click();
		logger.info("CalculatorPage: selected Datacenter Location: [" + i + "]");
		return this;
	}

	public CalculatorPage chooseCommittetUsage(int i) {
		committetUsageDropdown.click();
		committetUsages.get(i-1).click();
		logger.info("CalculatorPage: selected Commite Usage: [" + i + "]");
		return this;
	}
	
	public String getTextEstemateResult(String nameOfField) {
		String value;
				
		for(WebElement field: estemateResults) {
			value = field.getText();
			if(value.contains(nameOfField)) {
				if(value.contains("\n")) {
					value =  new StringBuilder(value).delete(value.indexOf('\n'), value.length()-1).toString();
				}
				return value;
			}
		}
		return null;
	}
	
	public void sendEmail(String name) {
		buttonSendEmail.click();
		inputEmailName.sendKeys(name);
		buttonSendEstimationToEmal.click();
		logger.info("CalculatorPage: email with estimations is send to [" + name + "]");
	}
	


	

}
