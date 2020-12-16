package stepDefinition;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObjects.HomePage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

import org.junit.Assert;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class StepDefinition extends Base {

	@Given("^Initialize the browser$")
	public void initialize_the_browser() throws Throwable {

		driver = initializeDriver();
	    
	    
	}

	@Given("^Navigate to \"([^\"]*)\" specified$")
	public void navigate_to_specified(String arg1) throws Throwable {
		
		driver.get(arg1);
	    
	}

	@Given("^click on login button$")
	public void click_on_login_button() throws Throwable {
		
		LandingPage lp = new LandingPage(driver);
		lp.getLoginLink().click();
	    
	}
	
	 @When("^User enters username (.+) password (.+) and clicks logIn button$")
	    public void user_enters_username_password_and_clicks_login_button(String username, String password) throws Throwable {
		 LoginPage l = new LoginPage(driver);
			l.getEmail().sendKeys(username);
			l.getPassword().sendKeys(password);
			l.clickLogin().click();
	    }



	@Then("^Verify Login is successful$")
	public void verify_Login_is_successful() throws Throwable {
		
	    HomePage hp = new HomePage(driver);
	    Assert.assertTrue(hp.getCourseField().isDisplayed());
	    
	}
	
	  @And("^logout of the application $")
	    public void logout_of_the_application() throws Throwable {
			driver.quit();
	    }

}