 package privatefw.E2E;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class FirstTest extends  Base {

	
	LandingPage lp;
	public static Logger log = LogManager.getLogger(Base.class.getName()); // use this code in every test case
    public WebDriver driver; //create driver variable local to the class so that it doesn't get overridden by another class 

	@BeforeTest
	public void setUp() throws IOException {

		driver = initializeDriver();
		log.info("Driver successfully installed");
	}



	@Test(dataProvider="getData")
	public void launch(String username, String password) throws IOException {


		driver.get(prop.getProperty("url"));
		
		log.info("Navigation to the URL succeeded");

		//create object of landing page to access methods of that class

		lp = new LandingPage(driver);

		Assert.assertTrue(lp.disNav().isDisplayed()); //checks if the argument returns true
		
		log.info("Navigation bar is present");

		Assert.assertEquals("Featured Courses", lp.disText().getText());   
		
		log.info("Text is validated in home screen");

		 LoginPage l  = lp.getLogin();
		
		/*
		 * LoginPage l = new LoginPage(driver);
		 */

		log.info("Able to land on login page");
		
		l.getEmail().sendKeys(username);

		l.getPassword().sendKeys(password);

		l.clickLogin().click();




	}


	@AfterTest
	public void tearDown() {

		driver.quit();
		
		log.info("Browser closed");
	}



	/* Using Testng annotation the below method 
	 * would supply data multiple times
	 */


	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[2][2];

		data[0][0] = "abc@gmail.com";
		data[0][1] = "pass";
		data[1][0] = "xyz@gmail.com";
		data[1][1] = "pass";

		return data;
	}




}
