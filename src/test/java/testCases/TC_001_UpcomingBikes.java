package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_UpcomingBikes extends BaseClass{
	
	@Test(priority = 0,groups = {"Master"})
	public void verify() {
		HomePage h = new HomePage(driver);
		h.verifyTitle();
	}
	
	
	@Test(priority = 1,groups={"Master","Regression"})
	public void upcomingBikes() throws InterruptedException, IOException {
		HomePage hm = new HomePage(driver);
		logger.info("****Clicking on up coming bikes****");
		hm.clickUpcomingBikes();
		Thread.sleep(1000);
		logger.info("****Selecting bike manufacturer as Honda****");
		hm.selectBikeManufacturer();
		Thread.sleep(1000);
		logger.info("****Scrolling the page****");
		hm.scroll();
		Thread.sleep(1000);
		logger.info("****Printing the bike details****");
		hm.bikeDetails();
		Thread.sleep(1000);
		logger.info("****Navigating to home page****");
		hm.home();
	}
}
