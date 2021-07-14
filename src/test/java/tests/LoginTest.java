package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {
	WebDriver driver;
	 Logger log;
	@BeforeMethod
	public void openapplication() throws IOException {
		
		log= LogManager.getLogger(LoginTest.class.getName());
		driver = initilizebrowser();
		log.debug("Browser got Launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to Application URL ");	
	}

	@Test(dataProvider = "getLoginData")

	public void login(String email, String password, String expectedResult) throws IOException, InterruptedException {
		
		LandingPage landingpage = new LandingPage(driver);
		landingpage.myAccountDropdown().click();
		log.debug("Clicked on My Account dropdown");
		landingpage.loginOption().click();
		log.debug("Clicked on login option");
		Thread.sleep(3000);

		LoginPage loginpage = new LoginPage(driver);
		loginpage.emailAddressField().sendKeys(prop.getProperty("email"));
		log.debug("Email addressed got entered");
		loginpage.passwordField().sendKeys(prop.getProperty("password"));
		log.debug("Password got entered");
		loginpage.loginButton().click();
		log.debug("Clicked on Login Button");
		  AccountPage accountpage = new AccountPage(driver); 
		 String actualResult =null;
		 try {
			 if(accountpage.editYourAccountInformation().isDisplayed()) {
				 log.debug("User got logged in");
		  actualResult="Success";
		 } 
			 }catch(Exception e) {
				 log.debug("User didn't log in");
		  actualResult="Failure"; 
		  System.out.println("false");
		 }

			if(actualResult.equals(expectedResult)) {
				
				log.info("Login Test got passed");
				
			}else {
				
				log.error("Login Test got failed");
			}

		  }
		  
		  @AfterMethod 
		  public void closure() {
			  driver.close();
			  log.debug("Browser got closed");
			  }
		 
		 @DataProvider
		 public Object[][] getLoginData() {
		
		  Object[][] data ={{"pavani1234gmail.com","pavani123","Success"}};
		 
		 return data;
		  
		 }
		 
		
}
