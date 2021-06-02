package com.test.pages;

import java.io.File;
import java.io.IOException;
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

import com.test.base.BaseClass;
import com.test.config.TestUtil;

public class ExsistingCustomerPage_932394 extends BaseClass {

	@FindBy(xpath = "//*[contains(@id,'HomepageModalVideo')]/div/div/div[1]/button[1]")
	public WebElement closebutton;

////*[@id="navbarDropdown"]
//	@FindBy(linkText="Existing Customers")
	@FindBy(xpath = "//*[@id='navbarDropdown' and @title='Existing Customers']")
	WebElement exsistingCusLink;

	// @FindBy(linkText="Existing Customers")
	// @FindBy(xpath = "(//*[@class='dropdown-toggle' and @title='For Home
	// Loans'])[1]")
	@FindBy(xpath = "(//*[contains(@title, 'For Home Loans')])[2]")
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

	// @FindBy(xpath = "//*[@id=\"login_box\']/span")

	@FindBy(xpath = "//*[contains(@id,'login_box')]/span")
	WebElement captureErrorMessage;

	public ExsistingCustomerPage_932394() {
		PageFactory.initElements(driver, this);
	}

	public void createLogin(String userNameInput, String userPasswordInput) throws InterruptedException, IOException {

		closebutton.click();
		String Pagetitle = driver.getCurrentUrl();

		Actions mouseactions = new Actions(driver);

		mouseactions.moveToElement(exsistingCusLink).build().perform();
		forHomeLoanLinlk.click();
		mouseactions.moveToElement(forHomeLoanLinlk).build().perform();
		mouseactions.moveToElement(custommerlogin).click().perform();
		System.out.println("custommerlogin is " + custommerlogin);

		String HomePageWindow = driver.getWindowHandle();
		System.out.println("Main window handle is " + HomePageWindow);
		System.out.println("Main window handle is " + driver.getCurrentUrl());

		// To handle all new opened window
		Set<String> s1 = driver.getWindowHandles();
		System.out.println("Child window handle is" + s1);
		System.out.println("Child window handle is " + driver.getCurrentUrl());
		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {
			String customerLoginPage = i1.next();
			if (!HomePageWindow.equalsIgnoreCase(customerLoginPage)) {
				driver.switchTo().window(customerLoginPage);
				System.out.println("Switching to child Windoiw");
				System.out.println("Child window handle is " + driver.getCurrentUrl());

				userIdButton.click();

				userName.clear();
				userName.sendKeys(userNameInput);

				String Pagetitle1 = driver.getCurrentUrl();
				System.out.println(Pagetitle1);

				userPassword.sendKeys(Pagetitle1);

				WebElement Submit = driver.findElement(By.xpath("//button[contains(text(),'LOGIN')]"));

				Submit.click();

				captureErrorMessage.getText();

				System.out.println("captureErrorMessage" + captureErrorMessage.getText());
				System.out.println("closing the child window ");

			}

			driver.navigate().to(prop.getProperty("url"));

		}

	}

}
