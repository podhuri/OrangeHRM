package com.cg.oranghrm.util;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class Helper extends Util {
		
	
	public Helper() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void click(WebElement element) throws IOException {
		
		
			if(element.isDisplayed()) {
				highLightElement(element);
				System.out.println(element +" is displayed");
				element.click();
				capture();
			}
			else {
				System.out.println(element +" is not displayed");
			}
		
	}
	
	public void sendKeys(WebElement element, String input) throws IOException {
		
	
			if(element.isDisplayed()) {
				highLightElement(element);
				System.out.println(element +" is displayed");
				element.sendKeys(input);
				capture();
			}
			else {
				System.out.println(element +" is not displayed");
			}
	
	}
	
	public boolean isDisplayed(WebElement element) throws IOException {
		
		
			if(element.isDisplayed()) {
				highLightElement(element);
				System.out.println(element +" is displayed");
				capture();
				return true;
				
			}
			else {
				System.out.println(element +" is not displayed");
				return false;
			}
	}
}
