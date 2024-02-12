package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.fasterxml.jackson.core.sym.Name;

import freemarker.log.Logger;
import utilityFiles.ExcelUtils;
import utilityFiles.Screenshots;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	// Elements
	
	// Home page element
	@FindBy(xpath="//div[@class='row qlc']//div[@class='col-lg-2']")
	WebElement home;					
	
	// New bikes hover option element
	@FindBy(xpath = "//div[@class='col-lg-12 pl-0']/ul/li[3]")
	WebElement newBikes;
	
	// upcoming bikes element
	@FindBy(xpath="//span[@onclick=\"goToUrl('/upcoming-bikes')\"]")
	WebElement UpcomingBikes;
	
	// Manufacturers drop down element
	@FindBy(xpath="//select[@id='makeId']")
	WebElement manufactureres;
	
	// Honda cars
	@FindBy(xpath="//h1[@class='mt-0 pt-2 pull-left zm-cmn-colorBlack']")
	WebElement honda;
	
	// View more button
	@FindBy(xpath ="//li[@class='txt-c clr moreModels mb-20']//span[@class='zw-cmn-loadMore']")
	WebElement viewMoreBikes;
	
	// Bike cards element
	@FindBy(xpath="//ul[@class='mk-row srp_main_div clr']//li[contains(@class,'col-lg-4 txt-c rel modelItem')]")
	List<WebElement> bikesAvailable;
	
	// Bikes names element
	@FindBy(xpath="//a[@data-track-label='model-name']")	
	List<WebElement> names;
	
	// Bikes prices element
	@FindBy(xpath="//a[@data-track-label='model-name']//following-sibling::div[1]")
	List<WebElement> prices;
	
	// Bikes dates element
	@FindBy(xpath="//a[@data-track-label='model-name']//following-sibling::div[2]")
	List<WebElement> dates;
	
	//Actions
	
	Screenshots sc = new Screenshots(driver);
	
	// Verify the title
	public void verifyTitle() {
		
		String exp_title = "New Cars & Bikes, Prices, News, Reviews, Buy & Sell Used Cars - ZigWheels.com";
		String act_title = driver.getTitle();
		System.out.println("The expected title is : "+exp_title);
		Assert.assertEquals(exp_title, act_title);
	}
	
	// Method clicking on the upcoming bikes
	public void clickUpcomingBikes() throws InterruptedException, IOException
	{	
		Actions act = new Actions(driver);
		act.moveToElement(newBikes).build().perform();
		Thread.sleep(3000);
		UpcomingBikes.click();
		Thread.sleep(1000);
	}
	
	// method for selecting the bike manufacturer as Honda
	public void selectBikeManufacturer() throws InterruptedException, IOException {
		Select objSelect = new Select(manufactureres);
		objSelect.selectByVisibleText("Honda");
		Thread.sleep(1000);
		sc.ScreenShot("Honda");
		Thread.sleep(1000);
		
	}
	
	// Method for sroll the page
	public void scroll() throws InterruptedException, IOException {
		
		Screenshots sc = new Screenshots(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,980);", "");
		sc.ScreenShot("bikes");
		Thread.sleep(2000);
		
	//	Thread.sleep(2000);		
		viewMoreBikes.click();
		js.executeScript("window.scrollBy(980,1150);", "");
		Thread.sleep(3000);
	}
	
	// Method for printing the bikes details
	public void bikeDetails() throws InterruptedException, IOException {
		
		int k = 1;
		for(int i=0;i<names.size();i++) {
			if(Integer.parseInt(bikesAvailable.get(i).getAttribute("data-price"))<400000 ) {
				System.out.println(names.get(i).getText()+" : "+prices.get(i).getText()+" : "+dates.get(i).getText());
				String file = System.getProperty("user.dir")+"\\testData\\data_hackathon.xlsx";
				ExcelUtils ex = new ExcelUtils();
				ex.setCellData(file, "Sheet1", k, 0, names.get(i).getText());
				ex.setCellData(file, "Sheet1", k, 1, prices.get(i).getText());
				ex.setCellData(file, "Sheet1", k, 2, dates.get(i).getText());
				k++;
			}

		}
	}
	
	// Method for navigating to the home page
	public void home() throws InterruptedException, IOException {
		home.click();
		Thread.sleep(1000);
		sc.ScreenShot("Home");
	}
	

}








