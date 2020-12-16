package privatefw.E2E;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;

import resources.Base;

public class Pattern extends  Base {
	
	LandingPage lp;

	public static Logger log = LogManager.getLogger(Base.class.getName()); // use this code in every test case
	public WebDriver driver; //create driver variable local to the class so that it doesn't get overridden by another class 

	@BeforeTest
	public void setUp() throws IOException {

		driver = initializeDriver();
		log.info("Driver successfully installed");
	}



	@Test
	public void patternMatch() throws IOException {


		driver.get(prop.getProperty("url"));

		log.info("Navigation to the URL succeeded");

		//create object of landing page to access methods of that class

		lp = new LandingPage(driver);

		Assert.assertEquals("Featured Courerses", lp.disText().getText());   

		log.info("Text is validated in home screen");





	}


	@AfterTest
	public void tearDown() {

		driver.quit();

		log.info("Browser closed");
	}





}
