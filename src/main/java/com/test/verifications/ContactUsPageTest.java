package com.test.verifications;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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

	@BeforeMethod
	public void setup() {

		invokeBrowser();
		contactUsPage = new ContactUsPage_932394();

	}

	@Test(priority = 1)
	public void contactUsPagevalidationForHeaders() throws InterruptedException {

		String DepositStatement = contactUsPage.contactUsPagevalidationForHeaders();
		DepositStatement.length();
		logger.info("pagename in contactUsPagevalidationForHeaders:" + DepositStatement);

	}

	@Test(priority = 2)
	public void depositPageValidation() throws Exception {

		contactUsPage.WriteToUsValidation(prop.getProperty("customerName"), prop.getProperty("contactNumber"),
				prop.getProperty("customerEmail"), prop.getProperty("customerAddress"),
				prop.getProperty("writeEnquiry"));

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
