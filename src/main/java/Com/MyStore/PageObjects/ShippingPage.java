/**
 * 
 */
package Com.MyStore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.MyStore.ActionDriver.Action;
import Com.MyStore.Base.BaseClass;

public class ShippingPage extends BaseClass 
{
	public ShippingPage() 
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	Action action= new Action();
	
	@FindBy(id="cgv")
	private WebElement Terms;
	
	@FindBy(xpath="//button/span[contains(text(),'Proceed to checkout')]")
	private WebElement ProceedToCheckOutBtn;
	
	public void checkTheTerms() throws Throwable 
	{
		action.Click(getDriver(), Terms);
	}
	
	public PaymentPage ClickOnProceedToCheckOut() throws Throwable 
	{
		action.Click(getDriver(), ProceedToCheckOutBtn);
		return new PaymentPage();
	}

}
