package com.cg.oranghrm.testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cg.oranghrm.base.Base;
import com.cg.oranghrm.page.DashboardPage;
import com.cg.oranghrm.page.LoginPage;

public class LoginPageTest extends Base {
	
	//objects creation
	LoginPage loginPage;
	DashboardPage dashboardPage;
	
	
	//pre-conditions
	@BeforeTest
	public void setUp() throws IOException {
		initialize();
		loginPage = new LoginPage();
		
		
	}
	
	//Test 1 : to verify login page title
	@Test(priority=1)
	public void verifyLoginPageTitle() {
		String loginPageTitle = loginPage.validateLoginPageTitle();
		Assert.assertEquals(loginPageTitle, "OrangeHRM");
	}
	
	//Test 2 : to verify login page logo
	@Test(priority=2)
	public void verifyLoginPageLogo() throws IOException {
		//boolean result = loginPage.validateLoginPageLogo();
		Assert.assertTrue(loginPage.validateLoginPageLogo());
	}
	
	//Test 3 : to verify login panel heading
	@Test(priority=3)
	public void verifyLoginPanel() throws IOException {
		loginPage.validateLoginPanelHeading();
		//Assert.assertTrue(loginPanelHeading);
	}
	
	//Test 4 : to verify login into application
	@Test(priority=4)
	public void verifyLogin() throws IOException {
		 dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	/*
	 * @AfterMethod public void tearDown() { driver.quit(); }
	 */

	public LoginPageTest() throws IOException {
		super();
		
	}

}
