package org.iit.hc.patientmodule.tests;

import org.iit.hc.TestBase;
import org.iit.hc.mmp.HelperClass;
import org.iit.hc.patientmodule.pages.LoginPatientPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class LoginPatientTest extends TestBase{
	
	HelperClass helperObj;
	LoginPatientPage Loginpageobj;
	String URL;
	
	
	@Test(description="US_002_LoginTests",groups={"US_002","regression","sanity","patientmodule"})
	public void loginTests() throws Exception {
		helperObj=new HelperClass(driver);
		URL=pro.getProperty("homepageurl");
		System.out.println(URL);
		helperObj.launchApplication(URL);
		Loginpageobj = new LoginPatientPage(driver);
		Loginpageobj.getPatientLoginpage();
		Thread.sleep(3000);
		helperObj.login(pro.getProperty("patientName"), pro.getProperty("patientPassword"));
		
	}
	

}
