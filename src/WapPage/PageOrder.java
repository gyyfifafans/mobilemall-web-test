package WapPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import module.ScreenShot;

//静态常量paytype,invoiceType,proRegion,billCompany,remark,(Giftcard,coupon)


public class PageOrder extends WapPage{
	//private By submit_loc;
	private By remark_loc;
	private By online_loc;
	private By offline_loc;
	private By chooseaddress_loc;
	private By cancelbutton_loc;
	private By changebutton_loc;
	//private By button_loc;
	
	
	public PageOrder(RemoteWebDriver driver){
		super(driver);
		//submit_loc = By.linkText("提交订单");
		//submit_loc = By.id("orderSubmit");
		remark_loc = By.name("remark");
		online_loc = By.className("pull-order stage-slected");
		offline_loc = By.className("pull-order");
		chooseaddress_loc = By.className("address-change address-mask-none");
		cancelbutton_loc = By.xpath("//div[@class='address-tip-bottom']/span[@class='address-tip-cancle']");
		changebutton_loc = By.xpath("//div[@class='address-tip-bottom']/span[@class='address-tip-new']");
		//button_loc = By.xpath("//div[@class='address-tip-bottom']");
	}
	
	
	public By get(String loc){
		switch (loc){
		//case "submit":
		//	return submit_loc;
		case "remark":
			return remark_loc;
		case "online":
			return online_loc;
		case "offline":
			return offline_loc;
		case "chooseaddress":
			return chooseaddress_loc;
		//case "button":
		//	return button_loc;
		case "cancel":
			return cancelbutton_loc;
		case "change":
			return changebutton_loc;
		}
		return null;
	}
	//提交订单get地址拼接
	public String getUrl(){
		String url=null;
		
		return url;
	}
	
	
	public static void main(String[]args){
		System.setProperty("phantomjs.binary.path","E:\\driver\\phantomjs.exe");
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("takeScreenshot", true);
		RemoteWebDriver driver = new PhantomJSDriver(caps);
		

		
		
	}

}
