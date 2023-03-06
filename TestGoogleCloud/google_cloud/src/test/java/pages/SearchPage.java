/**
 * 
 */
package pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SearchPage extends AbstractPage {

	@FindBy(xpath = "//a[@class='gs-title']")
	private List<WebElement> searchResult;

	public SearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public CalculatorPage openCalculatorPage() {
		searchResult.get(0).click();
		logger.info("SearchPage: first result is opened");
		return new CalculatorPage(driver);
	}

}
