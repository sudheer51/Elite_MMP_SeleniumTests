package org.iit.hc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.iit.hc.projConfig.projectConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {    

	protected WebDriver driver ;
	public Properties pro;
	@BeforeClass
	public void instantiateDriver() throws IOException
	{
		projectConfiguration pConf = new projectConfiguration();
	    pro = pConf.loadProperties();
		String browser = pro.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")){
			System.out.println("Inside if");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")){	
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}
		driver.manage().window().maximize();
		System.out.println("LastLine of the instatiate method of TestBase");
	}
	
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
}
