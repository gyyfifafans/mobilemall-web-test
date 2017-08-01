package module;

import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/*数据初始化
1.检查商品库存
2.创建优惠券、H码、下单立减、订单满减、分期（花呗、建行）
3.检查商品是否包含套装等
4.地址选定
5.使用phantomJS不打开浏览器

 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */




public  class InitSetup
{
	
	public void checkStock(){
		
	}
	/*
	public DesiredCapabilities IosInitSetupCFG(DesiredCapabilities capabilities) throws MalformedURLException
	{  // set up appium
		final File appDir = new File(System.getProperty("user.dir"), "app");
		final File app = new File(appDir,Config.getInstance().getCfg("appDir"));
		//final DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformVersion", Config.getInstance().getCfg("platformVersion"));
		capabilities.setCapability("platformName", Config.getInstance().getCfg("platformName"));
		capabilities.setCapability("deviceName", Config.getInstance().getCfg("deviceName"));
		capabilities.setCapability("udid",Config.getInstance().getCfg("udid"));
		capabilities.setCapability("app", Config.getInstance().getCfg("app"));
        return capabilities;
	}	
	
	public DesiredCapabilities InitSetupCFG(final DesiredCapabilities capabilities) throws MalformedURLException
	{  // set up appium
		if(Config.CONFIG_FILE.equals("android_config.properties"))
		{
			final File appDir = new File(System.getProperty("user.dir"), "app");
			final File app = new File(appDir, Config.getInstance().getCfg("appDir"));
			// final DesiredCapabilities capabilities = new
			// DesiredCapabilities();
			capabilities.setCapability("app", Config.getInstance().getCfg("app"));
			capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
			capabilities.setCapability("platformVersion", Config.getInstance().getCfg("platformVersion"));
			capabilities.setCapability("platformName", Config.getInstance().getCfg("platformName"));
			capabilities.setCapability("deviceName", Config.getInstance().getCfg("deviceName"));
			// capabilities.setCapability("app", app.getAbsolutePath());
			capabilities.setCapability("appPackage", Config.getInstance().getCfg("appPackage"));
			capabilities.setCapability("appActivity", Config.getInstance().getCfg("appActivity"));
			capabilities.setCapability("unicodeKeyboard", Config.getInstance().getCfg("unicodeKeyboard"));
			capabilities.setCapability("resetKeyboard", Config.getInstance().getCfg("resetKeyboard"));
			capabilities.setCapability("newCommandTimeout", Config.getInstance().getCfg("newCommandTimeout"));
		}
		else if(Config.CONFIG_FILE.equals("ios_config.properties"))
		{
			final File appDir = new File(System.getProperty("user.dir"), "app");
			final File app = new File(appDir,Config.getInstance().getCfg("appDir"));
			//final DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("platformVersion", Config.getInstance().getCfg("platformVersion"));
			capabilities.setCapability("platformName", Config.getInstance().getCfg("platformName"));
			capabilities.setCapability("deviceName", Config.getInstance().getCfg("deviceName"));
			capabilities.setCapability("udid",Config.getInstance().getCfg("udid"));
			capabilities.setCapability("app", Config.getInstance().getCfg("app"));
	        return capabilities;
		}
		return capabilities;
	}
	
	
	public void TearDownCFG(AppiumDriver driver) throws MalformedURLException
	{
		driver.quit();	   
	}
	*/
}
