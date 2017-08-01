package Page;

import java.io.File;
import log.SelLogger;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import module.ScreenShot;

public class PageMain extends abstractPage{
	private By login_loc;
	private By exit_loc;
	private By register_loc;
	private By personal_loc;
	private By searchButton_loc;
	private By cart_loc;
	private By quickMenu_loc;
	private By Menu_loc;
	
	
	public PageMain(RemoteWebDriver driver){
		super(driver);
		login_loc = By.linkText("登录");
		register_loc = By.linkText("注册");
		personal_loc = By.linkText("我的海尔");
		exit_loc = By.linkText("退出");
		searchButton_loc = By.className("search");
		cart_loc = By.className("cart");
		quickMenu_loc = By.className("hotpot");
		Menu_loc = By.className("navbar");
	}
	
	
	public By get(String loc){
		switch (loc){
			case "login":
				return this.login_loc;
			case "exit":
				return this.exit_loc;
			case "register":
				return this.register_loc;
			case "personal":
				return this.personal_loc;
			case "search":
				return this.searchButton_loc;
			case "cart":
				return this.cart_loc;
			case "quickMenu":
				return this.quickMenu_loc;
			case "Menu":
				return this.Menu_loc;
		}
		return null;
	}
	
	
	
	public void slide(){
		
	}
	
	public static void main(String[]args) throws Exception{
		SelLogger log = new SelLogger();
		//System.setProperty("webdriver.chrome.driver", "E:\\driver\\chromedriver.exe");
		System.setProperty("phantomjs.binary.path", "E:\\driver\\phantomjs.exe");
		DesiredCapabilities dcaps = new DesiredCapabilities();
		dcaps.setCapability("takesScreenshot", true);
		RemoteWebDriver driver = new PhantomJSDriver(dcaps);
		
		
		PageMain p = new PageMain(driver);
		//WebDriver driver =new  ChromeDriver();
		//driver.get("http://www.baidu.com");
		//driver.close();
		
		driver.get("http://mobiletest.ehaier.com:58082");
		//try-catch
		WebElement login = driver.findElement(p.get("login"));
		login.click();
		ScreenShot.takeScreenShot(driver);
		//driver.manage().wait(1000);
		driver.close();
	}

}
