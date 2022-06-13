/**
 * 
 */
package Com.MyStore.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Com.MyStore.Base.BaseClass;
import Com.MyStore.DataProvider.DataProviders;
import Com.MyStore.PageObjects.HomePage;
import Com.MyStore.PageObjects.IndexPage;
import Com.MyStore.PageObjects.LoginPage;
import Com.MyStore.Utilities.Log;
public class HomePageTest extends BaseClass 
{
	private IndexPage indexPage;
	private LoginPage loginPage;
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
	
	@Test(groups = "Smoke",dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void WishListTest(String Uname, String Pswd) throws Throwable {
		Log.startTestCase("wishListTest");
		indexPage= new IndexPage();
		loginPage=indexPage.ClickOnSignIn();
		homePage=loginPage.Login(Uname,Pswd,homePage);
		boolean result=homePage.ValidateMyWishList();
		Assert.assertTrue(result);
		Log.endTestCase("wishListTest");
	}
	
	@Test(groups = "Smoke",dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void OrderHistoryandDetailsTest(String Uname, String Pswd) throws Throwable 
	{
		Log.startTestCase("orderHistoryandDetailsTest");
		indexPage= new IndexPage();
		loginPage=indexPage.ClickOnSignIn();
		homePage=loginPage.Login(Uname,Pswd,homePage);
		boolean result=homePage.ValidateOrderHistory();
		Assert.assertTrue(result);
		Log.endTestCase("orderHistoryandDetailsTest");
	}
	
}
