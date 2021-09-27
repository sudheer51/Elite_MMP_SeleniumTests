package org.iit.hc.patientmodule.tests;

import org.iit.hc.TestBase;
import org.iit.hc.mmp.HelperClass;
import org.iit.hc.patientmodule.pages.ViewInformationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ViewInformationTests  extends TestBase{
	
	HelperClass helperObj;
	ViewInformationPage VIPageObj;
	String URL;
	String uName;
	String pWord;
	
	@Test
	public void validateInformationMsg() {
		
		helperObj = new HelperClass(driver);
		URL = pro.getProperty("patientportalurl");
		uName = pro.getProperty("PName");
		pWord = pro.getProperty("Password");
		helperObj.launchApplication(URL);
		helperObj.login(uName, pWord);
		helperObj.navigateToAModule("Information");
		VIPageObj = new ViewInformationPage(driver);
		boolean result = VIPageObj.validateInformation();
		Assert.assertTrue(result);
		helperObj.navigateToAModule("Logout");
	}
	

}
