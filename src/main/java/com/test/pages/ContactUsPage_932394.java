package com.test.pages;

import java.io.File;

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

	// PageFactory -OR:

	@FindBy(xpath = "//body/div[@id='mm-0']/div[@id='HomepageModalVideo']/div[1]/div[1]/div[1]/button[1]")
	public WebElement closebutton;

	// @FindBy(xpath = "(//a[@title='Contact Us'])[1]")
	// public WebElement contactUs;

	@FindBy(xpath = "//header/div[1]/div[2]/div[1]/section[1]/div[1]/div[1]/ul[3]/li[5]")
	public WebElement contactUs;

	@FindBy(xpath = "//*[@id=\"primary-menu\"]/li[5]/div/div[1]/ul/li[1]/a")
	public WebElement writeToUs;

	@FindBy(xpath = "//*[@id=\"mm-0\"]/div[2]/div[2]/div/section/div[2]/article/div/div/div[2]/div[2]/h2/span")
	public WebElement writeToUs2;

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

	@FindBy(xpath = "//*[contains(@name,'file_lac_dep_no')]")
	public WebElement homeLoanAccountNumber;

	@FindBy(xpath = "//*[contains(@name,'interactiondetails')]")
	public WebElement writeEnquiry;

	@FindBy(xpath = "//*[@id=\"webform-submission-write-to-us-node-218-add-form\"]/div[14]/label")
	public WebElement conformation;

	@FindBy(xpath = "//button[@id='edit-submit']")
	public WebElement Submit;

	@FindBy(xpath = "//*[@id=\"webform-submission-write-to-us-node-218-add-form\"]/div[12]/div")
	public WebElement errorMessageForAcno;

	public ContactUsPage_932394() {
		PageFactory.initElements(driver, this);
	}

	public String contactUsPagevalidationForHeaders() throws InterruptedException {
		closebutton.click();
		String Pagetitle = driver.getCurrentUrl();
		logger.info("pagename :" + Pagetitle.toString());

		Actions action = new Actions(driver);
		action.moveToElement(contactUs).build().perform();
		contactUs.click();
		Thread.sleep(2000);
		// contactUs.click();
		contactUs.getText();
		logger.info("pagename :" + contactUs.getText());

		return contactUs.getText();
	}

	public void WriteToUsValidation(String customerNameInput, String contactNumber, String customerEmail,
			String customerAddress, String writeAnEnquiry) throws InterruptedException, Exception {

		closebutton.click();
		String Pagetitle = driver.getCurrentUrl();
		logger.info("pagename :" + Pagetitle.toString());

		driver.navigate().to(prop.getProperty("writeTousURL"));

		homeLoanSelect.click();

		newCustomerselect.click();

		Select category = new Select(driver.findElement(By.xpath("//select[@name='category']")));
		// category.selectByIndex(15);
	//	category.selectByVisibleText("LOAN APPLICATION");
	 	category.selectByVisibleText("BEHAVIOURAL ISSUES");

		Select country = new Select(driver.findElement(By.xpath("//select[@name='branch_country']")));
		country.selectByIndex(2);

		customerName.sendKeys(customerNameInput);
		customerContactNumber.sendKeys(contactNumber);
		customerContactemail.sendKeys(customerEmail);
		customerContactAddress.sendKeys(customerAddress);
		writeEnquiry.clear();
		writeEnquiry.sendKeys(writeAnEnquiry);

		// conformation.click();
		conformation.isSelected();
		logger.info("conformation :" + conformation.getText());
		
	
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));

		Submit.click();
		logger.info("conformation :" + Submit.getText());

		//errorMessageForAcno.getText();
		// logger.info("errorMessageForAcno :" + errorMessageForAcno.getText());

	}
	
	

}
