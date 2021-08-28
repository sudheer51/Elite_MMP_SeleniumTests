package org.iit.hc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {    

	protected WebDriver driver ;
	protected Properties pro;
	@BeforeClass
	public void instantiateDriver() throws IOException
	{
		loadProperties();
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
	public void loadProperties() throws IOException
	{
		pro = new Properties();
		File f = new File(System.getProperty("user.dir") + "\\config\\config.properties");
		FileInputStream fis = new FileInputStream(f);
		pro.load(fis);
	}
	@AfterClass
	public void closeBrowser()
	{
		//driver.quit();
	}
}
