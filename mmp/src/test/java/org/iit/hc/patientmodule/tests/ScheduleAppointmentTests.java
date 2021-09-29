package org.iit.hc.patientmodule.tests;

import org.iit.hc.TestBase;
import org.iit.hc.mmp.HelperClass;
import org.iit.hc.patientmodule.pages.ScheduleAppointmentPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScheduleAppointmentTests extends TestBase{
	
	
	@Test(description="US_004 Schedule Appointment",groups={"US_004","regression","sanity","patientmodule"})
	public void validateScheduleAppointment()
	{
		String uname = pro.getProperty("PName");
		String pword = pro.getProperty("Password");
		HelperClass helperObj = new HelperClass(driver);
		helperObj.launchApplication(pro.getProperty("patientportalurl"));
		helperObj.login(uname,pword);
		helperObj.navigateToAModule("Schedule Appointment");
		ScheduleAppointmentPage sPage = new ScheduleAppointmentPage(driver);
		boolean result = sPage.scheduleAppointment("Beth",4,"11Am","Flu");
		Assert.assertTrue(result);
 
	}
	 
	 
	 
}
