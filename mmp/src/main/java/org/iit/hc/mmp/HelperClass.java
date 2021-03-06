package org.iit.hc.mmp;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperClass {
	By searchNameAndSSN = By.name("search");
	By search = By.xpath("//input[@type='button']");
	By patientName = By.xpath("//div[@id='show']//table//tbody//tr//td[1]/a");
	WebDriver driver ;
	
	public HelperClass(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void login(String uname,String pword)
	{
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pword);
		driver.findElement(By.cssSelector("input[value='Sign In']")).click();
	}
	public void navigateToAModule(String tabName)
	{
		driver.findElement(By.xpath("//span[contains(normalize-space(),'"+tabName+"')]")).click();
		
	}
	public void launchApplication(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
	}
	public void patientSearchBySSN(String ssn)
	{
		driver.findElement(searchNameAndSSN).sendKeys(ssn);
		driver.findElement(search).click();
	    WebElement e =visibilityofElementLocated(patientName, 30);
		e.click();
	}
	public WebElement visibilityofElementLocated(By locator,int timeinSecs)
	{
		WebDriverWait wait = new WebDriverWait(driver,timeinSecs);
		WebElement e= wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return e;
	}
	public void highLightElement(WebElement ele){
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:2px solid red;');", ele);
	}
	
	public void captureScreenshot(String tc_Name) throws IOException
	{
		System.out.println("Inside Capturing Screenshot method");
		TakesScreenshot tsh = (TakesScreenshot)driver;
		File sourceFile = tsh.getScreenshotAs(OutputType.FILE);
		System.out.println(sourceFile.getAbsolutePath());
		String destinationPath = System.getProperty("user.dir")+"\\screenshots\\"+tc_Name+"_"+
				Calendar.getInstance().getTimeInMillis()%1000000000+".jpg";
		File destFile = new File(destinationPath); 
		FileUtils.copyFile(sourceFile,destFile);
		System.out.println(destinationPath);
		System.out.println("Exiting Screenshot");
		
	}
	public void switchToSideBar(){
		driver.findElement(By.xpath("//div[@class='left-sidebar']")).click();
	}
	public void navigateToPatientServices(String serviceName){
		WebElement we = driver.findElement(By.xpath("//input[@value='"+serviceName+"']"));
		scrollIntoViewOfWebElement(we);
		we.click();
		System.out.println("Clicking the given ServiceName "+serviceName);
	}
	public void scrollIntoViewOfWebElement(WebElement we){
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);",we);
		System.out.println("Scrolling down to the exact location" );
	}
	public WebDriver switchToAFrameAvailable(String frameId,int timeinSecs)
	{
		WebDriverWait wait = new WebDriverWait(driver,timeinSecs);
		driver = wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
		return driver;
	}
	public void searchPatient(String pName, String SSN) throws InterruptedException {

		driver.findElement(	By.id("search")).sendKeys(pName);
		driver.findElement(By.xpath("//input[@value='search']")).click();
		System.out.println(pName);
		System.out.println(SSN);
		Thread.sleep(3000);
		List<WebElement> pLis = driver.findElements(By.xpath("//div[@id='show']/descendant::table/tbody/tr/td/a"));
		for(int i=1;i<=pLis.size();i++){ 
			
			String s1 = driver.findElement(By.xpath("//div[@id='show']/descendant::table/tbody/tr["+i+"]/td[2]")).getText();
		    String name = (pLis.get(i-1).getText()).trim();
		    String s2 = s1.trim();
		    System.out.println(name);
		    System.out.println(s2);
			if((name.equals(pName)) && (s2.equals(SSN))){
				System.out.println("Inside if condition");
				System.out.println(pLis.get(i-1).getText());
				System.out.println(s1);
				pLis.get(i-1).click();
				break;
			}
		}	
	}

}
