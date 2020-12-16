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
import pageObjects.LoginPage;
import pageObjects.ResetPage;
import resources.Base;

public class Obtimize extends  Base {
	
	LandingPage lp; 

	public static Logger log = LogManager.getLogger(Base.class.getName()); // use this code in every test case
	public WebDriver driver; //create driver variable local to the class so that it doesn't get overridden by another class 

	@BeforeTest
	public void setUp() throws IOException {

		driver = initializeDriver();
		log.info("Driver successfully installed");
	}



	@Test
	public void launch() throws IOException {


		driver.get(prop.getProperty("url"));

		log.info("Navigation to the URL succeeded");

		//create object of landing page to access methods of that class

		lp = new LandingPage(driver);

		LoginPage l = lp.getLogin(); //clicks on the link and also returns object of next page

		log.info("Able to land on login page");
		
		ResetPage rp =l.getPassLink();

		Assert.assertEquals(rp.getResetText().getText(), "Reset Password");

		log.info("Text verification successful");

	}


	@AfterTest
	public void tearDown() {

		driver.quit();

		log.info("Browser closed");
	}



}
