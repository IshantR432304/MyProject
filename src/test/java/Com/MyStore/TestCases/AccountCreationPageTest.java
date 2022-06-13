package Com.MyStore.TestCases;
import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Com.MyStore.Base.BaseClass;
import Com.MyStore.DataProvider.DataProviders;
import Com.MyStore.PageObjects.AccountCreationPage;
import Com.MyStore.PageObjects.HomePage;
import Com.MyStore.PageObjects.IndexPage;
import Com.MyStore.PageObjects.LoginPage;
import Com.MyStore.Utilities.Log;
public class AccountCreationPageTest extends BaseClass 
{
	private IndexPage indexPage;
	private LoginPage loginPage;
	private AccountCreationPage acountCreationPage;
	private HomePage homePage;
	
	@Parameters("Browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void Setup(String Browser) 
	{
		LaunchApp(Browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void TearDown() 
	{
		getDriver().quit();
	}
	
	@Test(groups = "Sanity",dataProvider = "email", dataProviderClass = DataProviders.class)
	public void VerifyCreateAccountPageTest(String Email) throws Throwable 
	{
		Log.startTestCase("verifyCreateAccountPageTest");
		indexPage= new IndexPage();
		loginPage=indexPage.ClickOnSignIn();
		acountCreationPage=loginPage.CreateNewAccount(Email);
		boolean result=acountCreationPage.ValidateAcountCreatePage();
		Assert.assertTrue(result);
		Log.endTestCase("verifyCreateAccountPageTest");
	}
	
	@Test(groups = "Regression",dataProvider = "newAcountDetailsData",dataProviderClass = DataProviders.class)
	public void CreateAccountTest(HashMap<String,String> hashMapValue) throws Throwable 
	{
		Log.startTestCase("createAccountTest");
		indexPage= new IndexPage();
		loginPage=indexPage.ClickOnSignIn();
		acountCreationPage=loginPage.CreateNewAccount(hashMapValue.get("Email"));
		acountCreationPage.CreateAccount(
				hashMapValue.get("Gender"),
				hashMapValue.get("FirstName"),
				hashMapValue.get("LastName"),
				hashMapValue.get("SetPassword"),
				hashMapValue.get("Day"),
				hashMapValue.get("Month"),
				hashMapValue.get("Year"),
				hashMapValue.get("Company"),
				hashMapValue.get("Address"),
				hashMapValue.get("City"),
				hashMapValue.get("State"),
				hashMapValue.get("Zipcode"),
				hashMapValue.get("Country"),
				hashMapValue.get("MobilePhone"));
		homePage=acountCreationPage.ValidateRegistration();
		Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account", homePage.GetCurrURL());
		Log.endTestCase("createAccountTest");
	}

}
