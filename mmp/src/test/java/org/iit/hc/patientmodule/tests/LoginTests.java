package org.iit.hc.patientmodule.tests;

import org.iit.hc.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.IOException;

public class LoginTests extends TestBase{
 
	@Test
	public void loginTests() throws IOException
	{
	 
		 
		driver.get("https://www.google.com/");
		String actual = driver.getTitle();
		String expected="Google";
	        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshotFile,new File("Google.jpg"));
		Assert.assertEquals(actual,expected);
	}

}
