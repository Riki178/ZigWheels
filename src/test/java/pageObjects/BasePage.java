package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	protected WebDriver driver; //Initialize the driver
	
	// Constructor of the driver
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void highlightElement(WebElement element) {

		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;')", element);

		} catch (Exception e) {}

	}
}
