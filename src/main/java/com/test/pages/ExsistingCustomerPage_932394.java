package com.test.pages;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.base.BaseClass;
import com.test.config.TestUtil;

public class ExsistingCustomerPage_932394 extends BaseClass {

	@FindBy(xpath = "//body/div[@id='mm-0']/div[@id='HomepageModalVideo']/div[1]/div[1]/div[1]/button[1]")
	public WebElement closebutton;

////*[@id="navbarDropdown"]
//	@FindBy(linkText="Existing Customers")
	@FindBy(xpath = "//*[@id='navbarDropdown' and @title='Existing Customers']")
	WebElement exsistingCusLink;

//@FindBy(linkText="Existing Customers")
	@FindBy(xpath = "(//*[@class='dropdown-toggle' and @title='For Home Loans'])[1]")
	WebElement forHomeLoanLinlk;

	@FindBy(xpath = "//li[@class='first leaf']/a[@title='Customer Login']")
	WebElement custommerlogin;

	@FindBy(xpath = "//label[@data-tab_name='withlogin']")
	WebElement userIdButton;

	@FindBy(xpath = "//*[@id='loginForm']/div/div[1]/div/input")
	WebElement userName;

	@FindBy(xpath = "//input[@name='password']")
	WebElement userPassword;

	@FindBy(xpath = "//button[contains(text(),'LOGIN')]")
	WebElement Submit;

	@FindBy(xpath = "//*[@id=\"login_box\"]/span")
	WebElement captureErrorMessage;

	public ExsistingCustomerPage_932394() {
		PageFactory.initElements(driver, this);
	}

	public void createLogin(String userNameInput, String userPasswordInput) throws InterruptedException, IOException {

		closebutton.click();
		String Pagetitle = driver.getCurrentUrl();
		logger.info("pagename :" + Pagetitle.toString());

		Actions mouseactions = new Actions(driver);

		mouseactions.moveToElement(exsistingCusLink).build().perform();

		logger.info("mouseactions :" + exsistingCusLink.getText());

		logger.info("mouseactions :" + forHomeLoanLinlk.getText());
		logger.info("mouseactions :" + custommerlogin.getText());
		// new WebDriverWait(driver,
		// 20).until(ExpectedConditions.elementToBeClickable(custommerlogin)).click();

		String customerLoginurl = "https://portal.hdfc.com/login";
		driver.navigate().to(customerLoginurl);
//			
		Set<String> customerLogin = driver.getWindowHandles();
		System.out.println(customerLogin);

		userIdButton.click();
		logger.info("userIdButton :" + userIdButton.getText());
		logger.info("userIdButton :" + userIdButton.isSelected());
		logger.info("userIdButton :" + userIdButton.isEnabled());

		userName.clear();
		userName.sendKeys(userNameInput);

		logger.info("userName :" + userName.getText());
		logger.info("userName :" + userName.isSelected());
		logger.info("userName :" + userName.isEnabled());
		String Pagetitle1 = driver.getCurrentUrl();
		logger.info("pagename :" + Pagetitle.toString());
		logger.info("pagename :" + Pagetitle1.toString());

		userPassword.sendKeys(userPasswordInput);

		logger.info("userPassword :" + userName.getText());
		logger.info("userPassword :" + userName.isSelected());
		logger.info("userPassword :" + userName.isEnabled());

		WebElement Submit = driver.findElement(By.xpath("//button[contains(text(),'LOGIN')]"));

		Submit.click();

		captureErrorMessage.getText();
		logger.info("pagename :" + captureErrorMessage.toString());

		TestUtil.takeScreenshotAtEndOfTest();

		driver.navigate().to(prop.getProperty("url"));

		// captureErrorMessage.getText();
		logger.info("pagename :" + captureErrorMessage.toString());
	}

}
