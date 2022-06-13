/**
 * 
 */
package Com.MyStore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.MyStore.ActionDriver.Action;
import Com.MyStore.Base.BaseClass;

public class OrderConfirmationPage extends BaseClass
{
	public OrderConfirmationPage() 
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	Action action= new Action();
	
	@FindBy(xpath="//p/strong[contains(text(),'Your order on My Store is complete.')]")
	private WebElement ConfirmMessag;
	
	public String ValidateConfirmMessage() 
	{
		String ConfirmMsg=ConfirmMessag.getText();
		return ConfirmMsg;
	}

	
}
