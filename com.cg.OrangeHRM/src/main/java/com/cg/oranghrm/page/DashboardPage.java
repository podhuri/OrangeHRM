package com.cg.oranghrm.page;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cg.oranghrm.util.Helper;

public class DashboardPage extends Helper{
	
	//Page Factory/OR for Dashboard  class
	@FindBy(xpath="//div[@class=\"box\"]//h1")
	WebElement dashboardTitle;
	
	@FindBy(xpath="//div[@id=\"mainMenu\"]//a//b[contains(text(),'Admin')]")
	WebElement adminLink;
	
	@FindBy(xpath="//a[starts-with(text(),'Welcome')]")
	WebElement welcome;
	
	
	//initializing web elements
	public DashboardPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	//get dashboard title
	public void validateDashboardHeading() throws IOException {
		
		isDisplayed(dashboardTitle);
	}
	
	public void validateWelcome() throws IOException{
		
		isDisplayed(welcome);
	}
	
	//click on Admin Link
	public AdminPage validateAdminlinkClick() throws IOException {
		
		click(adminLink);
		return new AdminPage();
	}

}
