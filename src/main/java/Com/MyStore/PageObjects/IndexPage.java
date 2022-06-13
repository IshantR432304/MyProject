package Com.MyStore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Com.MyStore.ActionDriver.Action;
import Com.MyStore.Base.BaseClass;

public class IndexPage extends BaseClass 
{
	Action action= new Action();
	public IndexPage() 
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//a[@class='login']") 
	private WebElement SignInBtn;
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	private WebElement MyStoreLogo;
	
	@FindBy(id="search_query_top")
	private WebElement SearchProductBox;
	
	@FindBy(name="submit_search")
	private WebElement SearchButton;
	
	public LoginPage ClickOnSignIn() throws Throwable 
	{
		action.FluentWait(getDriver(), SignInBtn, 10);
		action.Click(getDriver(), SignInBtn);
		return new LoginPage();
	}
	
	public boolean ValidateLogo() throws Throwable 
	{
		return action.IsDisplayed(getDriver(), MyStoreLogo);
		
	}
	
	public String GetMyStoreTitle() 
	{
		String myStoreTitel=getDriver().getTitle();
		return myStoreTitel;
	}
	
	public SearchResultPage SearchProduct(String ProductName) throws Throwable 
	{
		action.Type(SearchProductBox, ProductName);
		action.ScrollByVisibilityOfElement(getDriver(), SearchButton);
		action.Click(getDriver(), SearchButton);
		Thread.sleep(3000);
		return new SearchResultPage();
	}

}
