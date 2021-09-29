package org.iit.hc.patientmodule.tests;

import org.iit.hc.TestBase;
import org.iit.hc.mmp.HelperClass;
import org.iit.hc.patientmodule.pages.EditProfilePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class EditProfileTests extends TestBase{
	
	EditProfilePage EPPageobj;
	HelperClass helperobj;
	String Act = "Your Profile has been updated.";

    @Test(description="US_003 UpdateProfile", groups={"US_003","regression","sanity","patientmodule"})
	public void PatientProfilePage() throws Exception {
		helperobj = new HelperClass(driver);
		EPPageobj = new EditProfilePage(driver);
		helperobj.launchApplication(pro.getProperty("patientportalurl"));
		helperobj.login(pro.getProperty("PName"),pro.getProperty("Password"));
		helperobj.navigateToAModule("Profile");
		EPPageobj.clickEditButton();
		EPPageobj.editAllFields();
		String Exp = EPPageobj.clickOnSaveButton();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(Act, Exp);
		boolean Resultall = EPPageobj.validateUpdating();
		sa.assertTrue(Resultall);
		String Uname=pro.getProperty("PName");
		String Pword = pro.getProperty("Password");
		String URL = pro.getProperty("patientportalurl");
		sa.assertTrue(EPPageobj.validateAfterLogout(Uname,Pword,URL));
		EPPageobj.clickEditButton();
		EPPageobj.editRandomFields();
	    boolean  resultSelected = EPPageobj.validateUpdating();
		sa.assertTrue(resultSelected);
		sa.assertAll();
		helperobj.navigateToAModule("Logout");
		
	}
	
}