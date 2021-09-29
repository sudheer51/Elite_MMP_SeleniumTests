package org.iit.hc.patientmodule.tests;

import org.iit.hc.TestBase;
import org.iit.hc.mmp.HelperClass;
import org.iit.hc.patientmodule.pages.ViewHistoryPage;

import org.testng.annotations.Test;

public class ViewHistoryTests extends TestBase {

	HelperClass helperObj;
	ViewHistoryPage VHPageobj;
	//String URL = "http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php";
		
	@Test(description="US_008 View History",groups={"US_008","regression","sanity","patientmodule"})
	public void Viewhistory() {
		String URL = pro.getProperty("patientportalurl");
		helperObj = new HelperClass(driver);		
		helperObj.launchApplication(URL);
		String uname = pro.getProperty("PName");
		String pword = pro.getProperty("Password");
		helperObj.login(uname, pword);
		helperObj.navigateToAModule("Profile");
		VHPageobj = new ViewHistoryPage(driver);
		VHPageobj.clickOnViewHistoryButton();
		VHPageobj.panelHistory();
		
		
	}

}
