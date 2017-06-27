package org.epam.browser;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.epam.enums.Browser;
import org.epam.utils.PropertiesUtil;
import org.openqa.selenium.WebDriver;

public class SetUpWebDriver {

	private static final Logger LOGGER = Logger.getLogger(SetUpWebDriver.class);
	private static WebDriver driver;
	private static WebDriverCreater driverCreator;	
		
	public static void initializeDriver() {
		switch (Browser.valueOf(getBrowsername().toUpperCase())) {
		case FIREFOX:
			driverCreator = new FirefoxBrowser();
			driver = driverCreator.getWebDriverInstance();
			break;
		case IEXPLORE:
			driverCreator = new IEBrowser();
			driver = driverCreator.getWebDriverInstance();
			break;
		case CHROME:
			driverCreator = new ChromeBrowser();
			driver = driverCreator.getWebDriverInstance();
			break;
		case EDGE:
			driverCreator = new EdgeBrowser();
			driver = driverCreator.getWebDriverInstance();
			break;
		default:
			LOGGER.info("Invalid browser " + getBrowsername());
			System.exit(0);
		}
		LOGGER.info("Script execting on " + getBrowsername() + "browser");
	}

	public static WebDriver getDriver() {
		return driver;
	}
	
	  public static Properties initPropertiesData() {
		  return new PropertiesUtil().getProperties("setup.properties");
	  }

	public static String getBrowsername() {		
		return initPropertiesData().getProperty("browser");
	}

	public static void setDriver(WebDriver driver) {
		SetUpWebDriver.driver = driver;
	}

	public static void openUrl(String url) {
		driver.manage().window().maximize();
		driver.get(url);
	}

	public static void closeBrowser()	{

		if (null != driver)	{
			driver.quit();
			driver = null;
		}

	}

}
