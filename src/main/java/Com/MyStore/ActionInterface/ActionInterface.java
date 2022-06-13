package Com.MyStore.ActionInterface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ActionInterface {
	
	//Added all user actions abstract methods to achieve Abstraction  
	public void ScrollByVisibilityOfElement(WebDriver driver, WebElement ele);
	public void Click(WebDriver ldriver, WebElement ele);
	public boolean IsDisplayed(WebDriver ldriver, WebElement ele);
	public boolean Type(WebElement ele, String text);
	public boolean FindElement(WebDriver ldriver, WebElement ele);
	public boolean IsSelected(WebDriver ldriver, WebElement ele);
	public boolean IsEnabled(WebDriver ldriver, WebElement ele);
	public boolean SelectBySendkeys(String value,WebElement ele);
	public boolean SelectByIndex(WebElement element, int index);
	public boolean SelectByValue(WebElement element,String value);
	public boolean SelectByVisibleText(String visibletext, WebElement ele);
	public boolean MouseHoverByJavaScript(WebElement locator);
	public boolean JSClick(WebDriver driver, WebElement ele);
	public boolean SwitchToFrameByIndex(WebDriver driver,int index);
	public boolean SwitchToFrameById(WebDriver driver,String idValue);
	public boolean SwitchToFrameByName(WebDriver driver,String nameValue);
	public boolean SwitchToDefaultFrame(WebDriver driver);
	public void MouseOverElement(WebDriver driver,WebElement element);
	public boolean MoveToElement(WebDriver driver, WebElement ele);
	public boolean Mouseover(WebDriver driver, WebElement ele);
	public boolean Draggable(WebDriver driver,WebElement source, int x, int y);
	public boolean Draganddrop(WebDriver driver,WebElement source, WebElement target);
	public boolean Slider(WebDriver driver,WebElement ele, int x, int y);
	public boolean Rightclick(WebDriver driver,WebElement ele);
	public boolean SwitchWindowByTitle(WebDriver driver,String windowTitle, int count);
	public boolean SwitchToNewWindow(WebDriver driver);
	public boolean SwitchToOldWindow(WebDriver driver);
	public int GetColumncount(WebElement row);
	public int GetRowCount(WebElement table);
	public boolean Alert(WebDriver driver);
	public boolean LaunchUrl(WebDriver driver,String url);
	public boolean IsAlertPresent(WebDriver driver);
	public String GetCurrentURL(WebDriver driver);
	public String GetTitle(WebDriver driver);
	public boolean Click1(WebElement locator, String locatorName);
	public void FluentWait(WebDriver driver,WebElement element, int timeOut);
	public void ImplicitWait(WebDriver driver, int timeOut);
	public void ExplicitWait(WebDriver driver, WebElement element, int timeOut);
	public void PageLoadTimeOut(WebDriver driver, int timeOut);
	public String ScreenShot(WebDriver driver, String filename);
	public String GetCurrentTime();

}
