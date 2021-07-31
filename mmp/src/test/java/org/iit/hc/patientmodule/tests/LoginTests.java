package org.iit.hc.patientmodule.tests;

import org.iit.hc.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
 
	@Test
	public void loginTests()
	{
	 
		 
		driver.get("https://www.yahoo.com/");
		String actual = driver.getTitle();
		String expected="Google";
		
	}

}
