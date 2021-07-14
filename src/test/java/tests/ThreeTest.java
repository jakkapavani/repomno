package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;


public class ThreeTest extends Base {
	 public WebDriver driver;
	
	@Test
	public void threetest() throws IOException, InterruptedException {
		 System.out.println("ThreeTest");
		 
		  driver = initilizebrowser();
		 driver.get(prop.getProperty("url"));
		 Thread.sleep(1000);
			driver.close();
	}

}
