package org.iit.hc.patientmodule.tests;

import java.util.HashMap;

import org.iit.hc.TestBase;
import org.iit.hc.adminmodule.pages.CreateReportAdminPage;
import org.iit.hc.mmp.HelperClass;
import org.iit.hc.patientmodule.pages.ViewReportspage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ViewReportsEndToEndTests extends TestBase {
	HelperClass helperobj;
	
	@Test(description="US_006 Creation of Report",groups={"US_006","regression","End to End"})
    public void ValidateReport() throws Exception{
		
		String reptName = "XRAY-Stomach report";
		String reptDesc = "This is XRAY of Stomach ulcer";
		String uploadFilepath = System.getProperty("user.dir")+ "\\Data\\lung-article-703x441.jpg" ;
		helperobj = new HelperClass(driver);
		String URL = pro.getProperty("adminportalurl");
		String Uname = pro.getProperty("adminUser");
		String pword = pro.getProperty("adminPassword");
		String patname = pro.getProperty("pname");
		String patssn = pro.getProperty("patSSN");
		helperobj.launchApplication(URL);
		helperobj.login(Uname, pword);
		helperobj.navigateToAModule("Patients");
		CreateReportAdminPage CrAdminPage = new CreateReportAdminPage(driver);
		CrAdminPage.patientSearchName(patname);
		CrAdminPage.searchRecord(patname, patssn);
		CrAdminPage.patientDetails(patssn);
		
		HashMap<String, String> hMap = CrAdminPage.reportDetail(reptName,
				                        reptDesc,uploadFilepath);
		
		//Log in to Patient portal to validate the data entered from Admin portal
		
		helperobj.launchApplication(pro.getProperty("patientportalurl"));
		helperobj.login(pro.getProperty("PName"), pro.getProperty("Password"));
		helperobj.navigateToAModule("Profile");
		ViewReportspage VRPageObj = new ViewReportspage(driver);
		boolean res = VRPageObj.validatePatientReports(hMap);
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(res,"Passed");
		
     }

}
