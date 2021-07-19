package com.cg.oranghrm.page;

import java.io.IOException;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cg.oranghrm.base.Base;
import com.cg.oranghrm.util.Helper;


public class AdminPage extends Helper {
	
	@FindBy(xpath="//div[@id=\"content\"]//h1")
	WebElement adminpageHeading;
	
	
	@FindBy(xpath="//div[@id=\"mainMenu\"]//a[@id=\"menu_leave_viewLeaveModule\"]//b")
	WebElement leave;
	
	@FindBy(xpath="//input[@id=\"searchSystemUser_userName\"]")
	WebElement userName;
	
	@FindBy(xpath="//select[@id=\"searchSystemUser_userType\"]")
	WebElement userRole;
	
	@FindBy(xpath="//input[@class=\"ac_input\"]")
	WebElement employee;
	
	@FindBy(xpath="//select[@id=\"searchSystemUser_status\"]")
	WebElement status;
	
	@FindBy(id="searchBtn")
	WebElement searchBtn;
	
	@FindBy(xpath="//input[@id=\"resetBtn\"]")
	WebElement resetBtn;
	
	@FindBy(xpath="//div[@id=\"customerList\"]//table//td[2]")
	WebElement searchResultName;
	
	@FindBy(xpath="//div[@id=\"customerList\"]//table//td[3]")
	WebElement searchResultRole;
	
	@FindBy(xpath="//input[@id=\"searchSystemUser_employeeName_empName\"]")
	WebElement employeeName;
	
	@FindBy(xpath="//div[@id=\"customerList\"]//table//td[4]")
	WebElement searchResultEmployee;
	
	@FindBy(xpath="//div[@id=\"customerList\"]//table//td[5]")
	WebElement searchResultStatus;
	
	@FindBy(xpath="//input[@id=\"btnAdd\"]")
	WebElement addbtn;
	
	@FindBy(xpath="//select[@id=\"systemUser_userType\"]")
	WebElement addUserRole;
	
	@FindBy(id="systemUser_employeeName_empName")
	WebElement addEmployeeName;
	
	@FindBy(xpath="//input[@id=\"systemUser_userName\"]")
	WebElement addUserName;
	
	@FindBy(xpath="//select[@id=\"systemUser_status\"]")
	WebElement addStatus;
	
	@FindBy(xpath="//input[@id=\"systemUser_password\"]")
	WebElement addPassword;
	
	@FindBy(xpath="//input[@id=\"systemUser_confirmPassword\"]")
	WebElement addConfPassword;
	
	@FindBy(id="btnSave")
	WebElement saveBtn;
	
	@FindBy(xpath="//div[@class='message success fadable']")
	WebElement successMsg;
	
	@FindBy(xpath="//div[@id=\"customerList\"]//table//td[1]")
	WebElement checkRow;
	
	@FindBy(xpath="//input[@id='btnDelete']")
	WebElement delBtn;
	
	@FindBy(xpath="//div[@class=\"modal hide in\"]//div//h3")
	WebElement delPopup;
	
	@FindBy(xpath="//input[@id=\"dialogDeleteBtn\"]")
	WebElement delAccept;
	
	
	
	
	
	public AdminPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		
	}
	
	public String verifyAdminHeading() {
		
		highLightElement(adminpageHeading);
		return adminpageHeading.getText();
	
	}
	
	
	public String searchUserByUserName(String uname) throws IOException {
		
		
		sendKeys(userName, uname);
		click(searchBtn);
		
		highLightElement(searchResultName);
		return searchResultName.getText();	
		
	}
	
	public String searchByUserRole() throws IOException {
		
		click(resetBtn);
		highLightElement(userRole);
		Select se = new Select(userRole);
		se.selectByIndex(1);
		click(searchBtn);
		List<WebElement> employee = driver.findElements(By.xpath("//div[@class=\"ac_results\"]//ul//"
				+ "li[contains(text(),\"thony\")]"));
		
		highLightElement(searchResultRole);
		return searchResultRole.getText();
			
	}
	
	public String searchByEmployeeName(String empName) throws InterruptedException, IOException {
		
		click(resetBtn);
		
		Thread.sleep(3000);
		highLightElement(employeeName);
		employeeName.sendKeys(empName);
		
		Thread.sleep(3000);
		List<WebElement> employee = driver.findElements(By.xpath("//div[@class=\"ac_results\"]//ul//li[contains(text(),\"thony\")]"));
		System.out.println(employee.size());
		
		for(int i=0;i<employee.size();i++) {
			if(employee.get(i).getText().contains(empName)) {
				
				employee.get(i).click();
				break;
			}
		}
		
		click(searchBtn);
		
		highLightElement(searchResultEmployee);
		return searchResultEmployee.getText();
		
	}
	public String searchByStatus() throws IOException {
		
		click(resetBtn);
		
		highLightElement(status);
		Select se1 = new Select(status);
		se1.selectByIndex(1);
		
		click(searchBtn);
		
		highLightElement(searchResultStatus);
		return searchResultStatus.getText();
			
	}
	
	public String addUser(String userRole, String empName, String userName, String status, String password, String confPass) throws InterruptedException, IOException {
		
		click(addbtn);
		
		highLightElement(addUserRole);
		Select se2 = new Select(addUserRole);
		se2.selectByVisibleText(userRole);
		
		sendKeys(addEmployeeName, empName);
		sendKeys(addUserName, userName);
		
		highLightElement(addStatus);
		Select se3 = new Select(addStatus);
		se3.selectByVisibleText(status);
		
		sendKeys(addPassword, password);
		
		sendKeys(addConfPassword, confPass);
		
		Thread.sleep(2000);
		click(saveBtn);
		
		highLightElement(successMsg);
		return successMsg.getText();			
	}
	
	public String verifyDeleteUser() throws InterruptedException, IOException {
		
		click(checkRow);
		click(delBtn);
		
		Thread.sleep(3000);
		String delhead = delPopup.getText();
		System.out.println(delhead);
		click(delAccept);
			
		highLightElement(successMsg);
		return successMsg.getText();
	}
	
	public LeavePage clickOnLeaveLink() throws IOException {
		
		leave.click();
		return new LeavePage();
	}
	
//	public String validateData(String data1 , String data2) {
//		String dataFound =data1;
//		return dataFound;
//	}

}
