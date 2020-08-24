package objectsRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class goibiboObject {
	
	private WebDriver driver;

	public goibiboObject(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(id="gosuggest_inputSrc")
	WebElement fromCity;
	
	public WebElement fromCity()
	{
		return fromCity;
	}
	
	@FindBy(xpath="//ul[@role='listbox']//li")
	List<WebElement> fromlistBox;
	
	public List<WebElement> fromlistBox()
	{
		return fromlistBox;
	}
	
	@FindBy(id="gosuggest_inputDest")
	WebElement toCity;
	
	public WebElement toCity()
	{
		return toCity;
	}
	
	@FindBy(xpath="//ul[@role='listbox']//li")
	List<WebElement> tolistBox;
	
	public List<WebElement> tolistBox()
	{
		return tolistBox;
	}
	
	@FindBy(xpath="//*[contains(@class ,'DayPicker-Day')]")
	List<WebElement> selectCalenderDay;
	public List<WebElement> selectCalenderDay()
	{
		return selectCalenderDay;
	}
	
	
	@FindBy(css="div.DayPicker-Month > div.DayPicker-Caption")
	WebElement selectCalenderMonth;
	public WebElement selectCalenderMonth()
	{
		return selectCalenderMonth;
	}
	
	@FindBy(css=".DayPicker-NavButton.DayPicker-NavButton--next")
	WebElement clickNext;
	
	public WebElement clickNext()
	{
		return clickNext;
	}
	
	@FindBy(id="pax_link_common")
	WebElement TravellerDetails;
	
	public WebElement TravellerDetails()
	{
		return TravellerDetails;
	}
	
	@FindBy(id="gi_class")
	WebElement travelClass;
	
	public WebElement travelClass()
	{
		return travelClass;
	}
	
	@FindBy(id="gi_search_btn")
	WebElement Search;
	
	public WebElement Search()
	{
		return Search;
	}
	
	
	
	@FindBy(xpath="//*[contains(@class,'ico20 fb quicks')]")
	List<WebElement> price;
	
	public List<WebElement> price()
	{
		return price;
	}
	
	@FindBy(css=".button.fr.fltbook.fb.widthF105.fb.quicks")
	List<WebElement> bookTicket;
	
	public List<WebElement> bookTicket()
	{
		return bookTicket;
	}
	
	
	
	
	 
}
