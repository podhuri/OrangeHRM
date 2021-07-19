package com.cg.oranghrm.data;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.cg.oranghrm.base.Base;

public class TestData extends Base {

	
	public TestData() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@DataProvider(name="Add User")
	public Object[][] getdata(Method m){
		if(m.getName().equalsIgnoreCase("validateAddUser")) {
		return new Object[][]{
			{prop.getProperty("userRole"),prop.getProperty("empName"),prop.getProperty("userName"),prop.getProperty("status"),prop.getProperty("user_password"),prop.getProperty("confPass")},
			{"ESS","Anthony Nolan","gayatri.chavan","Disabled","abc1234@55","abc1234@55"},
			//{"Admin","Utkarsh Singh","utkarsh.singh","Enabled","abcd12345","abcd12345"}
		};
		}
		else {
			return new Object[][]{
				{"No Data","Bye"}
			}; 
		}
		
	}
	
	
	

}
