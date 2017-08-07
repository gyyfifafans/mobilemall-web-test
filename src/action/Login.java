package action;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import Page.PageLogin;
import Page.PageMain;

public class Login {
	
	public Login(RemoteWebDriver driver,String username,String password){
		PageLogin p = new PageLogin(driver);
		PageMain p1 = new PageMain(driver);
		try{
		    driver.get("http://mobiletest.ehaier.com:58082/mobile/member/toMemberLogin.html");
		}
		catch (Exception e){
			System.out.println("Error：网络异常");
		}
		WebElement e1 = driver.findElement(p.get("mobileNum"));
		WebElement e2 = driver.findElement(p.get("password"));
		WebElement e3 = driver.findElement(p.get("login"));
		p.dealPresent(e1, driver);
		p.dealPresent(e2, driver);
		p.dealPresent(e3, driver);
		e1.clear();
		e2.clear();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		e1.sendKeys(username);
		e2.sendKeys(password);
		e3.click();
		WebElement e4 = driver.findElement(p1.get("personal"));
		p1.dealPresent(e4, driver);
		driver.get("http://mobiletest.ehaier.com:58082");
		//System.out.println("loginsessionid:"+(driver.getSessionId()).toString());
		System.out.println("登录成功");
	}
	public static void main(String[]args){
		
	}

}
