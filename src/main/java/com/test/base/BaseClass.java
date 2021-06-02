package com.test.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;

import com.test.config.TestUtil;

public class BaseClass {

	public static WebDriver driver;
	public static Logger logger;
	public static Properties prop;

	public BaseClass() {

		try {
			prop = new Properties();
			File file = new File("src/main/resources/config.properties");
			FileInputStream ip = new FileInputStream(file);

			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void invokeBrowser(String browserName, String url) {

		try {
			if (browserName.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("Mozila")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("Edge")) {
				System.setProperty("webdriver.edge.driver",
						System.getProperty("user.dir") + "\\drivers\\MSEdgeDriver.exe");
				driver = new EdgeDriver();
			} else if (browserName.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITL_WAIT, TimeUnit.SECONDS);
		driver.get(url);

	}

	@BeforeClass
	public void setupLogger() {
		logger = Logger.getLogger("HDFC TEST API LOG"); // added Logger
		PropertyConfigurator.configure("log4j.properties"); // added logger
		logger.setLevel(Level.DEBUG);

	}

	public void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			logger.info("Page Alert Accepted");
		} catch (Exception e) {

		}

	}

	public void selectDropDownValue(WebElement webElement, String value) {
		try {
			Select select = new Select(webElement);
			select.selectByVisibleText(value);
			logger.info("Selectd the Value : " + value);
		} catch (Exception e) {

		}

	}
}