package org.epam.browser;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;


public class WebDriverBaseClass {

	private static final Logger LOGGER = Logger.getLogger(WebDriverBaseClass.class);	
	
	@BeforeClass	
	public static  void setUp() {			
		LOGGER.info("initializing the driver with browser");
		SetUpWebDriver.initializeDriver();		
	}

	@AfterClass
	public static void tearDown() {
		
		LOGGER.info("closing the driver");

		SetUpWebDriver.closeBrowser();

		LOGGER.info("driver  closed");
	}

}
