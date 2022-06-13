/**
 * 
 */
package Com.MyStore.PageObjects;

import java.security.PublicKey;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.MyStore.ActionDriver.Action;
import Com.MyStore.Base.BaseClass;

public class OrderSummary extends BaseClass 
{
	public OrderSummary() 
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	Action action= new Action();
	
	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	private WebElement ConfirmOrderBtn;
	
	public OrderConfirmationPage ClickOnconfirmOrderBtn() throws Throwable 
	{
		action.Click(getDriver(), ConfirmOrderBtn);
		return new OrderConfirmationPage();
	}
	
}
