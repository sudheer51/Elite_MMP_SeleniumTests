package org.iit.hc.patientmodule.pages;


import java.util.HashMap;

import org.iit.hc.AppLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ScheduleAppointmentPage {

	WebDriver driver;
	public ScheduleAppointmentPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public boolean scheduleAppointment(String doctorName,int days,String time,String sym)
	{
		 
	 	
		HashMap<String,String> expectedHMap = new HashMap<String,String>();
		
		expectedHMap.put("Doctor",doctorName);
		
		driver.findElement(By.cssSelector("input[value='Create new appointment']")).click();
		driver.findElement(By.xpath("//h4[contains(text(),'Dr."+doctorName+"')]/ancestor::ul/following-sibling::button")).click();
		driver.switchTo().frame("myframe");
		
	
		String output = AppLibrary.selectDate(-10,"MM/dd/YYYY");
		expectedHMap.put("Date",output);
		
		driver.findElement(By.id("datepicker")).sendKeys(output);
		Actions action  =new Actions(driver);
		action.moveToElement(driver.findElement(By.id("time"))) ;
		action.perform();
		
		Select select = new Select(driver.findElement(By.id("time")));
		select.selectByVisibleText(time);
		expectedHMap.put("Time",time);
		
		JavascriptExecutor jse =(JavascriptExecutor) driver;
		WebElement e = (WebElement) jse.executeScript("return document.getElementById('ChangeHeatName')");
		e.click();
		expectedHMap.put("Appointment",sym);
		
		try{
			
			driver.findElement(By.id("sym")).sendKeys(sym);
		}
		catch(Exception ex)
		{
			 jse =(JavascriptExecutor) driver;
			 e = (WebElement) jse.executeScript("return document.getElementById('ChangeHeatName')");
			 e.click();
			 driver.findElement(By.id("sym")).sendKeys(sym);
		}
		driver.findElement(By.cssSelector("input[value='Submit']")).click();
	 
		HashMap <String,String> actualHMap = new HashMap<String,String>();
		actualHMap.put("Date", driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[1]")).getText());
		actualHMap.put("Time", driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[2]")).getText());
		actualHMap.put("Appointment", driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[3]")).getText());
		actualHMap.put("Doctor", driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[4]")).getText());
		
		return actualHMap.equals(expectedHMap);
	}

}
