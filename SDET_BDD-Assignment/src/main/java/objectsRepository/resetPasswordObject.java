package objectsRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class resetPasswordObject {
	
	private WebDriver driver;

	public resetPasswordObject(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="phdesktopbody_0_forgotpassword")
	WebElement forgotPassword;
	
	public WebElement forgotPassword() {
		return forgotPassword;
	}
	
	@FindBy(id="phdesktopbody_0_username")
	WebElement Email;
	
	public WebElement Email() {
		return Email;
	}

	@FindBy(id="phdesktopbody_0_Create Your New Password")
	WebElement createPassword;
	
	public WebElement createPassword() {
		return createPassword;
	}
	
	@FindBy(xpath="//*[@id=\"phdesktopbody_0_afterSubmit\"]/div[2]/h2")
	WebElement passwordResetMessage;
	
	public WebElement passwordResetMessage() {
		return passwordResetMessage;
	}
}
