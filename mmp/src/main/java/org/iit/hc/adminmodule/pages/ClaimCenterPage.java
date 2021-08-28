package org.iit.hc.adminmodule.pages;

import java.util.List;
import java.util.Random;

import org.iit.hc.AppLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClaimCenterPage {

	WebDriver driver;
	public ClaimCenterPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void submitclaim() {


		Actions action = new Actions(driver);
		
		action.click(driver.findElement(By.xpath(" //input[@name='mname']")))
			  .sendKeys("ria")
			  .build()
			  .perform(); 


		action.click(driver.findElement(By.xpath( "//input[@value='m']"))).build().perform();
		driver.findElement(By.xpath("//input[@value='empl']")).click();
		
		action.click(driver.findElement(By.xpath("//input[@name='insuranceno']")))
		.sendKeys("4356278").build().perform();

		new Select(driver.findElement(By.name("docname"))).selectByVisibleText("Becky");
	 

		String output = AppLibrary.selectDate(-15, "MM/dd/YYYY");
		driver.findElement(By.xpath("//input[@name='dos']")).sendKeys(output);

		action.click(driver.findElement(By.xpath("//input[@name='pos']")))
		.sendKeys("Newyork").build().perform();

		new Select(driver.findElement(By.id("mcode"))).selectByValue("1");

		action.click(driver.findElement(By.name("npi")))
		.sendKeys("500").build().perform();

		
		new Select(driver.findElement(By.id("dia"))).selectByValue("4");
		 

		  
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath("//select[@id='proc']/option[.='Select Procedure  Code']"), "Select Procedure Code"));
	 							 
		Select cptcode = new Select(driver.findElement(By.id("proc")));
		Random rnd = new Random();
		List<WebElement> cptList =  cptcode.getOptions();
		cptcode.selectByIndex(1+rnd.nextInt(cptList.size()-1));

		action.click( driver.findElement(By.xpath("//input[@id='bal']")))
		.sendKeys("750.00").build().perform();
		
		Select insName= new Select(driver.findElement(By.xpath("//select[@id='insname']")));
		List<WebElement> insNameList =  insName.getOptions();
		insName.selectByIndex(1+rnd.nextInt(insNameList.size()-1));
		 

		driver.findElement(By.xpath("//input[@type='checkbox']")).click();   
		
		driver.findElement(By.xpath("//input[@value='Submit Claim']")).submit();    


	}
	public boolean validateClaimMessage(String claimMessage) throws InterruptedException
	{
		Thread.sleep(10000);
		String actual = driver.findElement(By.xpath("//div[@class='panel panel-cascade']")).getText();
		System.out.println("Claim Message" + actual);
		boolean result = actual.contains(claimMessage);
		return result;
	}
}


