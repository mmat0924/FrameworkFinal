package privatefw.E2E;

import java.io.IOException;

import org.testng.annotations.Test;

public class FirstTest extends  Base {
	
	
	@Test
	public void launch() throws IOException {
		
		driver = initializeDriver();
		
		driver.get("https://rahulshettyacademy.com/");
		
		driver.quit();
		
		
	}
	
	
	
	
	
	
	

}
