package module;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class ScreenShot
{
	public static void takeScreenShot(RemoteWebDriver driver)
	{  /*
	   File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  
	   try 
	   {   
	      FileUtils.copyFile(screenShotFile, new File( "screenshot/" + getDatePath()+"/" + getCurrentDateTime()+ ".jpg"));  
	   } 
	   catch (IOException e) 
	   {
		   e.printStackTrace();
	   } */
	   String curpath = System.getProperty("user.dir");
	   String path =curpath+"\\"+"screenshot";
	   //File screenFile = driver.getScreenshotAs(OutputType.FILE);
	   File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   try{
			FileUtils.copyFile(scrFile, new File(path+"\\"+getCurrentDateTime()+".png"));
			}
	   catch( IOException e){
			System.out.println("test is finished");
			}
	} 

	public static String getCurrentDateTime()
	{
	   SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss");
	   return df.format(new Date());
	}
	
	public static File getDatePath()
	{
		
		Date date = new Date(); 
		
		String path=new SimpleDateFormat("yyyyMMdd").format(date); 

		File f = new File(path); 
	//	if(!f.exists()) 
	//	f.mkdirs(); 
		return f;
	}
	   

}
