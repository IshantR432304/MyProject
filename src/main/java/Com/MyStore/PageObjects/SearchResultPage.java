/**
 * 
 */
package Com.MyStore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.MyStore.ActionDriver.Action;
import Com.MyStore.Base.BaseClass;

public class SearchResultPage extends BaseClass 
{
	public SearchResultPage() 
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	Action action= new Action();
	
	@FindBy(xpath="//*[@id=\"center_column\"]//img")
	private WebElement ProductResult;
	
	public boolean IsProductAvailable() throws Throwable 
	{
		return action.IsDisplayed(getDriver(), ProductResult);
	}
	
	public AddToCartPage ClickOnProduct() throws Throwable 
	{
		action.Click(getDriver(), ProductResult);
		return new AddToCartPage();
	}
	
}
