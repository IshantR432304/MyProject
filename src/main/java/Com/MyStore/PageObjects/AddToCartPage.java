/**
 * 
 */
package Com.MyStore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.MyStore.ActionDriver.Action;
import Com.MyStore.Base.BaseClass;

public class AddToCartPage extends BaseClass 
{
	public AddToCartPage() 
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	Action action= new Action();
	
	@FindBy(id="quantity_wanted")
	private WebElement Quantity;
	
	@FindBy(name="group_1")
	private WebElement Size;
	
	@FindBy(xpath="//span[text()='Add to cart']")
	private WebElement AddToCartBtn;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]//h2/i")
	private WebElement AddToCartMessag;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	private WebElement ProceedToCheckOutBtn;
	
	public void EnterQuantity(String Quantity1) throws Throwable 
	{
		action.Type(Quantity, Quantity1);
	}
	
	public void SelectSize(String Size1) throws Throwable 
	{
		action.SelectByVisibleText(Size1, Size);
	}
	
	public void ClickOnAddToCart() throws Throwable 
	{
		action.Click(getDriver(), AddToCartBtn);
	}
	
	public boolean ValidateAddtoCart() throws Throwable 
	{
		action.FluentWait(getDriver(), AddToCartMessag, 10);
		return action.IsDisplayed(getDriver(), AddToCartMessag);
	}
	
	public OrderPage ClickOnCheckOut() throws Throwable 
	{
		action.FluentWait(getDriver(), ProceedToCheckOutBtn, 10);
		action.JSClick(getDriver(), ProceedToCheckOutBtn);
		return new OrderPage();
	}
	
}
