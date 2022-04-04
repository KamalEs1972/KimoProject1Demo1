package pageOpbejcts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import actionDrivers.Action;
import resources.BaseClass;



public class ContactPage extends BaseClass {
	@FindBy(id="input-429635056604957937")
	WebElement firstNameInput;
	@FindBy(id="input-429635056604957937-1")
	WebElement lastNameInput;
	@FindBy(id="input-986473933380659807")
	WebElement email1;
	@FindBy(id="input-855943669296945540")
	WebElement commentBox;
	@FindBy(id="form-110534305204761287-opt-in")
	WebElement checkBox;
	
	public ContactPage() {
		PageFactory.initElements(driver, this);
}
	public void enterInfos(String firstName, String lastName,String email,String comment) {
		Action.type(firstNameInput, firstName);
		//System.out.println(userName);
	//	Action.fluentWait(driver,emailBox,10);
		Action.type(lastNameInput, lastName);
		Action.type(email1, email);
		Action.type(commentBox, comment);
		
		Action.click(driver, checkBox);
		
		
		//Action.click(driver, submitLogin);
	//	return new HomePage();
//	public void enterFirstName(String firstName) {
//		Action.type(firstNameInput, firstName);
//		
//	}
//	public void enterLastName(String lastName) {
//		Action.type(lastNameInput, lastName);
//		
//		}
//	public void enterEmail(String email1) {
//		Action.type(email, email1);
//		
	}
}