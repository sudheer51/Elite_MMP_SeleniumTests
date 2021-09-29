package org.iit.hc.adminmodule.tests;

import java.util.HashMap;

import org.iit.hc.TestBase;
import org.iit.hc.adminmodule.pages.AdminModuleMessagespage;
import org.iit.hc.mmp.HelperClass;
import org.testng.annotations.Test;

public class AdminmodulemessagesTests extends TestBase {
	
	HelperClass helperobj;
	AdminModuleMessagespage AMPage;
	HashMap<String,String> hMap;
	String name;
	String subject;
	String description;
	
	@Test
	public void MessagesTest() {
		helperobj = new HelperClass(driver);
		helperobj.launchApplication(pro.getProperty("adminportalurl"));
		helperobj.login(pro.getProperty("adminUser"), pro.getProperty("adminPassword"));
		helperobj.navigateToAModule("Messages");
		AMPage = new AdminModuleMessagespage(driver);
		hMap = new HashMap<String,String>();
		hMap=AMPage.retrieveRecentMessageDetails();
		AMPage.validateMessageFromAdminModule(hMap, name, subject, description);
		
	}

}
