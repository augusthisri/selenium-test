package com.test.pages;

import java.io.File;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.test.base.BaseClass;
import com.test.config.TestUtil;

public class ContactUsPage_932394 extends BaseClass {

	BaseClass baseClass;

	@FindBy(xpath = "//*[contains(@id,'HomepageModalVideo')]/div/div/div[1]/button[1]")
	public WebElement closeButton;

	@FindBy(xpath = "(//*[contains(@title,'Contact Us')])[2]")
	public WebElement contactUs;

	@FindBy(xpath = "(//*[contains(@title,'Write to us')])[2]")
	public WebElement writeToUs;
	@FindBy(xpath = "(//*[contains(@title,'Helpline Numbers')])[2]")
	public WebElement helpLineNumbers;

	@FindBy(xpath = "(//*[contains(@title,'Locate us')])[2]")
	public WebElement locateUs;

	@FindBy(xpath = "(//*[contains(@title,'Grievance Redressal')])[2]")
	public WebElement grievanceRedressal;

	@FindBy(xpath = "(//*[contains(@title,'HDFC Corporate Office')])[2]")
	public WebElement hdfcCorpOffice;

	@FindBy(xpath = "(//*[contains(@title,'HDFC Deposit Centers')])[2]")
	public WebElement hdfcDepositCentres;

	@FindBy(xpath = "//*[@id='edit-product-type']/div[1]/label")
	public WebElement homeLoanSelect;

	@FindBy(xpath = "//input[@id='edit-customer-type-query'and@type='radio']")
	public WebElement newCustomerselect;

	@FindBy(xpath = "//input[@id='edit-cust-occupation-salaried']")
	public WebElement typeOfIncome;

	@FindBy(xpath = "//*[contains(@name,'customername')]")
	public WebElement customerName;

	@FindBy(xpath = "//*[contains(@name,'contactno')]")
	public WebElement customerContactNumber;

	@FindBy(xpath = "//*[contains(@name,'emailid')]")
	public WebElement customerContactemail;

	@FindBy(xpath = "//*[contains(@name,'address')]")
	public WebElement customerContactAddress;

	@FindBy(xpath = "//input[contains(@name,'file_lac_dep_no')]")
	public WebElement homeLoanAccountNumber;

	@FindBy(xpath = "//*[contains(@name,'interactiondetails')]")
	public WebElement writeEnquiry;

	@FindBy(xpath = "//select[@name='branch_country']")
	public WebElement selectCountry;

	@FindBy(xpath = "//div[contains(@class,'form-item-conformation checkbox')]")
	public WebElement conformation;

	// @FindBy(xpath = " //*[@id=\"edit-submit\"]")
	// @FindBy(xpath = "//*[contains(@id,'edit-submit--1jYofrwqFbI')]")
	// @FindBy(xpath =
	// "/html/body/div[2]/div[2]/div[2]/div/section/div[2]/article/div/div/div[2]/div[3]/div/div/form/div[15]/button")
	@FindBy(xpath = "(//div[contains(@id,'edit-actions') and (@class='form-actions form-group js-form-wrapper form-wrapper')])[1]")
	public WebElement Submit;

	@FindBy(xpath = "//*[@id=\"webform-submission-write-to-us-node-218-add-form\"]/div[12]/div")
	public WebElement errorMessageForAcno;

	@FindBy(xpath = "//select[@name='category']")
	public WebElement categorySelect;

	//// *[@id="edit-sub-category--OMOxGSCJ9hk"]

	@FindBy(xpath = "//*[contains(@id,'edit-sub-category-')]")
	public WebElement subcategorySelect;

	public ContactUsPage_932394() {
		PageFactory.initElements(driver, this);
	}

	public String contactUsPagevalidationForHeaders() throws InterruptedException {
		closeButton.click();
		String Pagetitle = driver.getCurrentUrl();

		Actions action = new Actions(driver);
		action.moveToElement(contactUs).build().perform();

		contactUs.click();

		action.moveToElement(helpLineNumbers).build().perform();

		action.moveToElement(locateUs).build().perform();

		action.moveToElement(grievanceRedressal).build().perform();

		action.moveToElement(hdfcCorpOffice).build().perform();

		action.moveToElement(hdfcDepositCentres).build().perform();

		return contactUs.getText();
	}

	public boolean iscontactUsDisplayed() {

		return contactUs.isDisplayed();
	}

	public boolean isWriteToUsDisplayed() {

		return writeToUs.isDisplayed();
	}

	public boolean isLocateUsDisplayed() {

		return locateUs.isDisplayed();
	}

	public boolean isGrievanceRedressalDisplayed() {

		return grievanceRedressal.isDisplayed();
	}

	public boolean ishdfcCorpOfficeDisplayed() {

		return writeToUs.isDisplayed();
	}

	public boolean ishdfcDepositCentresDisplayed() {

		return hdfcDepositCentres.isDisplayed();
	}

	public void WriteToUsValidation(String enquiryType, String subenquiryType, String customerNameInput,
			String contactNumber, String customerEmail, String customerAddress, String writeAnEnquiry)
			throws InterruptedException, Exception {

		baseClass = new BaseClass();

		closeButton.click();

		contactUs.click();

		Actions mouseactions = new Actions(driver);
		mouseactions.moveToElement(writeToUs).build().perform();
		writeToUs.click();

		String HomePageWindow = driver.getWindowHandle();

		Set<String> s1 = driver.getWindowHandles();

		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {
			String writetoUsRequestPage = i1.next();
			if (!HomePageWindow.equalsIgnoreCase(writetoUsRequestPage)) {
				driver.switchTo().window(writetoUsRequestPage);

				closeButton.click();

				homeLoanSelect.click();

				newCustomerselect.click();

				baseClass.selectDropDownValue(categorySelect, enquiryType);

				baseClass.selectDropDownValue(subcategorySelect, subenquiryType);

				Select country = new Select(selectCountry);
				country.selectByIndex(2);

				customerName.sendKeys(customerNameInput);
				customerContactNumber.sendKeys(contactNumber);
				customerContactemail.sendKeys(customerEmail);
				customerContactAddress.sendKeys(customerAddress);

				writeEnquiry.clear();
				writeEnquiry.sendKeys(writeAnEnquiry);
				conformation.click();
				conformation.isSelected();

				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				String currentDir = System.getProperty("user.dir");
				FileUtils.copyFile(scrFile,
						new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));

				Submit.submit();

			}
		}

	}

}
