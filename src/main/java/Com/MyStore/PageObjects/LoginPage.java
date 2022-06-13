/**
 * 
 */
package Com.MyStore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.MyStore.ActionDriver.Action;
import Com.MyStore.Base.BaseClass;

public class LoginPage extends BaseClass 
{
	public LoginPage() 
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	Action action= new Action();
	
	@FindBy(id="email")
	private WebElement UserName;
	
	@FindBy(id="passwd")
	private WebElement Password;

	@FindBy(id="SubmitLogin")
	private WebElement SignInBtn;
	
	@FindBy(name="email_create")
	private WebElement EmailForNewAccount;
	
	@FindBy(name="SubmitCreate")
	private WebElement CreateNewAccountBtn;
	
	public HomePage Login(String Uname, String Pswd,HomePage homePG) throws Throwable 
	{
		action.ScrollByVisibilityOfElement(getDriver(), UserName);
		action.Type(UserName, Uname);
		action.Type(Password, Pswd);
		action.JSClick(getDriver(), SignInBtn);
		Thread.sleep(2000);
		homePG=new HomePage();
		return homePG;
	}
	
	public AddressPage Login1(String Uname, String Pswd,AddressPage addressPG) throws Throwable 
	{
		action.ScrollByVisibilityOfElement(getDriver(), UserName);
		action.Type(UserName, Uname);
		action.Type(Password, Pswd);
		action.Click(getDriver(), SignInBtn);
		Thread.sleep(2000);
		addressPG=new AddressPage();
		return addressPG;
	}
	
	public AccountCreationPage CreateNewAccount(String NewEmail) throws Throwable 
	{
		action.Type(EmailForNewAccount, NewEmail);
		action.Click(getDriver(), CreateNewAccountBtn);
		return new AccountCreationPage();
	}
	
}






