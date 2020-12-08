package privatefw.E2E;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class FirstTest extends  Base {
	
	
	@Test(dataProvider="getData")
	public void launch(String username, String password) throws IOException {
		
		driver = initializeDriver();
		
		driver.get(prop.getProperty("url"));
		
		//create object of landing page to access methods of that class
		
		LandingPage lp = new LandingPage(driver);
		
		Assert.assertTrue(lp.disNav().isDisplayed()); //checks if the argument returns true
		
		Assert.assertEquals("Featured Courses", lp.disText().getText());   
		
		lp.getLogin().click();
		
		LoginPage l = new LoginPage(driver);
		
		l.getEmail().sendKeys(username);
		
		l.getPassword().sendKeys(password);
		
		l.clickLogin().click();
		
		driver.quit();
		
		
	}
	
	
	@Test
	public void sample() {
		
		System.out.println("Hey, I'm just executing for fun!");
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
