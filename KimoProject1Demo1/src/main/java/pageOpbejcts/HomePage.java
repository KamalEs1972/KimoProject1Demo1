package pageOpbejcts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import actionDrivers.Action;
import resources.BaseClass;





public class HomePage extends BaseClass {
	
	@FindBy (xpath="//a[normalize-space()='Contact']")
	WebElement contactBtn;
	@FindBy(xpath="//img[@alt='ARABIC BAND & DJ IN WASHINGTON DC']")
	WebElement logo;
	@FindBy(id="active")
	WebElement contactActive;
	@FindBy(xpath="//span[@class='wsite-button-inner']")
	static WebElement  submitBtn;
	

	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
public boolean verifylogo()  {
		
		
		return Action.isDisplayed(driver, logo);
}
	public void clickOnContact()  {

	Action.click(driver, contactBtn);
	
boolean result=Action.isDisplayed(driver, contactActive);
	Assert.assertTrue(result);
	
	
	
	
		
		//return new LoginPage();
		
	}
	

}
