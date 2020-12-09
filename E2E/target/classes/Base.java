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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	
	// define outside of method so that other classes can access these objects

	public WebDriver driver; 

	public Properties prop;

	/* creating method to initialize the driver object */

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();

		FileInputStream fis = new FileInputStream("C:\\Users\\melma\\eclipsefw-final\\E2E\\src\\main\\java\\resources\\data.properties");

		prop.load(fis); 

		String browsername = prop.getProperty("browser");

		if(browsername.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\melma\\drivers\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();

		}

		else if (browsername.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", "C:\\Users\\melma\\drivers\\geckodriver-v0.28.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if (browsername.equals("IE")) {

			System.setProperty("webdriver.ie.driver", "C:\\Users\\melma\\drivers\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //adding an implicit wait

		return driver; //returning driver to be used in test cases

	}

	
	public void getScreenShot(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;  
		File src = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") +"\\reports\\" +testCaseName+".png";
		FileUtils.copyFile(src, new File(destinationFile));
		
		
		
	}
	
	
	
	
}
