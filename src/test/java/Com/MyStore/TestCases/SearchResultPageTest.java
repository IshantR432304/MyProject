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
import Com.MyStore.PageObjects.IndexPage;
import Com.MyStore.PageObjects.SearchResultPage;
import Com.MyStore.Utilities.Log;
public class SearchResultPageTest extends BaseClass 
{
	private IndexPage index;
	private SearchResultPage searchResultPage;
	
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
	
	@Test(groups = "Smoke",dataProvider = "searchProduct", dataProviderClass = DataProviders.class)
	public void ProductAvailabilityTest(String ProductName) throws Throwable 
	{
		Log.startTestCase("productAvailabilityTest");
		index= new IndexPage();
		searchResultPage=index.SearchProduct(ProductName);
		boolean result=searchResultPage.IsProductAvailable();
		Assert.assertTrue(result);
		Log.endTestCase("productAvailabilityTest");
	}

}
