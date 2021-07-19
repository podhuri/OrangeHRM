package com.cg.oranghrm.testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cg.oranghrm.base.Base;
import com.cg.oranghrm.page.AdminPage;
import com.cg.oranghrm.page.DashboardPage;
import com.cg.oranghrm.page.LoginPage;

public class DashboardPageTest extends Base{
	
	DashboardPage dashboardPage;
	AdminPage adminPage;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUp() throws IOException {
		initialize();
		dashboardPage = new DashboardPage();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyDashboardHeading() throws IOException {
		dashboardPage.validateDashboardHeading();
		//Assert.assertTrue(dashboardTitle);
	}
	
	@Test(priority=2)
	public void verifyWelcome() throws IOException {
		dashboardPage.validateWelcome();
		//Assert.assertTrue(welcomeUser);
		
	}
	@Test(priority=3)
	public void verifyAdminLinkClick() throws IOException {
		adminPage = dashboardPage.validateAdminlinkClick();
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	public DashboardPageTest() throws IOException {
		super();
	}

}
