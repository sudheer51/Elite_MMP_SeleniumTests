package org.iit.hc.patientmodule.pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.iit.hc.AppLibrary;
import org.iit.hc.TestBase;
import org.iit.hc.mmp.HelperClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistartionPatientPage extends TestBase {
	
	WebDriver driver;
	HelperClass helperObj;
	Random rand = new Random();
	HashMap<String,String> hMap = new HashMap<String,String>();
	int noOfChars = 5;
	int noOfDigitsZip = 5;
	int noOfDigitsAge = 2;
	
	public RegistartionPatientPage(WebDriver driver) {
		this.driver=driver;
		helperObj = new HelperClass(driver);
	}
	
	By registerBtn = By.xpath("//input[@value='Register'] ");
	By firstNameTB = By.id("firstname");
	By lastNameTB = By.id("lastname");
	By DOBDate = By.id("datepicker");
	By licenseTB = By.id("license");
	By SSNTB = By.id("ssn");
	By stateTB = By.id("state");
	By cityTB = By.id("city");
	By addressTB = By.id("address");
	By zipCodeTB = By.id("zipcode");
	By ageTB = By.id("age");
	By heightTB = By.id("height");
	By weightTB = By.id("weight");
	By pharmacyTB = By.id("pharmacy");
	By pharmaAddressTB = By.id("pharma_adress");
	By emailIDTB = By.id("email");
	By userNameTB = By.id("username");
	By passwordTB = By.id("password");
	By confirmPasswordTB = By.id("confirmpassword");
	By securityIDTB = By.id("security");
	By answerTB = By.id("answer");
	By registerBtn2 = By.name("register");
	
	public String readSuccessMessage(){
		Alert alrt  = driver.switchTo().alert();
		String msg = alrt.getText();
		alrt.accept();
		return msg;
	}
	 
	public void clickRegisterButton(){
		driver.findElement(registerBtn).click();
	}
	public void enterFirstName(){
		String firstNameValue = "AUTFName"+ AppLibrary.getRandomString(noOfChars);
		driver.findElement(firstNameTB).sendKeys(firstNameValue);
		hMap.put("FName", firstNameValue);
		
	}
	public void enterLastName()
	{
		String lastNameValue = "AUTLName"+AppLibrary .getRandomString(noOfChars);
		driver.findElement(lastNameTB).sendKeys(lastNameValue);
		hMap.put("LName", lastNameValue);
	}
	
	public void enterDateOfBirth()
	{
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String datePickerValue = sdf.format(d);
		driver.findElement(DOBDate).sendKeys(datePickerValue);
		hMap.put("DatePicker", datePickerValue);
	}
	public void enterLicense()
	{
		String licenseValue = AppLibrary.generateRandom(7, 1000000);
		driver.findElement(licenseTB).sendKeys(licenseValue);
		hMap.put("License", licenseValue);
		
		
	}
	public void enterSSN()
	{
		String ssnValue = Calendar.getInstance().getTimeInMillis()%1000000000+"";
		driver.findElement(SSNTB).sendKeys(ssnValue);
		hMap.put("SSN", ssnValue);
	}
	public void enterState()
	{
		
		String stateValue = AppLibrary.getRandomState();
		driver.findElement(stateTB).sendKeys(stateValue);
		hMap.put("State", stateValue);
		
	}
	public void enterCity()
	{
		String cityValue = "seattle";
		driver.findElement(cityTB).sendKeys(cityValue);
		hMap.put("City", cityValue);
	}
	public void enterAddressValue()
	{

		String addressValue = "9 Street";
		driver.findElement(addressTB).sendKeys(addressValue);
		hMap.put("Address", addressValue);
	}
	public void enterZipCodeValue()
	{

		String zipCodeValue = AppLibrary.getRandomNoOfDigits(noOfDigitsZip)+"";
		driver.findElement(zipCodeTB).sendKeys(zipCodeValue);
		hMap.put("ZipCode", zipCodeValue);
	}
	public void enterAgeValue()
	{
		String ageValue =  AppLibrary.getRandomNoOfDigits(noOfDigitsAge)+"";
		driver.findElement(ageTB).sendKeys(ageValue);
		hMap.put("Age", ageValue);
	}
	public void enterHeightValue()
	{

		String heightValue =  rand.nextInt(100)+"";
		driver.findElement(heightTB).sendKeys(heightValue);
		hMap.put("Height", heightValue);
	}
	public void enterWeightValue()
	{		
		String weightValue =  rand.nextInt(100)+"";
		driver.findElement(weightTB).sendKeys(weightValue);
		hMap.put("Weight", weightValue);
		
	}
	public void enterPharmaDetails()
	{

		String pharmacyValue =  "MMP Pharmacy";
		driver.findElement(pharmacyTB).sendKeys(pharmacyValue);
		hMap.put("Pharma", pharmacyValue);
		
		
		String pharma_adressValue = "12 Chipmunk Crossing";
		driver.findElement(pharmaAddressTB).sendKeys(pharma_adressValue);
		hMap.put("PharmaAddress", pharma_adressValue);
	}
	
	public void enterUserDetails()
	{
		String emailValue = "WalesQAMMP"+rand.nextInt(100)+"@gmail.com";
		driver.findElement(emailIDTB).sendKeys(emailValue);
		hMap.put("Email", emailValue);
		
		
		String usernameValue = "WalesQAMMP"+rand.nextInt(100);
		driver.findElement(userNameTB).sendKeys(usernameValue);
		hMap.put("Username", usernameValue);
		
	 
		String passwordValue="WalesQAMMP"+rand.nextInt(100);
		driver.findElement(passwordTB).sendKeys(passwordValue);
		hMap.put("Password", passwordValue);
		
		
		driver.findElement(confirmPasswordTB).sendKeys(passwordValue);
		hMap.put("ConfirmPassword", passwordValue);
	}
	public void enterSecurityInfo()
	{
		new Select(driver.findElement(securityIDTB)).selectByVisibleText("What is your mother maiden name");
		hMap.put("SecurityQuestion", "What is your mother maiden name");
		
		
		String answerValue = "WalesQA"+rand.nextInt(100);
		driver.findElement(answerTB).sendKeys(answerValue);
		hMap.put("SecurityAnswer", answerValue);
		
	}
	public String clickOnSaveButton() throws IOException
	{
		//driver.findElement(registerBtn2).click();
		String msg="";
		try{
			driver.findElement(registerBtn2).click();
			Alert alert = driver.switchTo().alert();
			msg = alert.getText();
			alert.accept();
		}
		catch(Exception e){
			System.out.println("Exception got: "+e.getMessage());
			msg = checkError();

		}
		return msg;

	}
	public String checkError() throws IOException{

		String msg = "";
		System.out.println("Inside the CheckError method");
		String errElement = "";
		List <WebElement> errElements = driver.findElements(By.tagName("p"));
		System.out.println("No. Of Error Elements Present "+errElements.size());
		for (WebElement webElement : errElements) {

			if(webElement.isDisplayed()){

				System.out.println(webElement.getText());
				errElement = webElement.getAttribute("id");
				System.out.println(errElement);
				String xpath = "//p[@id='"+errElement+"']/preceding-sibling::input";
				if(webElement.getText().contains("license")){
					helperObj.highLightElement(driver.findElement(By.xpath(xpath)));
					driver.findElement(By.xpath(xpath)).sendKeys("12345678");
					hMap.put("License", "12345678");
					helperObj.captureScreenshot("license");
				}
			}
		}
		try{
			helperObj.highLightElement(driver.findElement(registerBtn2));
			driver.findElement(registerBtn2).click();
			Alert alert = driver.switchTo().alert();
			msg = alert.getText();
			alert.accept();
		}
		catch(Exception e){
			System.out.println("Exception got: "+e.getMessage());

		}
		return msg;

	}
	public void fillData()
	{
		enterFirstName();
		enterLastName();
		enterDateOfBirth();
		enterLicense();
		enterSSN();
		enterState();
		enterCity();
		enterAddressValue();
		enterZipCodeValue();
		enterAgeValue();
		enterHeightValue();
		enterWeightValue();
		enterPharmaDetails();
		enterUserDetails();
		enterSecurityInfo();
			 	 
	}


}
