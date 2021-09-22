package org.iit.hc.patientmodule.tests;

import java.util.HashMap;

import org.iit.hc.AppLibrary;
import org.iit.hc.TestBase;
import org.iit.hc.adminmodule.pages.CreateFeeAdminPage;
import org.iit.hc.adminmodule.pages.ScheduleApptAdminPage;
import org.iit.hc.mmp.HelperClass;
import org.iit.hc.patientmodule.pages.PayFeesPage;
import org.iit.hc.patientmodule.pages.ScheduleAppointmentPage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PayFeesTests extends TestBase{
	
	HelperClass helperobj ;
	AppLibrary AppLObj;
	PayFeesPage PFPage;
	CreateFeeAdminPage CFPage;
	ScheduleApptAdminPage SAPage;
	ScheduleAppointmentPage SAP;
	
	HashMap <String, String> hMap;
	SoftAssert sa;
	
	String urlAdmin, adminUser, adminPassword, patientName, SSN, doctorName, URL, patientUser, patientPassword;
	String date, serviceName;
	
	String resultExpected = "Fee Successfully Entered.";
	
	
	@Test(description="US_006 Pay Fees Page", groups= {"US-006","regression","sanity","patientmodule"})
	public void validatePayFeesTests() throws Exception
	{
		
		helperobj=new HelperClass(driver);
		SAP = new ScheduleAppointmentPage(driver);
		sa = new SoftAssert();
		urlAdmin = pro.getProperty("adminportalurl");
		adminUser = pro.getProperty("adminUser");
		adminPassword = pro.getProperty("adminPassword");
		patientName = pro.getProperty("patientName");
		doctorName = pro.getProperty("doctorName");
		SSN = pro.getProperty("patientSSN");
		date = pro.getProperty("date");
		serviceName = pro.getProperty("serviceName");
		URL = pro.getProperty("patientportalurl");
		patientUser = pro.getProperty("patientUsername");
		patientPassword = pro.getProperty("patientPassword");
		
		helperobj.launchApplication(urlAdmin);
		helperobj.login(adminUser, adminPassword);
        
        
       //create fee
		helperobj.navigateToAModule("Patients");
		helperobj.searchPatient(patientName, SSN);
        Thread.sleep(3000);
        helperobj.navigateToPatientServices("Create Fee");
        CFPage= new CreateFeeAdminPage(driver);
        String fee = CFPage.createFees(date,serviceName);
        System.out.println(fee);
        String resultActual = CFPage.readSuccessMessage();
        sa.assertEquals(resultActual, resultExpected);
        
		//Login to patient portal and pay fee
        helperobj.launchApplication(URL);
        helperobj.login(patientUser, patientPassword);
        helperobj.navigateToAModule("Fees");
        Thread.sleep(3000);
        PFPage=new PayFeesPage(driver);
        
        System.out.println("fee is: "+fee);
        PFPage.payFee(fee);
        helperobj.navigateToAModule("Logout");
        
	}

	

}
