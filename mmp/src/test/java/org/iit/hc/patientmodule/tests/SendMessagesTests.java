package org.iit.hc.patientmodule.tests;

import org.iit.hc.TestBase;
import org.iit.hc.mmp.HelperClass;
import org.iit.hc.patientmodule.pages.SendMessagesPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SendMessagesTests extends TestBase {
	
	HelperClass helperobj;
	SendMessagesPage SMPage;
	String URL;
	String urlAdmin;
	String name;
	String subject = "Symptoms";
	String message = "Please verify the symptoms";
	String actualMsg;
	String expectedMsg = "Messages Successfully sent.";
	String adminUName;
	String adminPassword;
	
	@Test
	public void sendMessage() throws Exception {
		helperobj = new HelperClass(driver);
		URL= pro.getProperty("patientportalurl");
		urlAdmin=pro.getProperty("adminportalurl");
		adminUName = pro.getProperty("adminUser");
		adminPassword = pro.getProperty("adminPassword");
		String uname = pro.getProperty("PName");
		String pword = pro.getProperty("Password");
		helperobj.launchApplication(URL);
		helperobj.login(uname, pword);
		SMPage = new SendMessagesPage(driver);
		name = SMPage.retrieveFirstName();
		helperobj.switchToSideBar();
		helperobj.navigateToAModule("Messages");
		
		SMPage.sendMessage(subject, message);
		actualMsg = SMPage.validateSendMessage();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualMsg, expectedMsg);
		helperobj.navigateToAModule("Logout");
		
		boolean result = SMPage.validateMessageFromAdminModule(adminUName,
				          adminPassword, urlAdmin, name, subject, message);
		sa.assertTrue(result);
		sa.assertAll();
		

	}

}
