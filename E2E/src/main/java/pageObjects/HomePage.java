package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	/* page object class structure involves objects, methods which return objects 
	 * and constructor
	 */


	WebDriver driver; 

    
	private By course = By.xpath("//input[@id='search-courses']");


	//define constructor to give life to driver when creating objects of this class

	public HomePage(WebDriver driver) {
		this.driver=driver;
	}



	public WebElement getCourseField()
	{
		return driver.findElement(course);
	}

	




}
