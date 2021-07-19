package com.cg.oranghrm.testcase;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.cg.oranghrm.base.Base;
import com.cg.oranghrm.data.TestData;
import com.cg.oranghrm.page.AdminPage;
import com.cg.oranghrm.page.DashboardPage;
import com.cg.oranghrm.page.LeavePage;
import com.cg.oranghrm.page.LoginPage;

public class AdminPageTest extends Base {
	
	AdminPage adminPage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	LeavePage leavePage;
	
	@BeforeTest
	public void setUp() throws IOException {
		initialize();
		leavePage = new LeavePage();
		adminPage = new AdminPage();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		System.out.println(prop.getProperty("username")+" "+ prop.getProperty("password"));
		dashboardPage.validateAdminlinkClick();
		
		
	}
	
	@Ignore
	@Test(priority=1)
	public void validateAdminHeading() {
		String adminHeading = adminPage.verifyAdminHeading();
		System.out.println(adminHeading);
		Assert.assertEquals(adminHeading, "System Users");
	}
	
	@Ignore
	@Test(priority=2)
	public void validateSearchByUsername() throws IOException {
		String user = adminPage.searchUserByUserName(prop.getProperty("uname"));
		System.out.println(user);
		Assert.assertEquals(user, "Aatmaram");;
	}
	
	@Ignore
	@Test(priority=3)
	public void validateSearchByUserRole() throws IOException {
		String role = adminPage.searchByUserRole();
		System.out.println(role);
		Assert.assertEquals(role, "Admin");
	}
	
	@Ignore
	@Test(priority=4)
	public void validateSearchByEmployeeName() throws InterruptedException, IOException {
		String employee = adminPage.searchByEmployeeName(prop.getProperty("emp"));
		System.out.println(employee);
		Assert.assertEquals(employee, "Anthony Nolan");
	}
	
	@Ignore
	@Test(priority=5)
	public void validateSearchByStatus() throws IOException {
		String status = adminPage.searchByStatus();
		System.out.println(status);
		Assert.assertEquals(status, "Enabled");
	}
	
	
	@Test(priority = 6, dataProviderClass = TestData.class, dataProvider = "Add User")
	public void validateAddUser(String userRole, String empName, String userName, String status, String password, String confPass) throws InterruptedException, IOException {
		
		String success = adminPage.addUser(userRole, empName , userName, status ,password , confPass);
		System.out.println(success);
		Assert.assertEquals(success, "Successfully Saved");
	}
	
	@Ignore
	@Test
	public void deleteUser() throws InterruptedException, IOException {
		adminPage.searchUserByUserName(prop.getProperty("delUser"));
		String delMsg = adminPage.verifyDeleteUser();
		System.out.println(delMsg);
		Assert.assertEquals(delMsg, "Successfully Deleted");
		
		
		
	}
	
	@Ignore
	@Test(priority=7)
	public void validateLeavePageLink() throws IOException {
		leavePage = adminPage.clickOnLeaveLink();
	}

	public AdminPageTest() throws IOException {
		super();
		
	}
	
//	@Ignore
//	@Test(dataProvider ="Add User")
//	public void validateAddUser2(String value, String output){
//		//String dataFound = adminPage.validateData(value,output);
//		System.out.println(dataFound);
//	}
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
	
	

}
