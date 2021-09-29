package org.iit.hc.patientmodule.tests;

import java.io.IOException;

import org.iit.hc.AppLibrary;
import org.iit.hc.TestBase;
import org.iit.hc.mmp.HelperClass;
import org.iit.hc.patientmodule.pages.SearchSymptomsPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SearchSymptomsTests extends TestBase{
	
	HelperClass helperObj;
	SearchSymptomsPage searchpageObj;
	SoftAssert sa=new SoftAssert();
	boolean result;
	
	@Test(dataProvider="DP_Symptoms",description="Search Symptoms",groups= {"US_010","regression","sanity","patientmodule"} )
	public void SearchSymptomsvalidation(String DP_Symptoms) throws Exception {
		helperObj = new HelperClass(driver);
		String URL= pro.getProperty("patientportalurl");
		helperObj.launchApplication(URL);
		String uName = pro.getProperty("PName");
		String pWord = pro.getProperty("Password");
		helperObj.login(uName, pWord);
		helperObj.navigateToAModule("Search Symptoms");
		searchpageObj = new SearchSymptomsPage(driver);
		result = searchpageObj.validateSymptoms(DP_Symptoms);
		sa.assertTrue(result);
	}
	@DataProvider(name="DP_Symptoms")
	public String[][] excelData() throws  IOException {
		
		String filepath=System.getProperty("user.dir")+"\\Data\\Symptoms.xls";
		AppLibrary excelXlsObj = new AppLibrary();
		String[][] symptomData=excelXlsObj.readXlsFile(filepath,"Symptoms");
		return symptomData;
	}
	

}
