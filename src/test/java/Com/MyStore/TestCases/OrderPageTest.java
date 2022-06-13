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
import Com.MyStore.PageObjects.OrderPage;
import Com.MyStore.PageObjects.SearchResultPage;
import Com.MyStore.Utilities.Log;
public class OrderPageTest extends BaseClass 
{

	private IndexPage index;
	private SearchResultPage searchResultPage;
	private AddToCartPage addToCartPage;
	private OrderPage orderPage;

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

	@Test(groups = "Regression",dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void VerifyTotalPrice(String ProductName, String Qty, String Size) throws Throwable 
	{
		Log.startTestCase("verifyTotalPrice");
		index= new IndexPage();
		searchResultPage=index.SearchProduct(ProductName);
		addToCartPage=searchResultPage.ClickOnProduct();
		addToCartPage.EnterQuantity(Qty);
		addToCartPage.SelectSize(Size);
		addToCartPage.ClickOnAddToCart();
		orderPage=addToCartPage.ClickOnCheckOut();
		Double unitPrice=orderPage.GetUnitPrice();
		Double totalPrice=orderPage.GetTotalPrice();
		Double totalExpectedPrice=(unitPrice*(Double.parseDouble(Qty)))+2;
		Assert.assertEquals(totalPrice, totalExpectedPrice);
		Log.endTestCase("verifyTotalPrice");
	}
}
