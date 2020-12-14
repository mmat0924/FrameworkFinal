package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResetPage {

	/* page object class structure involves objects, methods which return objects 
	 * and constructor
	 */


	WebDriver driver; 

    private By text = By.xpath("//h1[contains(text(),'Reset Password')]");
	


	//define constructor to give life to driver when creating objects of this class

	public ResetPage(WebDriver driver) {
		this.driver=driver;
	}



	public WebElement getResetText()
	{
		return driver.findElement(text);
	}

	



}
