package org.iit.hc.patientmodule.tests;

import org.iit.hc.TestBase;
import org.iit.hc.patientmodule.pages.RegistartionPatientPage;
import org.iit.hc.mmp.HelperClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistartionTests  extends TestBase{
	
	HelperClass helperobj;
	String URL;
	RegistartionPatientPage RpPage;
	
	@Test(description="US_001 Registration of the Page",
			groups={"US_001","regression","sanity","patientmodule"})
	public void validateRegistration() throws Exception
	{  
		
	    helperobj = new HelperClass(driver);
		URL = pro.getProperty("patientportalurl");
		helperobj.launchApplication(URL);
		RpPage = new RegistartionPatientPage(driver);
		RpPage.clickRegisterButton();
		RpPage.fillData();
		String actual = RpPage.clickOnSaveButton();
		String expected ="Thank you for registering with MMP. ";
		Assert.assertEquals(actual, expected);
		
	}
	

}
