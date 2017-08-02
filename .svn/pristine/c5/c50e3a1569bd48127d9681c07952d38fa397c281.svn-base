package Page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import module.ScreenShot;

public class PageList extends abstractPage{
	private By searchButton;
	private By searchInput;
	private By products;
	private By productTitle;

	public PageList(RemoteWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		searchButton = By.id("search_button");
		searchInput = By.name("searchKey");
		products = By.className("item-product-info");
		productTitle = By.className("item-product-title");
	}

	@Override
	public By get(String loc) {
		// TODO Auto-generated method stub
		switch (loc){
		case "searchbutton":
			return searchButton;
		case "searchinput":
			return searchInput;
		case "products":
			return products;
		case "title":
			return productTitle;
		}
		return null;
	}
	
	
	public static void main(String[]args){
		System.setProperty("phantomjs.binary.path", "E:\\driver\\phantomjs.exe");
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("takeScreenshot", true);
		RemoteWebDriver driver = new PhantomJSDriver(caps);
		PageList p = new PageList(driver);
		driver.get("http://mobiletest.ehaier.com:58082/l/2729");
		List<WebElement> es = new ArrayList(driver.findElements(p.get("products")));
		try{
		    for(int i=0;i<es.size();i++){
			    p.dealPresent(es.get(i), driver);
			    //es.get(i).getAttribute("");
			    System.out.println((es.get(i).findElement(p.get("title"))).getText());
		    }
		}
		catch (Exception e){
			e.printStackTrace();
			
		}
		ScreenShot.takeScreenShot(driver);
		driver.close();
		System.out.println("finished");
		
		
	}

}
