package warm_up;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automationpractice.utilities.CommonPage;
import com.automationpractice.utilities.DriverHelper;

public class HtmlFormPage extends CommonPage {

	//This class is Singleton
	//only one instance available for this object
	private static HtmlFormPage htmlFormPage;
	
	public static HtmlFormPage getHtmlFormPage ( WebDriver driver ) {
		if ( htmlFormPage == null ) htmlFormPage = new HtmlFormPage(driver);  
		return htmlFormPage;
	}
	
	private final int timeOutInSeconds = 15; 
	
	private DriverHelper driverHelper = getDriverHelper();
	
	private By firstNameTextBox = By.cssSelector("[placeholder='Your name..']");
	private By lastNameTextBox = By.id("lname");
	private By countryTextBox = By.name("country");
	private By subjectTextBox = By.id("subject");
	private By submitButton = By.cssSelector("[value='Submit']");
	
	private String htmlContactFormLocator = "HTML contact form";
	
	public HtmlFormPage(WebDriver driver) {
		super(driver);
	}

	public void clickHtmlContactFormLink () {
		driverHelper.clickByLinkText(htmlContactFormLocator, timeOutInSeconds);
	}
	
	public void enterFirstName( String fName ) {
		driverHelper.sendKeys(firstNameTextBox, fName, timeOutInSeconds);
	}

	public void enterLastName( String lName ) {
		driverHelper.sendKeys(lastNameTextBox, lName, timeOutInSeconds);
	}

	public void enterCountry( String country ) {
		driverHelper.sendKeys(countryTextBox, country, timeOutInSeconds);
	}

	public void enterSubject( String subject ) {
		driverHelper.sendKeys(subjectTextBox, subject, timeOutInSeconds);
	}
	
	public void clickSubmitButton () {
		driverHelper.click(submitButton, timeOutInSeconds);
	}
}