package module;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import util.CleanProcess;

public class UpdateElements {
	DesiredCapabilities caps = new DesiredCapabilities();
	RemoteWebDriver driver;
	
	
	
	public void getPage(String url){
		
	}
	
	public static void main(String[]args) throws IOException {
		System.setProperty("phantomjs.binary.path", "E:\\driver\\phantomjs.exe");
		UpdateElements upd = new UpdateElements();
		upd.caps.setCapability("takeScreenShot", true);
		RemoteWebDriver dr = upd.driver;
		dr = new PhantomJSDriver(upd.caps);
		dr.get("http://mobiletest.ehaier.com:58082");
		//System.out.println(dr.getPageSource());
		BufferedWriter fr = new BufferedWriter(new FileWriter(new File("e:\\page.txt")));
		fr.write(dr.getPageSource());
		dr.close();
		CleanProcess.main(null);
	}
	
	

}
