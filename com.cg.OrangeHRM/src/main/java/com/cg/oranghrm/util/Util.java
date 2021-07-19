package com.cg.oranghrm.util;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;



public class Util  {
	

	public static WebDriver driver;
	public static long PAGE_LOAD_TIMEOUT=10;
	public static long IMPLICITLY_WAIT=10;
	//public static String path;
	
	public Util() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void highLightElement(WebElement element)
	{
	JavascriptExecutor js=(JavascriptExecutor)driver; 
	 
	js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	 
	try 
	{
	Thread.sleep(1000);
	} 
	catch (InterruptedException e) {
	 
	System.out.println(e.getMessage());
	} 
	 
	js.executeScript("arguments[0].setAttribute('style','border: 2px white');", element); 
	 
	}
	
	
	public static void capture() throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.currentTimeMillis()+".png"; //System.getProperty("user.dir")
		File destination = new File("./screenshots");
		destination.mkdirs();
		destination = new File(path);
		try {
				FileHandler.copy(src, destination);
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}
	}
}
  



