package org.iit.hc.adminmodule.tests;

import org.iit.hc.TestBase;
import org.iit.hc.adminmodule.pages.CreateReportAdminPage;
import org.iit.hc.mmp.HelperClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateReportAdminModuleTests extends TestBase {
	
	HelperClass helperObj;
	CreateReportAdminPage CRPage;
	String adminUser;
	String adminPassword;
	String urlAdmin;
	String searchPatient;
	String searchPatientSSN;
	String reptName = "XRAY-Stomach report-2";
	String reptDesc = "This is the 2nd XRAY of Stomach ulcer";
	String uploadFilepath;
	
	@Test(description="US_007 Creation of Report",groups={"US_007","regression","sanity","adminmodule"})
	public void createReport() throws Exception   {
		helperObj = new HelperClass(driver);
		adminUser = pro.getProperty("adminUser");
		adminPassword = pro.getProperty("adminPassword");
		urlAdmin = pro.getProperty("adminportalurl");
		searchPatient = pro.getProperty("pname");
		searchPatientSSN = pro.getProperty("patSSN");
		uploadFilepath = System.getProperty("user.dir")+ "\\Data\\lung-article-703x441.jpg" ;
		helperObj.launchApplication(urlAdmin);
		helperObj.login(adminUser, adminPassword);
		helperObj.navigateToAModule("Patients");
		CRPage = new CreateReportAdminPage(driver);
		CRPage.patientSearchName(searchPatient);
		CRPage.searchRecord(searchPatient, searchPatientSSN);
		CRPage.patientDetails(searchPatientSSN);
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(CRPage.reportDetails(reptName,reptDesc,uploadFilepath), null);
		sa.assertAll();
		
	}

}
