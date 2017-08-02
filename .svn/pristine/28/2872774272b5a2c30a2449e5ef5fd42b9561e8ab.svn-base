package test;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

public class practice_test {
	public AppiumDriver driver;
	//private boolean isInstall = false;
	public void getTime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(new Date()));
	}
	public void getScreen(String name){
		//工程目录下
		String curPath = System.getProperty("user.dir");
		String path = curPath+"\\"+"screenshot";
		File scrfile = driver.getScreenshotAs(OutputType.FILE);
		try{
			FileUtils.copyFile(scrfile, new File(path+"\\"+name+".png"));
			System.out.println(path);
		}
		catch(IOException e){
			System.out.println("2");
			e.printStackTrace();
			
		}
		finally
		{
			System.out.println(3);
			
		}
	}
	//Map是接口，List是接口
	public Map<Integer,Integer> location(){
		Map<Integer,Integer> loc = new HashMap<Integer,Integer>();
		int height = driver.manage().window().getSize().height;//1080
		int width = driver.manage().window().getSize().width;//1080
		System.out.println("height:"+height+"  "+"width:"+width);
		loc.put(height, width);
		return loc;
	}
	
	
	
	public void switchToPage(){
		//H5和原生的切换
		Set <String> contextSet = driver.getContextHandles();
		for(String context : contextSet){
			System.out.println("页面上的context内容为"+context);
			if (context.toLowerCase().contains("webview")){
				//driver.context(context);
				//切换
				//switchTo感觉应该还有其他用处？？
				driver.switchTo();
				break;
			}
		}
	}
	
	@BeforeClass(alwaysRun = true)
	public void setUp()throws Exception{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "huawei-bln_al20_BTF4C17221007757");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.ehaier.shunguang");
		capabilities.setCapability("appActivity", "com.ehaier.shunguang.MainActivity");
		
		//
		capabilities.setCapability("sessionOverride", true);
		capabilities.setCapability("unicodeKeyBoard", true);
		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		//
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	
	}
	
	
	@Test
	public void testcase1()throws InterruptedException{
		System.out.println("in test case 1");
		
		//driver.findElementsById("");
		//WebElement nxtBtn = driver.findElementById("");
		//Assert.assertEquals(nxtBtn.isEnabled(),true);
		getTime();
		Thread.sleep(5000);
		//classname识别
		WebElement btn = driver.findElement(By.className("android.widget.Button"));
		Thread.sleep(2000);
		btn.click();
		getScreen("1");

		
		
		//H5和原生的切换
		switchToPage();
		
		System.out.println("页面内容为："+driver.getPageSource());
		/*
		//切换到webview后，用content-desc定位
		WebElement ntb = driver.findElementByAccessibilityId("马上选购");
		ntb.click();*/
		
		//坐标定位 ，switchTo到webview后没问题
		/*需要改成相对坐标，适应屏幕
		当前坐标 x1,y1
		当前屏幕尺寸 x2,y2
		测试机屏幕尺寸 x3,y3
		测试机坐标 x4,y4
		x4 = (x1/x2)*x3
		y4 = (y1/y2)*y3
		
		
		*/
		
		TouchAction touch = new TouchAction(driver);
		touch.tap(252,1486).perform();
		//立即开店 630,1419 1026,1554
		Thread.sleep(2000);
		getScreen("3");
		
		Map<Integer,Integer> loc = location();
		/*
		for (Map.Entry<Integer, Integer> entry :loc.entrySet()){
			System.out.println(entry.getValue()+"  "+entry.getValue());
		}*/
		getTime();
		//选择商品
		
		//坐标
		/*Thread.sleep(2000);
		switchToPage();
		touch.tap(990, 1541).perform();
		Thread.sleep(2000);
		getScreen("4");*/
		
		
		//xpath
		//832,996
		switchToPage();
		System.out.println("页面内容为："+driver.getPageSource());
		try{
		    WebElement elbtn = driver.findElementByXPath("//android.webkit.WebView[contains(@class,'col col-20 border-right padding-0 selection-tap')]");
		    elbtn.click();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		Thread.sleep(2000);
		getScreen("7");
		
		
		//滑动
		driver.swipe(255, 1523, 255, 746, 2000);
		Thread.sleep(2000);
		getScreen("5");
	}
	
	
	@AfterClass(alwaysRun = true)
	public void tearDown()throws Exception{
		driver.quit();
	}

}
