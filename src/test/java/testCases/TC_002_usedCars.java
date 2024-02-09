package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.UsedCars;

public class TC_002_usedCars extends TC_001_UpcomingBikes {
	
	@Test(priority = 3,groups={"Master","Regression"})
	public void usedCars() throws InterruptedException, IOException {
		UsedCars uc = new UsedCars(driver);
		HomePage hm = new HomePage(driver);
		logger.info("****Clicking on the used cars drop down and clicking on chennai****");
		uc.clickUsedCars();
		Thread.sleep(1000);
		logger.info("****Getting the popular car names****");
		uc.getPopularCarModels();
		Thread.sleep(1000);
		logger.info("****Navigating to the home page****");
		hm.home();
	}
}
