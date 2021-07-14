package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import resources.Base;


public class FourTest extends Base {
	 public WebDriver driver;

	@Test
	
	public void fourTest() throws IOException, InterruptedException  {
		
		System.out.println("this is modified by pooja");
		System.out.println("fourtest");
		 driver = initilizebrowser();
		driver.get(prop.getProperty("url"));
		
		Assert.assertTrue(false);
		
		Thread.sleep(1000);
		driver.close();
	}
}
