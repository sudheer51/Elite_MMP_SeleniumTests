package org.iit.hc.patientmodule.pages;

import java.util.HashMap;

import org.iit.hc.adminmodule.pages.AdminModuleMessagespage;
import org.iit.hc.mmp.HelperClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendMessagesPage {
	
	WebDriver driver;
	HelperClass helperobj;
	String actualMsg;
	By subjectTB = By.id("subject");
	By messageTB = By.id("message");
	By sendBtn = By.xpath("//input[@value='Send']");
	By firstNameTB = By.id("fname");
	By editBtn = By.id("Ebtn");
	
	public SendMessagesPage(WebDriver driver) {
		this.driver=driver;
	    helperobj = new HelperClass(driver);
	}
	
	public void sendMessage(String subject, String message) throws InterruptedException{
		
		Thread.sleep(3000);
		driver.findElement(subjectTB).sendKeys(subject);
		driver.findElement(messageTB).sendKeys(message);
		driver.findElement(sendBtn).click();
		System.out.println("Done entering messages");
		Thread.sleep(3000);
		
	}	
	public String validateSendMessage(){
		
		System.out.println("Validating.....");
		try{
			Alert alert = driver.switchTo().alert();
			actualMsg = alert.getText();
			alert.accept();
		} catch(Exception e){
			System.out.println("Alert Not Present : "+e.getMessage());
		}
		return actualMsg;
	}
	public String retrieveFirstName(){
		
		helperobj.navigateToAModule("Profile");
		driver.findElement(editBtn).click();
		//String name = driver.findElement(firstNameTB).getText();
		String name = driver.findElement(firstNameTB).getAttribute("value");
		System.out.println(name);
		return name;
		
	}
	public boolean validateMessageFromAdminModule(String uName, String password,
			String urlAdminLogin, String name, String subject, String message){
		
		boolean result = false;
		helperobj.launchApplication(urlAdminLogin);
		helperobj.login(uName, password);
		helperobj.navigateToAModule("Messages");
		AdminModuleMessagespage adminObj = new AdminModuleMessagespage(driver);
        
		HashMap <String, String> hMap = adminObj.retrieveRecentMessageDetails();
		if(hMap.get("Subject").equals(subject) && hMap.get("Description").equals(message) && hMap.get("Name").equals(name)){
			result = true;
			System.out.println("Passed");
		}
		System.out.println(hMap.get("Name")+" hMap******name "+ name);
		System.out.println(hMap.get("Subject")+" hMap******subject "+subject);
		System.out.println(hMap.get("Description")+" hMap********message "+message);
		return result;
	}
	

}
