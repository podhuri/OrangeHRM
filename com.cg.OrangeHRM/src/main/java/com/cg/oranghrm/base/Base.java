package com.cg.oranghrm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cg.oranghrm.util.Util;

public class Base extends Util {
	
	//initializing global variables
	//public static WebDriver driver;
	public static Properties prop;
	
	
	//base class constructor to initialize object
	public Base() throws IOException {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:/Users/podhuri/eclipse-oranghrm"
					+ "/com.cg.OrangeHRM/src/main/resources/config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//launching the browser
	public void initialize() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/Users/podhuri/OneDrive - Capgemini/"
					+ "Desktop/LatestBrowser/chromedriver.exe");
			driver = new ChromeDriver();
		}else {
			System.out.println("Browser not found");
		}
		
		driver.get(prop.getProperty("url"));
		
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Util.IMPLICITLY_WAIT, TimeUnit.SECONDS);
		
		
		
	}

}
