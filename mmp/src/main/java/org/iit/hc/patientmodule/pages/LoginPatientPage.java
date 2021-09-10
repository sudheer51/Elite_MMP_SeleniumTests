package org.iit.hc.patientmodule.pages;

import org.iit.hc.TestBase;
import org.iit.hc.mmp.HelperClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPatientPage extends TestBase {
	
	HelperClass helperobj;
    WebDriver driver;
    
    public LoginPatientPage(WebDriver driver) {
    	this.driver=driver;    	
    }
    
 
  		
  	
  	public void getPatientLoginpage(){
  		
  		//driver.findElement(By.xpath("//a[normalize-space()='Patient Login']")).click();
  		driver.findElement(By.xpath("//a[@class='button button-alt'][normalize-space()='Login']")).click();
  	}
  	
  		
}
