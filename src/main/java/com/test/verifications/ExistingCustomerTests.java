package com.test.verifications;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.base.BaseClass;
import com.test.config.TestUtil;
import com.test.pages.ExsistingCustomerPage_932394;

public class ExistingCustomerTests extends BaseClass {

	ExsistingCustomerPage_932394 exsistingCustomerPage;
	TestUtil testUtil;
	String sheetName = "HDFCCustomerLoginTest";

	public ExistingCustomerTests() {
		super();

	}

	@BeforeMethod
	public void setup() {

		invokeBrowser();
		exsistingCustomerPage = new ExsistingCustomerPage_932394();
		testUtil = new TestUtil();

	}

	@DataProvider
	public Object[][] getHDFCTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 1, dataProvider = "getHDFCTestData")
	public void createLoginTests(String UserNameInput, String userPasswordInput)
			throws InterruptedException, IOException {

		exsistingCustomerPage.createLogin(UserNameInput, userPasswordInput);
		
		// Issue facing or captcha
		// unable to retrieve the errormessage in text
		// Planning to implement takescreenshot for the failures.
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
