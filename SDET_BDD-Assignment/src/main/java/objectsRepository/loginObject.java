package objectsRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginObject {
	
	private WebDriver driver;

	public loginObject(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(css=".event_profile_login")
	WebElement SignIn;
	
	public WebElement SignIn() {
		return SignIn;
	}

	@FindBy(id="phdesktopbody_0_username")
	WebElement Email;
	
	public WebElement Email() {
		return Email;
	}
	
	@FindBy(name="phdesktopbody_0$ctl04")
	WebElement Password;
	
	public WebElement Password() {
		return Password;
	}
	
	@FindBy(name="phdesktopbody_0$Sign In")
	WebElement Login;
	
	public WebElement Login() {
		return Login;
	}
	
	@FindBy(css="#phdesktopbody_0_Container > div.pc_txtfld.pc_fName > span:nth-child(2)")
	WebElement verifyFirstName;
	
	public WebElement verifyFirstName() {
		return verifyFirstName;
	}

	@FindBy(css="#phdesktopbody_0_Container > div.pc_txtfld.pc_lName > span:nth-child(2)")
	WebElement verifyLastName;
	
	public WebElement verifyLastName() {
		return verifyLastName;
	}
	
	@FindBy(id="phdesktopheader_0_phdesktopheadertop_2_LogOffLink")
	WebElement logOut;
	
	public WebElement logOut() {
		return logOut;
	}
	
	@FindBy(id="phdesktopheader_0_phdesktopheadertop_2_anchrContinue")
	WebElement continueLogOut;
	
	public WebElement continueLogOut() {
		return continueLogOut;
	}
	
	
}
