package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	/* page object class structure involves objects, methods which return objects 
	 * and constructor
	 */


	WebDriver driver; 

    //achieve encapsulation with public methods and private variables
	
	private By login = By.cssSelector("a[href*='sign_in']");

	private By navBar = By.xpath("//header/div[2]/div[1]/div[1]/div[2]/nav[1]/div[2]/ul[1]");

	private By lanText = By.xpath("//h2[contains(text(),'Featured Courses')]");
	
	//define constructor to give life to driver when creating objects of this class

	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}



	public LoginPage getLogin()
	{
		driver.findElement(login).click(); //modified page object structure to return object 
		return new LoginPage(driver);
	}



	public WebElement disNav()
	{
		return driver.findElement(navBar);
	}


    public WebElement disText()
    {
    	return driver.findElement(lanText);
    }
	
}
