package org.iit.hc.adminmodule.tests;

import org.iit.hc.TestBase;
import org.iit.hc.adminmodule.pages.ClaimCenterPage;
import org.iit.hc.mmp.HelperClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClaimTests extends TestBase{
	

	@Test
	public void validateClaimSubmission() throws InterruptedException
	{
		String uname = pro.getProperty("adminUser");
		String pword = pro.getProperty("adminPassword");
		HelperClass helperObj = new HelperClass(driver);
		helperObj.launchApplication(pro.getProperty("adminportalurl"));
		helperObj.login(uname,pword);
		helperObj.navigateToAModule("Claim Center");
		helperObj.patientSearchBySSN(pro.getProperty("patientSSN"));
		ClaimCenterPage claimPage = new ClaimCenterPage(driver);
		claimPage.submitclaim();
		Assert.assertTrue(claimPage.validateClaimMessage("Inserted"));
		
	
	}

}
