package testCases;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.loginSignup;

@Listeners(utilityFiles.ExtentReportManager.class)
public class TC_003_LoginSignUp extends TC_002_usedCars {
	
	@Test(priority = 4,groups={"Master","Sanity"})
	public void sign() throws IOException, InterruptedException {
		loginSignup obj = new loginSignup(driver);
		logger.info("****Trying to login and capturing the error message****");
		obj.loginSignup();
	}
}
