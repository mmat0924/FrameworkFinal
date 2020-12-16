package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	
	// define outside of method so that other classes can access these objects

	public WebDriver driver; 

	public Properties prop;

	/* creating method to initialize the driver object */

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();

		
		//no hard coded paths
		
		/*FileInputStream fis = new FileInputStream("C:\\Users\\melma\\eclipsefw-final\\E2E\\src\\main\\java\\resources\\data.properties");*/
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");

		prop.load(fis); 

		String browsername = prop.getProperty("browser"); 
		
		/*String browsername = System.getProperty("browser");*/ //drive from jenkins
		
		

		if(browsername.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\src\\main\\java\\resources\\chromedriver.exe");
			driver = new ChromeDriver();

		}
		
		//chrome headless execution
		
	/*	if(browsername.contains("chrome")) {

			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\src\\main\\java\\resources\\chromedriver.exe");
			ChromeOptions op = new ChromeOptions();
			if(browsername.contains("headless"))
			op.addArguments("headless");
			driver = new ChromeDriver(op);
		}
*/
		else if (browsername.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "\\src\\main\\java\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if (browsername.equals("IE")) {

			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") +"\\src\\main\\java\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //adding an implicit wait

		return driver; //returning driver to be used in test cases

	}

	
	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;  
		File src = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") +"\\reports\\" +testCaseName+".png";
		FileUtils.copyFile(src, new File(destinationFile));
		return destinationFile;
		
		
		
	}
	
	
	
	
}
