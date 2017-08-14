package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import WapPage.PageLogin;
import WapPage.PageMain;
import WapPage.PageOrder;
import WapPage.PageProduct;
import action.Login;
import module.ScreenShot;
import util.CleanProcess;

public class TestCase_1 {
	DesiredCapabilities caps= new DesiredCapabilities();
	RemoteWebDriver driver; 
	
	@BeforeClass(alwaysRun = true)
	public void setUp(){
		System.setProperty("phantomjs.binary.path","E:\\driver\\phantomjs.exe");
		caps.setCapability("takeScreenshot", true);
		driver = new PhantomJSDriver(caps);
		
		
		
	}
	
	@Test
	public void test_login(){
		PageLogin Login = new PageLogin(driver);
		PageMain p = new PageMain(driver);
		Login login = new Login(driver,"13313313313","222222");
		WebElement e = driver.findElement(p.get("personal"));
		ScreenShot.takeScreenShot(driver);
		Assert.assertTrue(e.isDisplayed());
		//Assert.assertEquals('a', 'b');
		//assertEquals

	}
	/*
	@Test
	public void test_order(){
		PageLogin Login = new PageLogin(driver);
		PageProduct p = new PageProduct(driver);
		PageOrder p1 = new PageOrder(driver);
		Login.Login(driver,"13313313313","222222");
		driver.get("http://mobiletest.ehaier.com:58082/product/5031.html");
		WebElement e5 = driver.findElement(p.get("buy"));
		WebElement e6 = driver.findElement(p1.get("submit"));
		WebElement e = driver.findElement(p.get("address"));
		p.dealPresent(e, driver);
		e.click();
		//ScreenShot.takeScreenShot(driver);
		WebElement e1 = driver.findElement(p.get("province"));
		p.dealPresent(e1, driver);
		//ScreenShot.takeScreenShot(driver);
		e1.click();
		WebElement e2 = driver.findElement(p.get("city"));
		p.dealPresent(e2, driver);
		//ScreenShot.takeScreenShot(driver);
		e2.click();
		WebElement e3 = driver.findElement(p.get("region"));
		p.dealPresent(e3, driver);
		//ScreenShot.takeScreenShot(driver);
		e3.click();
		WebElement e4 = driver.findElement(p.get("street"));
		p.dealPresent(e4, driver);
		//ScreenShot.takeScreenShot(driver);
		e4.click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS );
		//ScreenShot.takeScreenShot(driver);
		p.dealPresent(e5, driver);
		e5.click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS );
		ScreenShot.takeScreenShot(driver);
		p1.dealPresent(e6, driver);
		e6.click();
		
		
	}*/
	
	@AfterClass(alwaysRun = true)
	public void tearDown(){
		driver.close();
		System.out.println("finished");
		CleanProcess.main(null);
	}

	

}
