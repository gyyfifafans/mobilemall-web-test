package PcPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class PcPage {
	public PcPage(RemoteWebDriver driver){
		
	}
	public boolean isByPresent(WebElement d){
		boolean display = d.isDisplayed();
		if (display){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public abstract By get(String loc);
	
	public Boolean dealPresent(WebElement d,RemoteWebDriver driver){
		while(!isByPresent(d)){
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		}
		return true;
		
	}

}