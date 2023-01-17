package pages;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

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

	@FindBy(xpath = "//input[@id='input_90']")
	WebElement numberOfInstens;
	
	@FindBy(xpath = "//*[@id=\"select_value_label_82\"]/span[2]")
	WebElement operatorSystemDropdown;
	
	@FindBy(xpath = "//*[@id='select_container_104']//md-option")
	List<WebElement> operatorSystems;
	
	@FindBy(xpath = "//*[@id=\"select_value_label_83\"]/span[2]") 
	WebElement provisioningModelDropdown;
	
	@FindBy(xpath = "//*[@id='select_container_108']//md-option/div")
	List<WebElement> provisioningModels;
 
	@FindBy(xpath = "//*[@id='select_value_label_86']/span[2]")
	WebElement machineTypeDropdown;
	
	@FindBy(xpath = "//*[@id='select_container_118']//md-option/div[1]")
	List<WebElement> machineTypes;
	
	@FindBy(xpath = "//*[@id=\"mainForm\"]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[12]/div[1]/md-input-container/md-checkbox/div[1]")
	WebElement tickAddGPUs;
 
	@FindBy(xpath = "//*[@id='select_461']")
	WebElement gPUDropdawn;
	
	@FindBy(xpath = "//*[@id='select_container_462']//md-option") 
	List<WebElement> gPUDs;
	
	@FindBy(xpath = "//*[@id='select_463']/md-select-value")
	WebElement gPUNumberDropdawn;
	
	@FindBy(xpath = "//*[@id='select_container_464']//md-option")
	List<WebElement> gPUDNumbers;
	
	@FindBy(xpath="//*[@id='select_value_label_85']")
	WebElement seriesDropdown;
	
	@FindBy(xpath="//*[@id=\"select_container_116\"]/md-select-menu//md-option")
	List<WebElement> series;
	
	@FindBy(xpath="//button[@aria-label='Add to Estimate']")
	WebElement submitButton;
	
	@FindBy(xpath="//*[@id='compute']/md-list/md-list-item/div[1]")
	List<WebElement> estemateResults;
	
	@FindBy(xpath="//*[@id='select_value_label_88']")
	WebElement datacenterLocationDropdown;
	
	@FindBy(xpath="//*[@id='select_container_124']//md-option")
	List<WebElement> datacenterLocations;

	@FindBy(xpath="//*[@id='select_130']")
	WebElement committetUsageDropdown;
	
	@FindBy(xpath="//*[@id='select_container_131']/md-select-menu//md-option")
	List<WebElement> committetUsages;
	
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
		return this;
	}

	public CalculatorPage addNumberOfInstens(int i) {
		numberOfInstens.sendKeys(""+i);
		return this;
	}

	public CalculatorPage chooseOperatorSystem(int n) {
		operatorSystemDropdown.click();
		if(n<=11 || n>0) {
			operatorSystems.get(n-1).click();
		}else {
			System.out.println("value "+ n + " was send, please use value from 1 to 11");
		}	
		return this;
	}
	

	public CalculatorPage chooseProvisioningModel(int n) {
		provisioningModelDropdown.click();
		if(n<=3 || n>0) {
			provisioningModels.get(n-1).click();
		}else {
			System.out.println("value "+ n + " was send, please use value from 1 to 11");
		}	
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
		return this;
	}

	public CalculatorPage chooseMachineType(int n) {
		machineTypeDropdown.click();
		machineTypes.get(n-1).click();
		return this;
		
	}

	public CalculatorPage chooseAddGPUs(String string) {
		tickAddGPUs.click();
		return this;
	}

	public CalculatorPage chooseNumberOfGPUs(int i) {
		gPUNumberDropdawn.click();
		gPUDNumbers.get(i).click();
		return this;
	}

	public CalculatorPage chooseGPU(int n) {
		gPUDropdawn.click();
		gPUDs.get(n).click();
		return this;
	}

	public CalculatorPage addToEstimate() {
		submitButton.click();
		return this;
	}

	public CalculatorPage chooseDatacenterLocation(int i) {
		datacenterLocationDropdown.click();
		datacenterLocations.get(i).click();
		return this;
	}

	public CalculatorPage chooseCommittetUsage(int i) {
		committetUsageDropdown.click();
		committetUsages.get(i).click();
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
				System.out.println("["+value+"]");
				return value;
			}
		}
		return null;
	}


	

}
