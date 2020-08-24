package TestScenarios;

import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Assume;
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
import objectsRepository.goibiboObject;

public class goibiboTest extends Base {

	goibiboObject gObj;
	public WebDriver driver;
	Select select;
	static int index;
	public List<HashMap<String, String>> datainjecter;
	List<Integer> list;
	
	@Before("@skip_scenario")
	public void skip_scenario(Scenario scenario) {
		System.out.println("SKIP SCENARIO: " + scenario.getName());
		Assume.assumeTrue(false);

	}

	public goibiboTest() throws IOException {

		driver = initialize();
		datainjecter=DataHelper.data(System.getProperty("user.dir")+"\\src\\main\\java\\excelData\\Goibibo.xlsx", "info");		
		gObj = new goibiboObject(driver);
		
	}

	  @Given("^User launched Application and selected From and Destination \"([^\"]*)\"$")
	    public void user_launched_application_and_selected_from_and_destination_something(String strArg1) {
		  driver.get(prop.getProperty("goibibo_url"));
		  index=Integer.parseInt(strArg1)-1;
		  
		  	gObj.fromCity().click();
			gObj.fromCity().sendKeys(datainjecter.get(index).get("fromNickName"));

			List<WebElement> fromCities = gObj.fromlistBox();
			getSelected(fromCities, datainjecter.get(index).get("fromfullName"));

			gObj.toCity().sendKeys(datainjecter.get(index).get("toNickName"));

			List<WebElement> toCities = gObj.tolistBox();
			getSelected(toCities, datainjecter.get(index).get("tofullName"));

			WebElement selectMonth = gObj.selectCalenderMonth();
			String m = selectMonth.getText();
			if (!m.equals(datainjecter.get(index).get("Month")))
				gObj.clickNext().click();

			List<WebElement> selectDay = gObj.selectCalenderDay();

			getDateSelected(selectDay, datainjecter.get(index).get("Day"));

	    
	    }

	    @When("^User select Departure Date and Traveler Details \"([^\"]*)\"$")
	    public void user_select_departure_date_and_traveler_details_something(String strArg1) throws InterruptedException  {
	    	

			gObj.TravellerDetails().click();
			
			getTravelClassSelected(gObj.travelClass(),datainjecter.get(index).get("TravelClass"));
			
			gObj.Search().click();
			
			
	     
	    }

	@Then("^User should be able to view the flights avalible$")
	public void user_should_be_able_to_view_the_flights_avalible() throws InterruptedException, ParseException {
		
		String u=driver.getCurrentUrl();
		
		String from=datainjecter.get(index).get("fromNickName");
		String to=datainjecter.get(index).get("toNickName");
		String concat=from+"-"+to;
		if(u.contains("air-"+concat))
			System.out.println("User is now sucessfully view the avaliable flights");
		else
			System.out.println("User is not navigated to the specific url");
		
		Assert.assertEquals(u.contains("air-"+concat), true);
		
		List<WebElement> prices= gObj.price();
		
		System.out.println("The lowest price is:" + getCheapestPrice(prices));
	
		
	
	}
	
	    
	    private Integer getCheapestPrice(List<WebElement> prices) throws ParseException {
	    	
	    	list=new ArrayList<Integer>();
			for(WebElement value:prices)
			{
				System.out.println(value.getText());
				String money = value.getText();
				NumberFormat num = NumberFormat.getInstance();
				Number n = num.parse(money);
				String con = n.toString();
				int lowprice = Integer.parseInt(con);
				list.add(lowprice);

			}
		return Collections.min(list);
	}

		private void getDateSelected(List<WebElement> selectDay, String string) {
		for (WebElement e : selectDay) {
			String date = e.getAttribute("aria-label");
			System.out.println("Date:" + date);
			try {
				if (date.contains(string)) {
					e.click();
					break;
				}
			} catch (NullPointerException exe) {
				System.out.print("NullPointerException Caught");
			}

		}

	}

	private void getSelected(List<WebElement> list, String string) {
		for (WebElement e : list) {
			String City = e.getText();
			if (City.contains(string)) {
				e.click();
				break;
			}
		}

	}
	
	private void getTravelClassSelected(WebElement travelClass, String string) {
		select=new Select(travelClass);
		select.selectByVisibleText(string);
		
	}

	@After
	public void quitBrowser() {

		driver.quit();
	}

}
