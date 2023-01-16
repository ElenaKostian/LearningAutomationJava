/**
 * 
 */
package pages;

import java.util.List;

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
		return new CalculatorPage(driver);
	}

}
