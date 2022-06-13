/**
 * 
 */
package Com.MyStore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.MyStore.ActionDriver.Action;
import Com.MyStore.Base.BaseClass;

public class HomePage extends BaseClass 
{
	public HomePage() 
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	Action action= new Action();
	
	@FindBy(xpath="//span[text()='My wishlists']")
	private WebElement MyWishList;
	
	@FindBy(xpath = "//span[text()='Order history and details']")
	private WebElement OrderHistory;
	
	public boolean ValidateMyWishList() throws Throwable 
	{
		return action.IsDisplayed(getDriver(), MyWishList);
	}
	
	public boolean ValidateOrderHistory() throws Throwable 
	{
		return action.IsDisplayed(getDriver(), OrderHistory);
	}
	
	public String GetCurrURL() throws Throwable 
	{
		String HomePageURL=action.GetCurrentURL(getDriver());
		return HomePageURL;
	}
}
