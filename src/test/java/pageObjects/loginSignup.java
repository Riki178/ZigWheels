package pageObjects;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilityFiles.ExcelUtils;
import utilityFiles.Screenshots;

public class loginSignup extends BasePage {

	public loginSignup(WebDriver driver) {
		super(driver);
	}
	
	// Locators
	
	// login button
	@FindBy(xpath="//div[@class='h-sid h-sid-s fnt-14']")
	WebElement login_btn;
	
	// Login with google button element
	@FindBy(xpath="//div[@class='d-tblc rel']//div[@data-track-label='Popup_Login/Register_with_Google']")
	WebElement google_btn;
	
	// Text area to give input email id
	@FindBy(xpath="//input[@id='identifierId']")
	WebElement email;
	
	// Next Button element
	@FindBy(xpath="//span[normalize-space()='Next']")
	WebElement next_btn;
	
	// Error message element
	@FindBy(xpath="//div[@class='o6cuMc Jj6Lae']")
	WebElement error_msg;
	
	// Actions
	
	Screenshots sc = new Screenshots(driver);
	
	// Method for login sign up
	public void loginSignup() throws IOException, InterruptedException {
	
		login_btn.click();
	//	Thread.sleep(2000);
		sc.ScreenShot("login");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",google_btn);
		Thread.sleep(1000);
		Set<String> winHandleBefore = driver.getWindowHandles();
		for(String winHandle : winHandleBefore){
			String title = driver.switchTo().window(winHandle).getTitle();
			if(title.equals("Sign in - Google Accounts")) {
				driver.switchTo().window(winHandle);
			}
		}
		ExcelUtils ex = new ExcelUtils();
		String file = System.getProperty("user.dir")+"\\testData\\data_hackathon.xlsx";
		String input = ex.getCellData(file, "Sheet3", 1, 0);
		
		email.sendKeys(input);
		next_btn.click();
		String msg = error_msg.getText();
		System.out.println(msg);
		
		Screenshots sc = new Screenshots(driver);
		sc.ScreenShot("Error_msg");
		Thread.sleep(1000);
	}

}










