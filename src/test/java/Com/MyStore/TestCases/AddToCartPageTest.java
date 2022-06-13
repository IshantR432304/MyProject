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
import Com.MyStore.PageObjects.AddToCartPage;
import Com.MyStore.PageObjects.IndexPage;
import Com.MyStore.PageObjects.SearchResultPage;
import Com.MyStore.Utilities.Log;
public class AddToCartPageTest extends BaseClass 
{
	
	private IndexPage index;
	private SearchResultPage searchResultPage;
	private AddToCartPage addToCartPage;

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
	
	@Test(groups = {"Regression","Sanity"}, dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void AddToCartTest(String ProductName, String Qty, String Size) throws Throwable 
	{
		Log.startTestCase("addToCartTest");
		index= new IndexPage();
		searchResultPage=index.SearchProduct(ProductName);
		addToCartPage=searchResultPage.ClickOnProduct();
		addToCartPage.EnterQuantity(Qty);
		addToCartPage.SelectSize(Size);
		addToCartPage.ClickOnAddToCart();
		boolean result=addToCartPage.ValidateAddtoCart();
		Assert.assertTrue(result);
		Log.endTestCase("addToCartTest");
		
	}
}
