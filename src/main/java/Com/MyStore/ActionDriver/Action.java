/**
 * 
 */
package Com.MyStore.ActionDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import Com.MyStore.ActionInterface.ActionInterface;
import Com.MyStore.Base.BaseClass;

public class Action extends BaseClass implements ActionInterface 
{

	@Override
	public void ScrollByVisibilityOfElement(WebDriver driver, WebElement Ele) 
	{
		JavascriptExecutor Js = (JavascriptExecutor) driver;
		Js.executeScript("arguments[0].scrollIntoView();", Ele);

	}

	@Override
	public void Click(WebDriver driver, WebElement Ele) 
	{

		Actions Act = new Actions(driver);
		Act.moveToElement(Ele).click().build().perform();

	}

	@Override
	public boolean FindElement(WebDriver driver, WebElement Ele) 
	{
		boolean Flag = false;
		try 
		{
			Ele.isDisplayed();
			Flag = true;
		} 
		catch (Exception e) 
		{
			// System.out.println("Location not found: "+locatorName);
			Flag = false;
		} finally 
		{
			if (Flag) 
			{
				System.out.println("Successfully Found element at");

			} 
			else 
			{
				System.out.println("Unable to locate element at");
			}
		}
		return Flag;
	}

	@Override
	public boolean IsDisplayed(WebDriver driver, WebElement Ele) 
	{
		boolean Flag = false;
		Flag = FindElement(driver, Ele);
		if (Flag) 
		{
			Flag = Ele.isDisplayed();
			if (Flag) 
			{
				System.out.println("The element is Displayed");
			} 
			else 
			{
				System.out.println("The element is not Displayed");
			}
		} 
		else 
		{
			System.out.println("Not displayed ");
		}
		return Flag;
	}

	@Override
	public boolean IsSelected(WebDriver driver, WebElement Ele) 
	{
		boolean Flag = false;
		Flag = FindElement(driver, Ele);
		if (Flag) 
		{
			Flag = Ele.isSelected();
			if (Flag) 
			{
				System.out.println("The element is Selected");
			} 
			else 
			{
				System.out.println("The element is not Selected");
			}
		} 
		else 
		{
			System.out.println("Not selected ");
		}
		return Flag;
	}

	@Override
	public boolean IsEnabled(WebDriver driver, WebElement Ele) 
	{
		boolean Flag = false;
		Flag = FindElement(driver, Ele);
		if (Flag) 
		{
			Flag = Ele.isEnabled();
			if (Flag) 
			{
				System.out.println("The element is Enabled");
			} 
			else 
			{
				System.out.println("The element is not Enabled");
			}
		} 
		else 
		{
			System.out.println("Not Enabled ");
		}
		return Flag;
	}

	/**
	 * Type text at location
	 * 
	 * @param locatorName
	 * @param text
	 * @return - true/false
	 */
	@Override
	public boolean Type(WebElement Ele, String Text) 
	{
		boolean Flag = false;
		try 
		{
			Flag = Ele.isDisplayed();
			Ele.clear();
			Ele.sendKeys(Text);
			// logger.info("Entered text :"+text);
			Flag = true;
		} 
		catch (Exception e) 
		{
			System.out.println("Location Not found");
			Flag = false;
		} 
		finally 
		{
			if (Flag) 
			{
				System.out.println("Successfully entered value");
			} 
			else 
			{
				System.out.println("Unable to enter value");
			}

		}
		return Flag;
	}

	@Override
	public boolean SelectBySendkeys(String Value,WebElement Ele) 
	{
		boolean Flag = false;
		try 
		{
			Ele.sendKeys(Value);
			Flag = true;
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		} 
		finally 
		{
			if (Flag) 
			{
				System.out.println("Select value from the DropDown");		
			} 
			else 
			{
				System.out.println("Not Selected value from the DropDown");
				// throw new ElementNotFoundException("", "", "")
			}
		}
	}

	/**
	 * select value from DropDown by using selectByIndex
	 * 
	 * @param locator     : Action to be performed on element (Get it from Object
	 *                    repository)
	 * 
	 * @param index       : Index of value wish to select from dropdown list.
	 * 
	 * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
	 *                    Listbox etc..)
	 * 
	 */
	@Override
	public boolean SelectByIndex(WebElement Element, int Index) 
	{
		boolean Flag = false;
		try 
		{
			Select s = new Select(Element);
			s.selectByIndex(Index);
			Flag = true;
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		} 
		finally 
		{
			if (Flag)
			{
				System.out.println("Option selected by Index");
			} 
			else 
			{
				System.out.println("Option not selected by Index");
			}
		}
	}

	/**
	 * select value from DD by using value
	 * 
	 * @param locator     : Action to be performed on element (Get it from Object
	 *                    repository)
	 * 
	 * @param value       : Value wish to select from dropdown list.
	 * 
	 * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
	 *                    Listbox etc..)
	 */

	@Override
	public boolean SelectByValue(WebElement Element,String Value) 
	{
		boolean Flag = false;
		try 
		{
			Select s = new Select(Element);
			s.selectByValue(Value);
			Flag = true;
			return true;
		} 
		catch (Exception e)
		{
			return false;
		} 
		finally 
		{
			if (Flag) 
			{
				System.out.println("Option selected by Value");
			} 
			else 
			{
				System.out.println("Option not selected by Value");
			}
		}
	}

	/**
	 * select value from DropDown by using selectByVisibleText
	 * 
	 * @param locator     : Action to be performed on element (Get it from Object
	 *                    repository)
	 * 
	 * @param visibletext : VisibleText wish to select from dropdown list.
	 * 
	 * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
	 *                    Listbox etc..)
	 */

	@Override
	public boolean SelectByVisibleText(String Visibletext, WebElement Ele) 
	{
		boolean Flag = false;
		try 
		{
			Select s = new Select(Ele);
			s.selectByVisibleText(Visibletext);
			Flag = true;
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		} 
		finally 
		{
			if (Flag)
			{
				System.out.println("Option selected by VisibleText");
			} 
			else 
			{
				System.out.println("Option not selected by VisibleText");
			}
		}
	}

	@Override
	public boolean MouseHoverByJavaScript(WebElement Ele) 
	{
		boolean Flag = false;
		try 
		{
			WebElement Mo = Ele;
			String javaScript = "var evObj = document.createEvent('MouseEvents');"
					+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
					+ "arguments[0].dispatchEvent(evObj);";
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(javaScript, Mo);
			Flag = true;
			return true;
		}

		catch (Exception e) 
		{
			return false;
		} 
		finally 
		{
			if (Flag) 
			{
				System.out.println("MouseOver Action is performed");
			} 
			else 
			{
				System.out.println("MouseOver Action is not performed");
			}
		}
	}

	@Override
	public boolean JSClick(WebDriver driver, WebElement Ele) 
	{
		boolean Flag = false;
		try 
		{
			// WebElement element = driver.findElement(locator);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", Ele);
			// driver.executeAsyncScript("arguments[0].click();", element);

			Flag = true;

		}

		catch (Exception e) 
		{
			throw e;

		} finally 
		{
			if (Flag) 
			{
				System.out.println("Click Action is performed");
			} 
			else if (!Flag) 
			{
				System.out.println("Click Action is not performed");
			}
		}
		return Flag;
	}

	@Override
	public boolean SwitchToFrameByIndex(WebDriver driver,int Index) 
	{
		boolean Flag = false;
		try 
		{
			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
			driver.switchTo().frame(Index);
			Flag = true;
			return true;
		} 
		catch (Exception e)
		{
			return false;
		} 
		finally 
		{
			if (Flag) 
			{
				System.out.println("Frame with index \"" + Index + "\" is selected");
			} 
			else 
			{
				System.out.println("Frame with index \"" + Index + "\" is not selected");
			}
		}
	}

	/**
	 * This method switch the to frame using frame ID.
	 * 
	 * @param idValue : Frame ID wish to switch
	 * 
	 */
	@Override
	public boolean SwitchToFrameById(WebDriver driver,String IdValue) 
	{
		boolean Flag = false;
		try 
		{
			driver.switchTo().frame(IdValue);
			Flag = true;
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		} 
		finally 
		{
			if (Flag) 
			{
				System.out.println("Frame with Id \"" + IdValue + "\" is selected");
			} 
			else 
			{
				System.out.println("Frame with Id \"" + IdValue + "\" is not selected");
			}
		}
	}

	/**
	 * This method switch the to frame using frame Name.
	 * 
	 * @param nameValue : Frame Name wish to switch
	 * 
	 */
	@Override
	public boolean SwitchToFrameByName(WebDriver driver,String NameValue) 
	{
		boolean Flag = false;
		try
		{
			driver.switchTo().frame(NameValue);
			Flag = true;
			return true;
		} 
		catch (Exception e)
		{
			return false;
		} 
		finally 
		{
			if (Flag) 
			{
				System.out.println("Frame with Name \"" + NameValue + "\" is selected");
			} 
			else if (!Flag) 
			{
				System.out.println("Frame with Name \"" + NameValue + "\" is not selected");
			}
		}
	}

	@Override
	public boolean SwitchToDefaultFrame(WebDriver driver) 
	{
		boolean Flag = false;
		try
{
			driver.switchTo().defaultContent();
			Flag = true;
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		} 
		finally 
		{
			if (Flag) 
			{
				// SuccessReport("SelectFrame ","Frame with Name is selected");
			} else if (!Flag) 
			{
				// failureReport("SelectFrame ","The Frame is not selected");
			}
		}
	}

	@Override
	public void MouseOverElement(WebDriver driver,WebElement Element) 
	{
		boolean Flag = false;
		try 
		{
			new Actions(driver).moveToElement(Element).build().perform();
			Flag = true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			if (Flag) 
			{
				System.out.println(" MouserOver Action is performed on ");
			} 
			else 
			{
				System.out.println("MouseOver action is not performed on");
			}
		}
	}

	@Override
	public boolean MoveToElement(WebDriver driver, WebElement Ele)
{
		boolean Flag = false;
		try {
			// WebElement element = driver.findElement(locator);
			JavascriptExecutor Executor = (JavascriptExecutor) driver;
			Executor.executeScript("arguments[0].scrollIntoView(true);", Ele);
			Actions actions = new Actions(driver);
			// actions.moveToElement(driver.findElement(locator)).build().perform();
			actions.moveToElement(Ele).build().perform();
			Flag = true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return Flag;
	}

	@Override
	public boolean Mouseover(WebDriver driver, WebElement Ele) 
	{
		boolean Flag = false;
		try 
		{
			new Actions(driver).moveToElement(Ele).build().perform();
			Flag = true;
			return true;
		} 
		catch (Exception e)
		{
			return false;
		} 
		finally 
		{
			/*
			 * if (flag) {
			 * SuccessReport("MouseOver ","MouserOver Action is performed on \""+locatorName
			 * +"\""); } else {
			 * failureReport("MouseOver","MouseOver action is not performed on \""
			 * +locatorName+"\""); }
			 */
		}
	}
	
	@Override
	public boolean Draggable(WebDriver driver,WebElement Source, int x, int y) 
	{
		boolean Flag = false;
		try 
		{
			new Actions(driver).dragAndDropBy(Source, x, y).build().perform();
			Thread.sleep(5000);
			Flag = true;
			return true;

		}
		catch (Exception e)
		{
			return false;
		} 
		finally 
		{
			if (Flag) 
			{
				System.out.println("Draggable Action is performed on \""+Source+"\"");			
			} 
			else if(!Flag)
			{
				System.out.println("Draggable action is not performed on \""+Source+"\"");
			}
		}
	}
	
	@Override
	public boolean Draganddrop(WebDriver driver,WebElement Source, WebElement Target) 
	{
		boolean Flag = false;
		try 
		{
			new Actions(driver).dragAndDrop(Source, Target).perform();
			Flag = true;
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		} 
		finally 
		{
			if (Flag) 
			{
				System.out.println("DragAndDrop Action is performed");
			} 
			else if(!Flag)
			{
				System.out.println("DragAndDrop Action is not performed");
			}
		}
	}
	
	@Override
	public boolean Slider(WebDriver driver,WebElement Ele, int x, int y) 
	{
		boolean Flag = false;
		try 
		{
			// new Actions(driver).dragAndDropBy(dragitem, 400, 1).build()
			// .perform();
			new Actions(driver).dragAndDropBy(Ele, x, y).build().perform();// 150,0
			Thread.sleep(5000);
			Flag = true;
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		} 
		finally 
		{
			if (Flag) 
			{
				System.out.println("Slider Action is performed");
			} 
			else 
			{
				System.out.println("Slider Action is not performed");
			}
		}
	}
	
	@Override
	public boolean Rightclick(WebDriver driver,WebElement Ele)
	{
		boolean Flag = false;
		try 
		{
			Actions clicker = new Actions(driver);
			clicker.contextClick(Ele).perform();
			Flag = true;
			return true;
			// driver.findElement(by1).sendKeys(Keys.DOWN);
		} 
		catch (Exception e) 
		{
			return false;
		} 
		finally 
		{
			if (Flag)
			{
				System.out.println("RightClick Action is performed");
			} 
			else 
			{
				System.out.println("RightClick Action is not performed");
			}
		}
	}
	
	@Override
	public boolean SwitchWindowByTitle(WebDriver driver,String WindowTitle, int Count) 
	{
		boolean Flag = false;
		try 
		{
			Set<String> WindowList = driver.getWindowHandles();

			String[] Array = WindowList.toArray(new String[0]);

			driver.switchTo().window(Array[Count-1]);

			if (driver.getTitle().contains(WindowTitle))
			{
				Flag = true;
			}
			else
			{
				Flag = false;
			}
			return Flag;
		} 
		catch (Exception e) 
		{
			//flag = true;
			return false;
		} 
		finally 
		{
			if (Flag)
			{
				System.out.println("Navigated to the window with title");
			} 
			else 
			{
				System.out.println("The Window with title is not Selected");
			}
		}
	}
	
	@Override
	public boolean SwitchToNewWindow(WebDriver driver) 
	{
		boolean Flag = false;
		try 
		{

			Set<String> s=driver.getWindowHandles();
			Object popup[]=s.toArray();
			driver.switchTo().window(popup[1].toString());
			Flag = true;
			return Flag;
		} 
		catch (Exception e) 
		{
			Flag = false;
			return Flag;
		} 
		finally 
		{
			if (Flag) 
			{
				System.out.println("Window is Navigated with title");				
			} 
			else 
			{
				System.out.println("The Window with title: is not Selected");
			}
		}
	}
	
	@Override
	public boolean SwitchToOldWindow(WebDriver driver) 
	{
		boolean Flag = false;
		try 
		{
			Set<String> s=driver.getWindowHandles();
			Object popup[]=s.toArray();
			driver.switchTo().window(popup[0].toString());
			Flag = true;
			return Flag;
		} 
		catch (Exception e) 
		{
			Flag = false;
			return Flag;
		} 
		finally 
		{
			if (Flag) 
			{
				System.out.println("Focus navigated to the window with title");			
			} 
			else 
			{
				System.out.println("The Window with title: is not Selected");
			}
		}
	}
	
	@Override
	public int GetColumncount(WebElement Row) 
	{
		List<WebElement> Columns =Row.findElements(By.tagName("td"));
		int a = Columns.size();
		System.out.println(Columns.size());
		for (WebElement Column : Columns) 
		{
			System.out.print(Column.getText());
			System.out.print("|");
		}
		return a;
	}
	
	@Override
	public int GetRowCount(WebElement Table) 
	{
		List<WebElement>Rows = Table.findElements(By.tagName("tr"));
		int a = Rows.size() - 1;
		return a;
	}
	
	
	/**
	 * Verify alert present or not
	 * 
	 * @return: Boolean (True: If alert preset, False: If no alert)
	 * 
	 */
	@Override
	public boolean Alert(WebDriver driver) 
	{
		boolean presentFlag = false;
		Alert alert = null;

		try 
		{
			// Check the presence of alert
			alert = driver.switchTo().alert();
			// if present consume the alert
			alert.accept();
			presentFlag = true;
		} 
		catch (NoAlertPresentException ex) 
		{
			// Alert present; set the flag

			// Alert not present
			ex.printStackTrace();
		} 
		finally 
		{
			if (!presentFlag) 
			{
				System.out.println("The Alert is handled successfully");		
			} 
			else
			{
				System.out.println("There was no alert to handle");
			}
		}

		return presentFlag;
	}
	
	@Override
	public boolean LaunchUrl(WebDriver driver,String Url) 
	{
		boolean Flag = false;
		try 
		{
			driver.navigate().to(Url);
			Flag = true;
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		} 
		finally 
		{
			if (Flag) 
			{
				System.out.println("Successfully launched \""+Url+"\"");				
			} 
			else
			{
				System.out.println("Failed to launch \""+Url+"\"");
			}
		}
	}
	
	@Override
	public boolean IsAlertPresent(WebDriver driver) 
	{ 
		try 
		{ 
			driver.switchTo().alert(); 
			return true; 
		}   // try 
		catch (NoAlertPresentException Ex) 
		{ 
			return false; 
		}   // catch 
	}
	
	@Override
	public String GetTitle(WebDriver driver) 
	{
		boolean Flag = false;
		String Text = driver.getTitle();
		if (Flag) 
		{
			System.out.println("Title of the page is: \""+Text+"\"");
		}
		return Text;
	}
	
	@Override
	public String GetCurrentURL(WebDriver driver)  
	{
		boolean Flag = false;

		String Text = driver.getCurrentUrl();
		if (Flag) 
		{
			System.out.println("Current URL is: \""+Text+"\"");
		}
		return Text;
	}
	
	@Override
	public boolean Click1(WebElement Locator, String LocatorName) 
	{
		boolean Flag = false;
		try 
		{
			Locator.click();
			Flag = true;
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		} 
		finally 
		{
			if (Flag) 
			{
				System.out.println("Able to click on \""+LocatorName+"\"");
			} 
			else
			{
				System.out.println("Click Unable to click on \""+LocatorName+"\"");
			}
		}

	}
	
	@Override
	public void FluentWait(WebDriver driver,WebElement Element, int TimeOut) 
	{
	    Wait<WebDriver> wait = null;
	    try 
	    {
	        wait = new FluentWait<WebDriver>((WebDriver) driver)
	        		.withTimeout(Duration.ofSeconds(20))
	        	    .pollingEvery(Duration.ofSeconds(2))
	        	    .ignoring(Exception.class);
	        wait.until(ExpectedConditions.visibilityOf(Element));
	        Element.click();
	    }
	    catch(Exception e) 
	    {
	    }
	}
	
	@Override
	public void ImplicitWait(WebDriver driver, int TimeOut) 
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Override
	public void ExplicitWait(WebDriver driver, WebElement Element, int TimeOut ) 
	{
		WebDriverWait wait = new WebDriverWait(driver,TimeOut);
		wait.until(ExpectedConditions.visibilityOf(Element));
	}
	
	@Override
	public void PageLoadTimeOut(WebDriver driver, int TimeOut) 
	{
		driver.manage().timeouts().pageLoadTimeout(TimeOut, TimeUnit.SECONDS);
	}
	
	@Override
	public String ScreenShot(WebDriver driver, String Filename) 
	{
		String DateName = new SimpleDateFormat("yyyyMMdd"+"  "+"hhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File Source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String Destination = System.getProperty("user.dir") + "\\ScreenShots\\" + Filename + "_" + DateName + ".png";

		try 
		{
			FileUtils.copyFile(Source, new File(Destination));
		} 
		catch (Exception e) 
		{
			e.getMessage();
		}
		// This new path for jenkins
		String NewImageString = "http://localhost:8082/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" + Filename + "_"
				+ DateName + ".png";
		return NewImageString;
	}
	
	@Override
	public String GetCurrentTime() 
	{
		String CurrentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return CurrentDate;
	}

}
