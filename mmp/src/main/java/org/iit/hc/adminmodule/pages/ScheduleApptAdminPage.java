package org.iit.hc.adminmodule.pages;

import java.util.HashMap;

import org.iit.hc.AppLibrary;
import org.iit.hc.mmp.HelperClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ScheduleApptAdminPage {
	
	WebDriver driver;
	HelperClass helperobj;
	
	By datepicker=By.xpath("//input[@id='datepicker']");
	By appoitmentTime=By.id("time");
	By continueB=By.id("ChangeHeatName");
	By sForm=By.name("sym");
	By sySumbit=By.xpath("//input[@value='Submit']");
	By anyPlace = By.xpath("//body");
	
	public ScheduleApptAdminPage(WebDriver driver) {
		this.driver=driver;
		helperobj=new HelperClass(driver);
		
	}
	public HashMap<String, String> scheduleAppointment(String doctorName) throws InterruptedException
	{
		HashMap<String,String> hMap= new HashMap<String,String>();
		driver.findElement(By.xpath("//h4[contains(text(),'"+doctorName+"')]/ancestor::td/button[@id='opener']")).click();
		driver = helperobj.switchToAFrameAvailable("myframe",20);
		String dateOfAppointment = AppLibrary.selectDate(10,"MM/dd/YYYY");
		driver.findElement(datepicker).sendKeys(dateOfAppointment);
		String time = "10Am";
		new Select(driver.findElement(appoitmentTime)).selectByVisibleText(time);
		driver.findElement(anyPlace).click();
	
		driver.findElement(continueB).click();
		String symptoms= "Booking an Appointment "+doctorName +"on date::"+dateOfAppointment+ "for symptom fever";
		Thread.sleep(2000);
		driver.findElement(sForm).clear();
		driver.findElement(sForm).sendKeys(symptoms);
		hMap.put("doctorName", doctorName);
		hMap.put("dateOfAppointment", dateOfAppointment);
		hMap.put("time", time);
		hMap.put("symptoms", symptoms);
		driver.findElement(sySumbit).click();

		return hMap;
	}


}
