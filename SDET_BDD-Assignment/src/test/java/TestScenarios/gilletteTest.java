package TestScenarios;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Assume;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Main.Base;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import excelUtility.DataHelper;
import objectsRepository.GilletteObject;
import objectsRepository.loginObject;
import objectsRepository.resetPasswordObject;

public class gilletteTest extends Base {

	GilletteObject obj;
	loginObject logObj;
	resetPasswordObject pasObj;
	public WebDriver driver;
	Select select;
	static int index;
	public List<HashMap<String, String>> datamap;

	@Before("@skip_scenario")
	public void skip_scenario(Scenario scenario) {
		System.out.println("SKIP SCENARIO: " + scenario.getName());
		Assume.assumeTrue(false);

	}

	public gilletteTest() throws IOException {
		driver = initialize();
		datamap = DataHelper.data(System.getProperty("user.dir") + "\\src\\main\\java\\excelData\\UserData.xlsx",
				"info");
		obj = new GilletteObject(driver);
		logObj = new loginObject(driver);
		pasObj = new resetPasswordObject(driver);
		driver.get(prop.getProperty("url"));
	}

	@Given("^User launched the Application for Registration$")
	public void user_launched_the_Application_for_Registration() {
		obj.Register().click();
	}

	@When("^User enters \"([^\"]*)\"$")
	public void user_enters(String arg1) {

		index = Integer.parseInt(arg1) - 1;
		for (HashMap h : datamap) {
			System.out.println("Row Hearders:" + h.keySet());
			System.out.println("Respective Data:" + h.values());
		}

		System.out.println("index:" + index);
		obj.firstName().clear();
		obj.firstName().sendKeys(datamap.get(index).get("firstName"));
		obj.lastName().clear();
		obj.lastName().sendKeys(datamap.get(index).get("lastName"));
		obj.Email().clear();
		obj.Email().sendKeys(datamap.get(index).get("Email"));
		obj.Password().clear();
		obj.Password().sendKeys(datamap.get(index).get("Password"));
		obj.confirmPassword().clear();
		obj.confirmPassword().sendKeys(datamap.get(index).get("ConfirmPassword"));
		getSelected(obj.selectMonth(), datamap.get(index).get("Month"));
		getSelected(obj.selectYear(), datamap.get(index).get("Year"));
		obj.zipCode().clear();
		obj.zipCode().sendKeys(datamap.get(index).get("ZipCode"));
		Boolean flag = obj.agreeConditions().isSelected();
		if (flag.toString() == "true")

		{
			obj.agreeConditions().click();
			obj.agreeConditions().click();
		}

		else
			obj.agreeConditions().click();

	}

	@When("^Clicks on Create Accout$")
	public void clicks_on_Create_Accout() {

		obj.createAccount().click();
	}

	@Then("^User is sucessfully registered$")
	public void user_is_sucessfully_registered() {
		System.out.println(obj.registrationSummary().getText());
		Assert.assertEquals("YOUR REGISTRATION IS COMPLETE", obj.registrationSummary().getText());
	}



	// Login Scenario

	@Given("^User Launched Signup Page$")
	public void user_Launched_Signup_Page() {

		logObj.SignIn().click();

	}

	@When("^User enters Email and Password \"([^\"]*)\"$")
	public void user_enters_Email_and_Password(String arg1) throws Exception {
		
		logObj.Email().clear();
		logObj.Email().sendKeys(datamap.get(index).get("Email"));
		logObj.Password().clear();
		logObj.Password().sendKeys(datamap.get(index).get("Password"));
		logObj.Login().click();

	}

	@Then("^User should be sucessfully navigated to Home Page$")
	public void user_should_be_sucessfully_navigated_to_Home_Page() {

		Assert.assertEquals(datamap.get(index).get("firstName"), logObj.verifyFirstName().getText());
		Assert.assertEquals(datamap.get(index).get("lastName"), logObj.verifyLastName().getText());
		logObj.logOut().click();
		logObj.continueLogOut().click();
	}

	// Reset Password Senario

	@Given("^User Launched Signup Page for Resetting APassword$")
	public void user_Launched_Signup_Page_for_Resetting_APassword() {
		logObj.SignIn().click();
		pasObj.forgotPassword().click();

	}

	@When("^User clicks on reset password \"([^\"]*)\"$")
	public void user_clicks_on_reset_password(String arg1) {
		pasObj.Email().sendKeys(datamap.get(index).get("Email"));
		pasObj.createPassword().click();

	}

	@Then("^User should be sucessfully reset the password$")
	public void user_should_be_sucessfully_reset_the_password() {

		Assert.assertEquals("You will receive an e-mail very shortly containing a link to reset your password.",
				pasObj.passwordResetMessage().getText());

	}

	private void getSelected(WebElement ele, String value) {

		select = new Select(ele);
		select.selectByValue(value);

	}
	@After
	public void quitBrowser() {

		driver.quit();
	}

	
	
}
