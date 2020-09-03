package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.Base;
import pageObj.HotelLoginPageObj;
import utilities.DriverUtility;

public class HotelLogin extends Base {

	HotelLoginPageObj hotelpageObj;
	
	
	@BeforeMethod 
	
	public void beforeMethod () {
		
		Base.initializedriver();
		logger.info("browser opened successfully");
		
		
	}
	
	@Test 
	
	
	public void loginToHotelPage() {
		
		hotelpageObj = new HotelLoginPageObj();
		hotelpageObj.clicknSignIn();
		logger.info("user clicked on sign in");
		hotelpageObj.enterEmail(getUserName());
		logger.info("user entered email");
		hotelpageObj.enterPassword(getPassword());
		logger.info("user entered password");
		hotelpageObj.clickonSignInButton();
		logger.info("user clicked on sign in button");
		DriverUtility.wait(5000);
		DriverUtility.screenShot();
	}
	
	
	@AfterMethod 
	
	public void afterMethod () {
		Base.tearDown();
		logger.info("browser closed successfully");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
