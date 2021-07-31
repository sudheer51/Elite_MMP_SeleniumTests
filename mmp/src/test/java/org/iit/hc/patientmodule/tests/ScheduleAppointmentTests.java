package org.iit.hc.patientmodule.tests;

import org.iit.hc.TestBase;
import org.iit.hc.mmp.HelperClass;
import org.iit.hc.patientmodule.pages.ScheduleAppointmentPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScheduleAppointmentTests extends TestBase{
	
	
	@Test
	public void validateScheduleAppointment()
	{
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		driver.manage().window().maximize();
		String uname = pro.getProperty("patientUsername");
		String pword = pro.getProperty("patientPassword");
		HelperClass helperObj = new HelperClass(driver);
		helperObj.login(uname,pword);
		helperObj.navigateToAModule("Schedule Appointment");
		ScheduleAppointmentPage sPage = new ScheduleAppointmentPage(driver);
		boolean result = sPage.scheduleAppointment("Becky",10,"10Am","Cold & Fever");
		Assert.assertTrue(result);
 
	}
	 
	 
	 
}
