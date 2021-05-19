package com.test.verifications;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.base.BaseClass;
import com.test.pages.HdfcHomePage_932394;

public class HdfcHomePageTest extends BaseClass {

	HdfcHomePage_932394 hdfcHomePage;

	public HdfcHomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		invokeBrowser();
		hdfcHomePage = new HdfcHomePage_932394();
	}

	@Test(priority = 2)
	public void hdfcLogoTest() {
		boolean flag = hdfcHomePage.validateHDFCLogo();
		Assert.assertTrue(flag);
	}

	@Test(priority = 1)
	public void hdfcLoanProducts() throws InterruptedException {

		hdfcHomePage.clickOnLoanHomeProduct();
		boolean housingLoanflag = hdfcHomePage.validatehdfcLoanProductHousingLoan();
		Assert.assertTrue(housingLoanflag);
		boolean nonHousingLoanflag = hdfcHomePage.validatehdfcLoanProductnonHousingLoan();
		Assert.assertTrue(nonHousingLoanflag);
		boolean otherHomeLoagLoanflag = hdfcHomePage.validatehdfcLoanProductotherHomeLoan();
		Assert.assertTrue(otherHomeLoagLoanflag);
	}

	@Test(priority = 3)
	public void hdfcDepositStatementValidation() throws InterruptedException {

		String DepositStatement = hdfcHomePage.validatehdfcDepositStatement();
		Assert.assertEquals(DepositStatement, "Attractive returns and safety, in one Investment");
	}

	@Test(priority = 4)
	public void applyOnline() throws InterruptedException {

		boolean applyOnlineflag = hdfcHomePage.validateApplyOnlineIsDiplayed();
		Assert.assertTrue(applyOnlineflag);

	}

	@AfterMethod
	public void tearDown() {

		driver.close();
	}

}
