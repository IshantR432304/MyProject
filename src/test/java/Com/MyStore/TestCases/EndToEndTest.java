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
import Com.MyStore.PageObjects.AddressPage;
import Com.MyStore.PageObjects.IndexPage;
import Com.MyStore.PageObjects.LoginPage;
import Com.MyStore.PageObjects.OrderConfirmationPage;
import Com.MyStore.PageObjects.OrderPage;
import Com.MyStore.PageObjects.OrderSummary;
import Com.MyStore.PageObjects.PaymentPage;
import Com.MyStore.PageObjects.SearchResultPage;
import Com.MyStore.PageObjects.ShippingPage;
import Com.MyStore.Utilities.Log;
public class EndToEndTest extends BaseClass 
{
	
	private IndexPage index;
	private SearchResultPage searchResultPage;
	private AddToCartPage addToCartPage;
	private OrderPage orderPage;
	private LoginPage loginPage;
	private AddressPage addressPage;
	private ShippingPage shippingPage;
	private PaymentPage paymentPage;
	private OrderSummary orderSummary;
	private OrderConfirmationPage orderConfirmationPage;

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
	public void EndToEndTest(String ProductName, String Qty, String Size) throws Throwable 
	{
		Log.startTestCase("endToEndTest");
		index= new IndexPage();
		searchResultPage=index.SearchProduct(ProductName);
		addToCartPage=searchResultPage.ClickOnProduct();
		addToCartPage.EnterQuantity(Qty);
		addToCartPage.SelectSize(Size);
		addToCartPage.ClickOnAddToCart();
		orderPage=addToCartPage.ClickOnCheckOut();
		loginPage=orderPage.ClickOnCheckOut();
		addressPage=loginPage.Login1(prop.getProperty("username"), prop.getProperty("password"),addressPage);
		shippingPage=addressPage.clickOnCheckOut();
		shippingPage.checkTheTerms();
		paymentPage=shippingPage.ClickOnProceedToCheckOut();
		orderSummary=paymentPage.ClickOnPaymentMethod();
		orderConfirmationPage=orderSummary.ClickOnconfirmOrderBtn();
		String actualMessage=orderConfirmationPage.ValidateConfirmMessage();
		String expectedMsg="Your order on My Store is complete.";
		Assert.assertEquals(actualMessage, expectedMsg);
		Log.endTestCase("endToEndTest");
	}

}
