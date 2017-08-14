package WapPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import junit.framework.Assert;
import module.ScreenShot;
import util.CleanProcess;
import org.apache.log4j.*;


public class PageLogin extends WapPage{
	//log配置
	public Logger log = Logger.getLogger(PageLogin.class);
	private By mobileNum_loc;
	private By password_loc;
	private By loginButton_loc;
	private By registerButton_loc;

	public PageLogin(RemoteWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		mobileNum_loc = By.id("mobileNum");
		password_loc = By.name("password");
		loginButton_loc = By.id("memberLogin");
		
	}

	@Override
	public By get(String loc) {
		// TODO Auto-generated method stub
		switch (loc){
		case "mobileNum":
			return mobileNum_loc;
		case "password":
			return password_loc;
		case "login":
			return loginButton_loc;
		}
		return null;
	}
	
	
	public static void main(String[]args){
		System.setProperty("phantomjs.binary.path", "E:\\driver\\phantomjs.exe");
		DesiredCapabilities caps =new DesiredCapabilities();
		caps.setCapability("takeScreenshot", true);
		RemoteWebDriver driver = new PhantomJSDriver(caps);
		PageLogin p = new PageLogin(driver);
		PageMain p1 = new PageMain(driver);
		driver.get("http://mobiletest.ehaier.com:58082/mobile/member/toMemberLogin.html");
		WebElement e1 = driver.findElement(p.get("mobileNum"));
		WebElement e2 = driver.findElement(p.get("password"));
		WebElement e3 = driver.findElement(p.get("login"));
		p.dealPresent(e1, driver);
		p.log.info("用户名输出框正常显示");
		p.dealPresent(e2, driver);
		p.log.info("密码输入框正常显示");
		p.dealPresent(e3, driver);
		p.log.info("登录按钮正常显示");
		
		e1.clear();
		e2.clear();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		e1.sendKeys("13313313313");
		e2.sendKeys("222222");
		e3.click();
		
		WebElement e4 = driver.findElement(p1.get("personal"));
		p1.dealPresent(e4, driver);
		ScreenShot.takeScreenShot(driver);
		driver.get("http://mobiletest.ehaier.com:58082");
		ScreenShot.takeScreenShot(driver);
		driver.close();
		System.out.println("close");
		CleanProcess.main(null);
	
	}
	

}
