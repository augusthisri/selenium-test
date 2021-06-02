package com.test.verifications;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.base.BaseClass;
import com.test.pages.ContactUsPage_932394;
import com.test.pages.HdfcHomePage_932394;

public class ContactUsPageTest extends BaseClass {

	ContactUsPage_932394 contactUsPage;
	HdfcHomePage_932394 hdfcHomePage;

	public ContactUsPageTest() {
		super();
	}

	
	@Parameters({"browser", "url"})
	@BeforeMethod(groups= {"Smoke"})
	public void setup( String browserName,  String url) {
		
		
		invokeBrowser( browserName,  url);
		contactUsPage = new ContactUsPage_932394();

	}

	
	@Test(groups = { "Smoke" })
	public void contactUsPagevalidationForHeaders() throws InterruptedException {

		String DepositStatement = contactUsPage.contactUsPagevalidationForHeaders();
		DepositStatement.length();

		boolean contactUsflag = contactUsPage.iscontactUsDisplayed();
		Assert.assertTrue(contactUsflag);
		boolean writeToUsDisplayedflag = contactUsPage.isWriteToUsDisplayed();
		Assert.assertTrue(writeToUsDisplayedflag);
		boolean locateUsDisplayed = contactUsPage.isLocateUsDisplayed();
		Assert.assertTrue(locateUsDisplayed);
		boolean hdfcCorpOfficeflag = contactUsPage.ishdfcCorpOfficeDisplayed();
		Assert.assertTrue(hdfcCorpOfficeflag);
		boolean grievanceRedressalDisplayed = contactUsPage.isGrievanceRedressalDisplayed();
		Assert.assertTrue(grievanceRedressalDisplayed);
		boolean hdfcDepositCentresDisplayed = contactUsPage.ishdfcDepositCentresDisplayed();
		Assert.assertTrue(hdfcDepositCentresDisplayed);
	}

	@Test(groups = {"Regression"})
	public void depositPageValidation() throws Exception {

		contactUsPage.WriteToUsValidation(prop.getProperty("enquiryType"),prop.getProperty("subenquiryType"),prop.getProperty("customerName"), prop.getProperty("contactNumber"),
				prop.getProperty("customerEmail"), prop.getProperty("customerAddress"),
				prop.getProperty("writeEnquiry"));
	
	}

	@AfterMethod(groups= {"Smoke"})
	public void tearDown() {

		driver.quit();
	}

}
