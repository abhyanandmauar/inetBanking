package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username is provided");
		lp.setPassword(password);
		logger.info("Password is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust= new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		logger.info("Providing customer details...");
		
		addcust.custName("Abhyanand");
		addcust.custGender("Male");
		addcust.custDob("08","10", "1989");
		addcust.custAddress("Mumbai");
		addcust.custCity("Navi Mumbai");
		addcust.custState("Bihar");
		addcust.custPin("824102");
		addcust.custMobileNo("9967019444");
		
		String email= randomstring()+"@gmail.com";
		addcust.custEmail(email );
		
		addcust.custPassword("ancdefg");
		addcust.custSubmit();
		
		Thread.sleep(3000);
		
		logger.info("Validarion started...");
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("Test case passed...");
			captureScreen(driver, "TC_AddCustomerTest_003");
			
			/*lp.clickLogout();
			Thread.sleep(5000);
			driver.switchTo().alert().accept();
			logger.info("Application logged out successfully..."); */
		}
		else
		{
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
			logger.info("Test case failed...");
			
			/*lp.clickLogout();
			Thread.sleep(2000);
			logger.info("Application logged out successfully....");*/
		}
		
	}
}
