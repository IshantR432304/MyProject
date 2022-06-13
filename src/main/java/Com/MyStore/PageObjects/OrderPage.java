/**
 * 
 */
package Com.MyStore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.MyStore.ActionDriver.Action;
import Com.MyStore.Base.BaseClass;

public class OrderPage extends BaseClass 
{
	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	}

	Action action= new Action();
	
	@FindBy(xpath="//td[@class='cart_unit']/span/span")
	private WebElement UnitPrice;
	
	@FindBy(id="total_price")
	private WebElement TotalPrice;
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	private WebElement ProceedToCheckOut;
	
	
	public double GetUnitPrice()
	{
		String UnitPrice1=UnitPrice.getText();
		String Unit=UnitPrice1.replaceAll("[^a-zA-Z0-9]","");
		double FinalUnitPrice=Double.parseDouble(Unit);
		return FinalUnitPrice/100;
	}
	
	public double GetTotalPrice() 
	{
		String TotalPrice1=TotalPrice.getText();
		String Tot=TotalPrice1.replaceAll("[^a-zA-Z0-9]","");
		double FinalTotalPrice=Double.parseDouble(Tot);
		return FinalTotalPrice/100;
	}
	
	public LoginPage ClickOnCheckOut() throws Throwable 
	{
		action.Click(getDriver(), ProceedToCheckOut);
		return new LoginPage();
	}
	
}
