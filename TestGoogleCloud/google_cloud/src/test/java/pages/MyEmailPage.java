package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyEmailPage extends AbstractPage{
	
	@FindBy(xpath = "//*[@id='autoaltcpt']")
	WebElement aliasAddres;
	
	
	public MyEmailPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String getAliasAddres() {
		return aliasAddres.getText();
	}
	
}
