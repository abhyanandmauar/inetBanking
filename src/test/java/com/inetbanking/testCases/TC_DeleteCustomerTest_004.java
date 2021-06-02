package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.DeleteCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_DeleteCustomerTest_004 extends BaseClass{
	//String custid;
	
	@Test
	public void deleteCustomer() throws InterruptedException, IOException {
		
		LoginPage lp= new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Username is provided");
		
		lp.setPassword(password);
		logger.info("Password is provided");
		
		lp.clickSubmit();
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
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
		
		logger.info("Validation started...");
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("New customer added successfully...");
			
		}
		else
		{
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
			logger.info("New customer addition failed...");
			
		}
		
		
		DeleteCustomerPage deletecust= new DeleteCustomerPage(driver);
		
		String custid = driver.findElement(By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[4]/td[2]")).getText();
		System.out.println("The customer id is "+custid);
		
		deletecust.clickDeleteCustomer();
		logger.info("Deleting customer!!!!!!");
		
		deletecust.custId(custid);
		logger.info("Enterting customer id:  "+custid);
		
		deletecust.custSubmit();
		
		Thread.sleep(5000);
		
		if(isAlertPresent() == true) {
			
			driver.switchTo().alert().accept();
			logger.info("Customer deleted successfully....");
			
			driver.switchTo().alert().accept();
			logger.info("Click on Ok");
			/*captureScreen(driver, "TC_DeleteCustomerTest_004");
			logger.info("Screenshot taken");*/
		}
		else {
			logger.info("Test case failed!!!!!!!!!!");
		}
	}
	
	public boolean isAlertPresent() //user defined method to check alert is present or not
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}

}
