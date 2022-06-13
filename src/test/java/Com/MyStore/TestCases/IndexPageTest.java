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
import Com.MyStore.PageObjects.IndexPage;
import Com.MyStore.Utilities.Log;
public class IndexPageTest extends BaseClass
{
	private IndexPage indexPage;

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

	@Test(groups = "Smoke")
	public void VerifyLogo() throws Throwable 
	{
		Log.startTestCase("verifyLogo");
		indexPage= new IndexPage();
		boolean result=indexPage.ValidateLogo();
		Assert.assertTrue(result);
		Log.endTestCase("verifyLogo");
	}

	@Test(groups = "Smoke")
	public void VerifyTitle() 
	{
		Log.startTestCase("verifyTitle");
		String actTitle=indexPage.GetMyStoreTitle();
		Assert.assertEquals(actTitle, "My Store");
		Log.endTestCase("verifyTitle");
	}


}
