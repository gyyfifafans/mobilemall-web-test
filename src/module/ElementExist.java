package module;

//import junit.framework.Assert;
import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class ElementExist
{
	public static String result;
	
	public String waitForElementByXpath(final String ID, AppiumDriver driver)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 18);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ID)));
			if (null == wait)
			{
				ScreenShot.takeScreenShot(driver);
				result = "failed";
				Assert.assertTrue(false);
			} 
			else
			{
				result = "pass";
			}
			
		}catch(Exception e)
		{
			ScreenShot.takeScreenShot(driver);
			result = "failed";
			Assert.assertTrue(false);
		}
//		finally
//		{
//			return "failed";
//		}
		return result;
		
	}

	public String waitForElementByName(final String ID, AppiumDriver driver)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 18);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(ID)));
		//	System.out.println(ID);
			if (null == wait)
			{
				ScreenShot.takeScreenShot(driver);
				result = "failed";
				Assert.assertTrue(false);
			} 
			else
			{
				result = "pass";
			}
		} catch (Exception e)
		{
			ScreenShot.takeScreenShot(driver);
			result = "failed";
			System.out.print(result);
			Assert.assertTrue(false);
		}
//		finally
//		{
//			return "failed";
//		}
		return result;
	}
	
	public String waitForElementByNameSkip(final String ID, AppiumDriver driver)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 18);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(ID)));
			if (null == wait)
			{
				ScreenShot.takeScreenShot(driver);
				result = "failed";
			//	Assert.assertTrue(false);
			} 
			else
			{
				result = "pass";
			}
		} catch (Exception e)
		{
			ScreenShot.takeScreenShot(driver);
			result = "failed";
			Assert.assertTrue(false);
		}
//		finally
//		{
//			return "failed";
//		}
		return result;
	}

	public String waitForElementById(final String ID, AppiumDriver driver)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 18);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(ID)));
			if (null == wait)
			{
				ScreenShot.takeScreenShot(driver);
				result = "failed";
				Assert.assertTrue(false);
			} 
			else
			{
				result = "pass";
			}
			
		}catch(Exception e)
		{
			ScreenShot.takeScreenShot(driver);
			result = "failed";
			Assert.assertTrue(false);
		}
//		finally
//		{
//			return "failed";
//		}
		return result;
		
	}

}
