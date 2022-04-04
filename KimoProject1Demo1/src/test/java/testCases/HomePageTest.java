package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import actionDrivers.Action;
import resources.BaseClass;
import pageOpbejcts.HomePage;

public class HomePageTest extends BaseClass {
	  HomePage homePage;

	
	@Test(groups = "Smoke")
	public void verifyLogo() {
		homePage= new HomePage();
		// driver.get(prop.getProperty("url"));
		boolean result=homePage.verifylogo();
		Assert.assertTrue(result);
		homePage.clickOnContact();
		
		

}
	
	}
