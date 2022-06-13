/**
 * 
 */
package Com.MyStore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.MyStore.ActionDriver.Action;
import Com.MyStore.Base.BaseClass;

public class AddressPage extends BaseClass 
{
	public AddressPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	Action action= new Action();
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	private WebElement ProceedToCheckOut;
	
	public ShippingPage clickOnCheckOut() throws Throwable 
	{
		action.Click(getDriver(), ProceedToCheckOut);
		return new ShippingPage();
	}
	
}
