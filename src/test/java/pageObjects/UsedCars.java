package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import utilityFiles.ExcelUtils;
import utilityFiles.Screenshots;

public class UsedCars extends BasePage {

	public UsedCars(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	
	// Used cars hover option element
	@FindBy(xpath="//a[normalize-space()='Used Cars']")
	WebElement usedCars;

	// Chennai option
	@FindBy(xpath="//span[@onclick=\"goToUrl('/used-car/Chennai')\"]")
	WebElement chennai;
	
	// All the car models
	@FindBy(xpath="//ul[@class='zw-sr-secLev usedCarMakeModelList popularModels ml-20 mt-10']//li")
	List<WebElement> carModels;
	
	//Actions
	
	Screenshots sc = new Screenshots(driver);
	
	// Method for clicking on the used cars
	public void clickUsedCars() throws InterruptedException, IOException {
		Actions act = new Actions(driver);
		act.moveToElement(usedCars).perform();
		Thread.sleep(2000);
		sc.ScreenShot("usedCars");
		chennai.click();
		Thread.sleep(1000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500);", "");
	}
	
	// Method for getting popular models details
	public void getPopularCarModels() throws IOException, InterruptedException {
		for(int i=0;i<carModels.size();i++) {
			System.out.println(carModels.get(i).getText());
			String file = System.getProperty("user.dir")+"\\testData\\data_hackathon.xlsx";
			ExcelUtils exc = new ExcelUtils();
			exc.setCellData(file, "Sheet2", i+1, 0, carModels.get(i).getText());
			
			JavascriptExecutor j = (JavascriptExecutor) driver;
			j.executeScript("arguments[0].click();", carModels.get(i));
			Thread.sleep(2000);
			Screenshots sc = new Screenshots(driver);
			sc.ScreenShot("Popular_models");
		}
	}

}
