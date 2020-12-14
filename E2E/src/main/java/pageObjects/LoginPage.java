package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	/* page object class structure involves objects, methods which return objects 
	 * and constructor
	 */


	WebDriver driver; 

    
	private By email = By.cssSelector("[id='user_email']");
	private By password = By.cssSelector("[id='user_password']");
	private By login = By.cssSelector("[value='Log In']");
	private By forgotPass = By.cssSelector("[href*='password/new']");


	//define constructor to give life to driver when creating objects of this class

	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}



	public WebElement getEmail()
	{
		return driver.findElement(email);
	}

	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement clickLogin()
	{
		return driver.findElement(login);
	}
	
    public ResetPage getPassLink()
    {
    	driver.findElement(forgotPass).click();
    	return new ResetPage(driver);
    }




}
