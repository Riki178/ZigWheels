package testBase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;


public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeTest(groups = {"Master","Sanity","Regression"})
	@Parameters({"browser","os"})
	
	// method for choosing the browser option
	public void setup(String br,String os) throws IOException {
		
		// loading properties file
		FileReader file = new FileReader(".//src/test/resources/config.properties");
		p = new Properties();
		p.load(file);
		
		
		// loading log4 file
		logger = LogManager.getLogger(this.getClass());
		
		ChromeOptions chromeOptions=new ChromeOptions();
		chromeOptions.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		chromeOptions.addArguments("--disable-notifications");
		
		EdgeOptions edgeOptions=new EdgeOptions();
		edgeOptions.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		edgeOptions.addArguments("--disable-notifications");
				
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
	 	{	
		
		DesiredCapabilities capabilities=new DesiredCapabilities();
		
		//os
		if(os.equalsIgnoreCase("windows"))
		{
			capabilities.setPlatform(Platform.WIN11);
		}
		else if(os.equalsIgnoreCase("mac"))
		{
			capabilities.setPlatform(Platform.MAC);
		}
		else
		{
			System.out.println("No matching os..");
			return;
		}
		
		//browser
		switch(br.toLowerCase())
		{
		case "chrome" : capabilities.setBrowserName("chrome"); break;
		case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
		default: System.out.println("No matching browser.."); return;
		}
		
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
	    }
		
	 //If execution_env is local then run in local system
	else if(p.getProperty("execution_env").equalsIgnoreCase("local"))
	{
		//launching browser based on condition - locally
		switch(br.toLowerCase())
		{
		case "chrome": driver=new ChromeDriver(chromeOptions); break;
		case "edge": driver=new EdgeDriver(edgeOptions); break;
		default: System.out.println("No matching browser.."); return;
					
		}
	}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}
	
	
	// method for closing all the browsers
	@AfterTest(groups = {"Master","Sanity","Regression"})
	public void tearDown() {
		driver.quit();
	}
}
