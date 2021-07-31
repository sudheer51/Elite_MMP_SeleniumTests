package org.iit.hc.patientmodule.tests;

import java.util.HashMap;
import java.util.Random;

import org.iit.hc.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditProfile extends TestBase{


	@Test(enabled=false)
	public void validateEditProfile()
	{
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		driver.manage().window().maximize();
		login("ria1","Ria12345");
		navigateToAModule("Profile");
		HashMap<String, String> expHMap =editupdateProfilePage();
		HashMap<String, String> actHMap = readProfilePageData();
		Assert.assertTrue(expHMap.equals(actHMap));
	}
	@Test
	public void validateEditProfile2Values()
	{
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		driver.manage().window().maximize();
		login("ria1","Ria12345");
		navigateToAModule("Profile");
		HashMap<String, String> expHMap =editupdateProfilePage2Values();
		HashMap<String, String> actHMap = readProfilePageData();
		Assert.assertTrue(expHMap.equals(actHMap));
	}
	/**
	 * Edit and update one value
	 * 
	 * @return
	 */
	public   HashMap<String, String> editupdateProfilePage()
	{
		HashMap<String,String> expectedHMap = new HashMap<String,String>();
		driver.findElement(By.id("Ebtn")).click();
		String fName = "IITWorkForce";
		driver.findElement(By.id("fname")).clear();
		driver.findElement(By.id("fname")).sendKeys(fName);
		expectedHMap.put("fname", fName);
		driver.findElement(By.id("Sbtn")).click();
		String expectedText = "Your Profile has been updated.";
		Alert alrt = driver.switchTo().alert();
		String actualText = alrt.getText();
		alrt.accept();
		if(actualText.equals(expectedText))
		{
			System.out.println("Displayed text is matching");
		}
		else
		{
			System.out.println("Displayed Text is not matching");
		}
		expectedHMap.put("lname",  driver.findElement(By.id("lname")).getAttribute("value"));
		expectedHMap.put("licn",  driver.findElement(By.id("licn")).getAttribute("value"));
		expectedHMap.put("ssn",  driver.findElement(By.id("ssn")).getAttribute("value"));
		expectedHMap.put("addr",  driver.findElement(By.id("addr")).getAttribute("value"));
		expectedHMap.put("age",   driver.findElement(By.id("age")).getAttribute("value"));
		expectedHMap.put("height",  driver.findElement(By.id("height")).getAttribute("value"));
		expectedHMap.put("weight",  driver.findElement(By.id("weight")).getAttribute("value"));
		expectedHMap.put("city",  driver.findElement(By.id("city")).getAttribute("value"));
		expectedHMap.put("state",  driver.findElement(By.id("state")).getAttribute("value"));
		expectedHMap.put("zip",  driver.findElement(By.id("zip")).getAttribute("value"));

		return expectedHMap;


	}
	/**
	 * Edit and update two values
	 * 
	 * @return
	 */
	public   HashMap<String, String> editupdateProfilePage2Values()
	{
		HashMap<String,String> expectedHMap = new HashMap<String,String>();
		//driver.findElement(By.id("Ebtn")).click();
		 JavascriptExecutor jse =(JavascriptExecutor) driver;
		 WebElement e = (WebElement) jse.executeScript("return document.getElementById('Ebtn')");
		 e.click();
		String fName = "IITWorkForce";
		driver.findElement(By.id("fname")).clear();
		driver.findElement(By.id("fname")).sendKeys(fName);
		expectedHMap.put("fname", driver.findElement(By.id("fname")).getAttribute("value"));
		driver.findElement(By.id("Sbtn")).click();
		String expectedText = "Your Profile has been updated.";
		Alert alrt = driver.switchTo().alert();
		String actualText = alrt.getText();
		alrt.accept();
		if(actualText.equals(expectedText))
		{
			System.out.println("Displayed text is matching");
		}
		else
		{
			System.out.println("Displayed Text is not matching");
		}
		expectedHMap.put("lname",  driver.findElement(By.id("lname")).getAttribute("value"));
		expectedHMap.put("licn",  driver.findElement(By.id("licn")).getAttribute("value"));
		expectedHMap.put("ssn",  driver.findElement(By.id("ssn")).getAttribute("value"));
		expectedHMap.put("addr",  driver.findElement(By.id("addr")).getAttribute("value"));
		//Updating the age Field
		driver.findElement(By.id("age")).clear();
		driver.findElement(By.id("age")).sendKeys(readRandomDigit(10,100).toString());
		expectedHMap.put("age",  driver.findElement(By.id("age")).getAttribute("value"));
		expectedHMap.put("height",  driver.findElement(By.id("height")).getAttribute("value"));
		expectedHMap.put("weight",  driver.findElement(By.id("weight")).getAttribute("value"));
		expectedHMap.put("city",  driver.findElement(By.id("city")).getAttribute("value"));
		expectedHMap.put("state",  driver.findElement(By.id("state")).getAttribute("value"));
		expectedHMap.put("zip",  driver.findElement(By.id("zip")).getAttribute("value"));

		return expectedHMap;


	}
	/**
	 * Generate 2 or 3 digit random number
	 * @param lLimit
	 * @param uLimit
	 * @return
	 */
	public Integer readRandomDigit(int lLimit,int uLimit)
	{
		Random rand = new Random();
		Integer value = lLimit+rand.nextInt(uLimit-lLimit);
		return value;
	}
	/**
	 * Reading all the values in the Profile Page
	 * @return
	 */
	public HashMap<String,String> readProfilePageData()
	{
		HashMap<String,String> actualHMap = new HashMap<String,String>();
		String fName = driver.findElement(By.id("fname")).getAttribute("value");
		actualHMap.put("fname", fName);
		actualHMap.put("lname",  driver.findElement(By.id("lname")).getAttribute("value"));
		actualHMap.put("licn",  driver.findElement(By.id("licn")).getAttribute("value"));
		actualHMap.put("ssn",  driver.findElement(By.id("ssn")).getAttribute("value"));
		actualHMap.put("addr",  driver.findElement(By.id("addr")).getAttribute("value"));
		actualHMap.put("age",  driver.findElement(By.id("age")).getAttribute("value"));
		actualHMap.put("height",  driver.findElement(By.id("height")).getAttribute("value"));
		actualHMap.put("weight",  driver.findElement(By.id("weight")).getAttribute("value"));
		actualHMap.put("city",  driver.findElement(By.id("city")).getAttribute("value"));
		actualHMap.put("state",  driver.findElement(By.id("state")).getAttribute("value"));
		actualHMap.put("zip",  driver.findElement(By.id("zip")).getAttribute("value"));

		return actualHMap;
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
