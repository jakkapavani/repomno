package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;


public class TwoTest extends Base {
	
	 public WebDriver driver;
	@Test
	public void testwo() throws IOException, InterruptedException {
		
		System.out.println("TestTwo");
		
		 driver = initilizebrowser();
		driver.get(prop.getProperty("url"));
		Thread.sleep(1000);
		driver.close();		
	}
	
 
}
