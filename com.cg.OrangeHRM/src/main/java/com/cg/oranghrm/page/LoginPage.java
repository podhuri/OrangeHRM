package com.cg.oranghrm.page;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cg.oranghrm.base.Base;
import com.cg.oranghrm.util.Helper;
import com.cg.oranghrm.util.Util;

public class LoginPage extends Helper {
	
	//Page Factory/OR for Login class
	@FindBy(id="txtUsername")
	WebElement username;
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement loginBtn;
	
	@FindBy(xpath="//div[@id=\"divLogo\"]//img")
	WebElement hrmLogo;
	
	@FindBy(xpath="//div[contains(text(),'LOGIN Panel')]")
	WebElement loginPanelHeading;
	
	@FindBy(tagName = "title")
	WebElement heading;
	
	//initializing web elements
	public LoginPage() throws IOException {
		//super();
		PageFactory.initElements(driver, this);
		
	}
	
	//get login page title
	public String validateLoginPageTitle() {
		
		//highLightElement(heading);
		return driver.getTitle();
		
	}
	
	//get login page logo
	public boolean validateLoginPageLogo() throws IOException {
		boolean result = isDisplayed(hrmLogo);
		return result;
	}
	
	//get login panel heading
	public void validateLoginPanelHeading() throws IOException {
		isDisplayed(loginPanelHeading);
	}
	
	//login
	public DashboardPage login(String un,String pass) throws IOException {
		
		sendKeys(username, un);;
		sendKeys(password, pass);
		click(loginBtn);
		
		return new DashboardPage();
		
	}
	
	
	
	

}
