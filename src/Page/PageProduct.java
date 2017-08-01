package Page;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.ini4j.ConfigParser.InterpolationException;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.FindBy;

import module.ScreenShot;
import util.CleanProcess;
import util.HttpRes;

public class PageProduct extends abstractPage{
	//@FindBy() 注解
	//重构findElement+dealPresent 0723
	//private WebElement a;
	private By buy_loc;
	private By cart_loc;
	private By address_loc;
	private By province_loc;
	private By city_loc;
	private By region_loc;
	private By street_loc;

	public PageProduct(RemoteWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		buy_loc = By.linkText("立即购买");
		cart_loc = By.linkText("加入购物车");
		address_loc = By.xpath("//a[@id='expressArea']/dl/dt");
		//适配全部区---后期
		province_loc = By.xpath("//ul[@id='areaList']/li[@id='li_province_2']");//北京
		city_loc = By.xpath("//ul[@id='areaList']/li[@id='li_city_716']");//北京
		region_loc = By.xpath("//ul[@id='areaList']/li[@id='li_region_944']");//海淀区
		street_loc = By.xpath("//ul[@id='areaList']/li[@id='li_street_12024719']");//羊坊店街道
	}

	@Override
	public By get(String loc) {
		// TODO Auto-generated method stub
		switch (loc){
		case "buy":
			return buy_loc;
		case "cart":
			return cart_loc;
		case "address":
			return address_loc;
		case "city":
			return city_loc;
		case "region":
			return region_loc;
		case "street":
			return street_loc;
		case "province":
			return province_loc;
		}
		return null;
	}
	
	public void ChooseAddress(String province,String city,String region,String street){
		//0723 to do---后期
		/*WebElement e = driver.findElement(p.get("address"));
		p.dealPresent(e, driver);
		e.click();
		ScreenShot.takeScreenShot(driver);
		WebElement e1 = driver.findElement(p.get("province"));
		p.dealPresent(e1, driver);
		ScreenShot.takeScreenShot(driver);
		e1.click();
		WebElement e2 = driver.findElement(p.get("city"));
		p.dealPresent(e2, driver);
		ScreenShot.takeScreenShot(driver);
		e2.click();
		WebElement e3 = driver.findElement(p.get("region"));
		p.dealPresent(e3, driver);
		ScreenShot.takeScreenShot(driver);
		e3.click();
		WebElement e4 = driver.findElement(p.get("street"));
		p.dealPresent(e4, driver);
		ScreenShot.takeScreenShot(driver);
		e4.click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS );
		ScreenShot.takeScreenShot(driver);
		*/
		
		
		
		
	}
	public static void main(String[]args) {
		System.setProperty("phantomjs.binary.path", "E:\\driver\\phantomjs.exe");
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("takeScreenshot", true);
		RemoteWebDriver driver = new PhantomJSDriver(caps);
		PageProduct p =new PageProduct(driver);
		//PageLogin p1 = new PageLogin(driver);
		PageOrder p2 = new PageOrder(driver);
		//p1.Login(driver,"13313313313","222222");
		//SessionId id = driver.getSessionId();//driver的sessionid，不是登陆用户的
		//System.out.println(id.toString());
		//-----------------------------------------------
		
		//-----------------------------------------------
		driver.get("http://mobiletest.ehaier.com:58082/product/5031.html");
		WebElement e = driver.findElement(p.get("buy"));
		p.dealPresent(e, driver);
		e.click();
		ScreenShot.takeScreenShot(driver);
		WebElement ec = driver.findElement(p2.get("cancel"));
		p2.dealPresent(ec, driver);
		ec.click();
		ScreenShot.takeScreenShot(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//WebElement su = driver.findElement(By.xpath("//div[@class='address_button']/a[@class='submit']"));
		//p2.dealPresent(su, driver);
		//su.click();//Element does not exist in cache 因为点击的是一个href连接 
		//解决方式：用post，页面显示可以识别，提交订单以post实现
		//Map<String,String>header = new HashMap<String,String>();
		//header.put("Cookie", "JSESSIONID="+id.toString());
		HttpRes res = new HttpRes("http://mobiletest.ehaier.com:58082/mobile/order/orderSubmitM.html?proRegion=%24%7BordersCommitWrapM.region%7D&paytype=online&invoiceType=2&region=3091&billCompany=gggg&=0&=0&remark=");
		//String resString = res.get("Cookie","JSESSIONID="+id.toString());
		ScreenShot.takeScreenShot(driver);
		System.out.println("finished");
		//assertEquals('a','b');
		driver.close();
		CleanProcess.main(null);
		
	}


}
