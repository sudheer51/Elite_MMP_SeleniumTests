package org.iit.hc.mmp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperClass {
	
	WebDriver driver ;
	public HelperClass(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void login(String uname,String pword)
	{
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pword);
		driver.findElement(By.name("submit")).click();
	}
	public void navigateToAModule(String tabName)
	{
		driver.findElement(By.xpath("//span[contains(normalize-space(),'"+tabName+"')]")).click();
		
	}

}
