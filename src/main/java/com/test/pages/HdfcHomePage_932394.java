package com.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.base.BaseClass;

public class HdfcHomePage_932394 extends BaseClass {

//PageFActory -OR:

	@FindBy(xpath = "//body/div[@id='mm-0']/div[@id='HomepageModalVideo']/div[1]/div[1]/div[1]/button[1]")
	public WebElement closebutton;

	// @FindBy(xpath =
	// "//header/div[1]/div[2]/div[1]/section[1]/div[1]/div[1]/ul[3]/li[1]/a[1]")

	// @FindBy(xpath ="(//a[@title='Loan Products'])[1]")
	@FindBy(linkText = "Loan Products")
	public WebElement LoanProduct;

	@FindBy(xpath = "//*[@id=\'primary-menu\']/li[1]/div/div[1]/ul[1]/li[1]/a[1]")
//	@FindBy(linkText = "Housing Loans")
	public WebElement HousingLoan;

//	@FindBy(linkText = "Other Home Loan Products")
	@FindBy(xpath = "//*[@id=\'primary-menu\']/li[1]/div/div[1]/ul[2]/li[1]/a[1]")
	public WebElement OtherHomeLoanProducts;

//	@FindBy(linkText = "Non Housing Loans")
	@FindBy(xpath = "//*[@id=\'primary-menu\']/li[1]/div/div[1]/ul[3]/li[1]/a[1]")
	public WebElement NonHousingLoan;

	@FindBy(xpath = "//*[@id=\"navbar\"]/div/div[1]/div/a/img")
	public WebElement HdfcLogoImage;

//	@FindBy(xpath = "//*<a title=\"Deposits\" href=\"/deposits\">Deposits</a>")
	@FindBy(linkText = "Deposits")
	public WebElement deposits;

	// @FindBy(xpath = "//strong[contains(text(),'Attractive returns and safety, in
	// one Investment')]")
	@FindBy(xpath = "//h2[contains(text(),'in one Investment')]")
	public WebElement depositsStatement;

	@FindBy(xpath = "//body/div[@id='mm-0']/div[2]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]")
//	@FindBy(linkText = "Deposits")
	public WebElement applyOnline;

	public HdfcHomePage_932394() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnLoanHomeProduct() {
		closebutton.click();

		Actions action = new Actions(driver);
		action.moveToElement(LoanProduct).build().perform();
		LoanProduct.click();

	}

	public boolean validatehdfcLoanProductHousingLoan() {

		return HousingLoan.isDisplayed();
	}

	public boolean validatehdfcLoanProductnonHousingLoan() {

		return NonHousingLoan.isDisplayed();
	}

	public boolean validatehdfcLoanProductotherHomeLoan() {

		return OtherHomeLoanProducts.isDisplayed();
	}

	public boolean validateHDFCLogo() {
		return HdfcLogoImage.isDisplayed();

	}

	public String validatehdfcDepositStatement() {

		closebutton.click();
		deposits.click();

		String depositsStatementtext = depositsStatement.getText();

		return depositsStatementtext;

	}

	public boolean validateApplyOnlineIsDiplayed() {
		closebutton.click();
		deposits.click();
		return applyOnline.isDisplayed();
	}
}