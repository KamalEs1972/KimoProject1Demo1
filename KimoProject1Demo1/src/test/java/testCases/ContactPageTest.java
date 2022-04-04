package testCases;



import org.testng.annotations.Test;



import actionDrivers.Action;
import dataProvider.DataProviders;
import resources.BaseClass;

import kimoProject1.utility.Log;
import pageOpbejcts.ContactPage;
import pageOpbejcts.HomePage;

public class ContactPageTest extends BaseClass {
	
	
	ContactPage contactPage;
	HomePage homePage;
	
	@Test(groups = "Regression", dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void enterInfos(String firstName, String lastName , String email,String comment)    {
		Log.startTestCase("enteFirstNameTest");
		homePage= new HomePage();
		contactPage= new ContactPage();
		
		Log.info("user is going to click on Contact");
		homePage.clickOnContact();
		
				Log.info("User clicks on Contact");
		contactPage.enterInfos(firstName, lastName,email,comment);
		
		//public static Logger log =LogManager.getLogger(base.class.getName());
		
	}
//	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class)
//	public void enteLastNameTest(String lastName)  {
//		//homePage= new HomePage();
//		//contactPage= new ContactPage();
//		
//		//homePage.clickOnContact();
//		Log.info("User enters last Name " );
//		contactPage.enterLastName(lastName);
//		
//		
//		//Thread.sleep(10);
//		
//	}
//	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class)
//	public void enterEmailTest(String email1 )  {
//		//homePage= new HomePage();
//		//contactPage= new ContactPage();
//		
//		//homePage.clickOnContact();
//		
//		contactPage.enterEmail(email1);
//		Log.info("User enters Email " );
//		//Thread.sleep(10);
//		Log.endTestCase("Contact Page Test");
//		
//	}
	
	
	
	

}
