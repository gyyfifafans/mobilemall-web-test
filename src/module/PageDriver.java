package module;

import java.net.URL;

import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;

public class PageDriver {
	DesiredCapabilities caps = new DesiredCapabilities();
	RemoteWebDriver web_driver;
	AppiumDriver app_driver;
	
	public PageDriver(String come) throws Exception{
		switch(come){
		case "WEB":init_web();
			break;
		case "APP":init_app();
			break;
		}
	}
	
	public void init_web(){
		System.setProperty("phantomjs.binary.path", "E:\\driver\\phantomjs.exe");
		caps.setCapability("takeScreenshot", true);
		web_driver = new PhantomJSDriver(caps);
		
	}
	
	public void init_app() throws Exception{
		caps.setCapability("deviceName", "huawei-bln_al20_BTF4C17221007757");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.ehaier.shunguang");
		caps.setCapability("appActivity", "com.ehaier.shunguang.MainActivity");
		
		//
		caps.setCapability("sessionOverride", true);
		caps.setCapability("unicodeKeyBoard", true);
		app_driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
		
	}
	public static void main(String[]args){
		
	}
	

}
