package org.iit.hc.mmp;

import org.openqa.selenium.By;
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

}
