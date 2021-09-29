package org.iit.hc.patientmodule.tests;

import org.iit.hc.TestBase;
import org.iit.hc.mmp.HelperClass;
import org.iit.hc.patientmodule.pages.ViewReportspage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ViewReportsTests extends TestBase {
	
	HelperClass helperObj;
	ViewReportspage VRPage;
	
	String patientUserName, patientPassword, URL;
	
	@Test(description="US_007 Creation of Report",groups={"US_007","regression","sanity","patientmodule"})
	public void patientView() throws Exception {
		helperObj = new HelperClass(driver);
		URL = pro.getProperty("patientportalurl");
		patientUserName = pro.getProperty("PName");
		patientPassword = pro.getProperty("Password");
		helperObj.launchApplication(URL);
		helperObj.login(patientUserName, patientPassword);
		helperObj.navigateToAModule("Profile");
		VRPage = new ViewReportspage(driver);
		Boolean res = VRPage.viewReports();
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(res,"Passed");
		
	}

}
