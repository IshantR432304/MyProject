/**
 * 
 */
package Com.MyStore.PageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.MyStore.ActionDriver.Action;
import Com.MyStore.Base.BaseClass;

public class AccountCreationPage extends BaseClass 
{
	public AccountCreationPage() 
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	Action action= new Action();
	
	@FindBy(xpath = "//h1[text()='Create an account']")
	private WebElement FormTitle;
	
	@FindBy(id = "uniform-id_gender1")
	private WebElement Mr;
	
	@FindBy(id = "id_gender2")
	private WebElement Mrs;

	@FindBy(name = "customer_firstname")
	private WebElement FirstName;

	@FindBy(name = "customer_lastname")
	private WebElement LastName;

	@FindBy(name = "passwd")
	private WebElement PassWord;

	@FindBy(name = "days")
	private WebElement Days;

	@FindBy(name = "months")
	private WebElement Months;

	@FindBy(name = "years")
	private WebElement Years;

	@FindBy(name = "firstname")
	private WebElement CustomerFirstName;

	@FindBy(name = "lastname")
	private WebElement CustomerLastName;

	@FindBy(name = "company")
	private WebElement CompanyName;

	@FindBy(name = "address1")
	private WebElement Address;

	@FindBy(name = "city")
	private WebElement City;

	@FindBy(name = "id_state")
	private WebElement State;

	@FindBy(name = "postcode")
	private WebElement PostCode;

	@FindBy(name = "id_country")
	private WebElement Country;

	@FindBy(name = "phone")
	private WebElement Phone;

	@FindBy(name = "phone_mobile")
	private WebElement Mobile;

	@FindBy(name = "alias")
	private WebElement Ref;

	@FindBy(name = "submitAccount")
	private WebElement RegisterBtn;
	
	public void CreateAccount(String Gender,String FName, 
			String LName, 
			String Pswd, 
			String Day, 
			String Month, 
			String Year,
			String Company, 
			String Addr, 
			String CityString, 
			String StateName, 
			String Zip, 
			String CountryName,
			String MobilePhone) throws Throwable 
	{
		
		if(Gender.equalsIgnoreCase("Mr")) 
	{
			action.Click(getDriver(), Mr);
		} 
		else 
		{
			action.Click(getDriver(), Mrs);
		}
		
		action.Type(FirstName, FName);
		action.Type(LastName, LName);
		action.Type(PassWord, Pswd);
		action.SelectByValue(Days, Day);
		action.SelectByValue(Months, Month);
		action.SelectByValue(Years, Year);
		action.Type(CompanyName, Company);
		action.Type(Address, Addr);
		action.Type(City, CityString);
		action.SelectByVisibleText(StateName, State);
		action.Type(PostCode, Zip);
		action.SelectByVisibleText(CountryName, Country);
		action.Type(Mobile, MobilePhone);
	}
	
	public HomePage ValidateRegistration() throws Throwable 
	{
		RegisterBtn.click();
		return new HomePage();
	}
	
	public boolean ValidateAcountCreatePage() throws Throwable 
	{
		 return action.IsDisplayed(getDriver(), FormTitle);
	}
	
}
