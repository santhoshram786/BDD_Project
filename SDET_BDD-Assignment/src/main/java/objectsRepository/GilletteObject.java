package objectsRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GilletteObject {
	
	
	private WebDriver driver;

	public GilletteObject(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".event_profile_register")
	WebElement Register;
	
	public WebElement Register() {
		return Register;
	}
	
	@FindBy(id="phdesktopbody_0_grs_consumer[firstname]")
	WebElement firstName;
	
	public WebElement firstName() {
		return firstName;
	}
	
	@FindBy(id="phdesktopbody_0_grs_consumer[lastname]")
	WebElement lastName;
	
	public WebElement lastName() {
		return lastName;
	}
	

	@FindBy(id="phdesktopbody_0_grs_account[emails][0][address]")
	WebElement Email;
	
	public WebElement Email() {
		return Email;
	}
	
	@FindBy(id="phdesktopbody_0_grs_account[password][password]")
	WebElement Password;
	
	public WebElement Password() {
		return Password;
	}
	
	@FindBy(id="phdesktopbody_0_grs_account[password][confirm]")
	WebElement confirmPassword;
	
	public WebElement confirmPassword() {
		return confirmPassword;
	}
	
	@FindBy(id="phdesktopbody_0_grs_account[addresses][0][postalarea]")
	WebElement zipCode;
	
	public WebElement zipCode() {
		return zipCode;
	}
	
	@FindBy(id="phdesktopbody_0_grs_consumer[birthdate][month]")
	WebElement selectMonth;
	
	public WebElement selectMonth() {
		return selectMonth;
	}
	
	@FindBy(id="phdesktopbody_0_grs_consumer[birthdate][year]")
	WebElement selectYear;
	
	public WebElement selectYear() {
		return selectYear;
	}
	
	@FindBy(id="phdesktopbody_0_ctl44")
	WebElement agreeConditions;
	
	public WebElement agreeConditions() {
		return agreeConditions;
	}
	
	@FindBy(id="phdesktopbody_0_submit")
	WebElement createAccount;
	
	public WebElement createAccount() {
		return createAccount;
	}
	@FindBy(id="phdesktopbody_0_Header")
	WebElement registrationSummary;
	
	public WebElement registrationSummary() {
		return registrationSummary;
	}
	
}
