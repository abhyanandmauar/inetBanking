package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(how = How.XPATH, using="/html[1]/body[1]/div[3]/div[1]/ul[1]/li[2]/a[1]")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	@FindBy(how= How.NAME, using= "name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(how= How.NAME, using="rad1")
	@CacheLookup
	WebElement rdGender;
	
	@FindBy(how= How.ID_OR_NAME, using="dob")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(how= How.NAME, using="addr")
	@CacheLookup
	WebElement txtaddress;
	
	@FindBy(how=How.NAME, using="city")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(how=How.NAME, using="state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(how= How.NAME, using="pinno")
	@CacheLookup
	WebElement txtPin;
	
	@FindBy(how=How.NAME, using="telephoneno")
	@CacheLookup
	WebElement txtMobileNo;
	
	@FindBy(how= How.NAME, using="emailid")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(how= How.NAME, using="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(how= How.NAME, using="sub")
	@CacheLookup
	WebElement btnSubmit;
	
	@FindBy(how=How.NAME, using="res")	
	@CacheLookup
	WebElement btnReset;
	
	
	public void clickAddNewCustomer() {
		
		lnkAddNewCustomer.click();
	}
	
	public void custName(String cName) {
		
		txtCustomerName.sendKeys(cName);
		
	}
	
	public void custGender(String cGender) {
		
		rdGender.click();
		
	}
	
	public void custDob(String dd, String mm, String yy) {
		
		txtdob.sendKeys(dd);
		txtdob.sendKeys(mm);
		txtdob.sendKeys(yy);
	}
	
	public void custAddress(String cAddress) {
		
		txtaddress.sendKeys(cAddress);
	}
	
	public void custCity(String cCity) {
		
		txtCity.sendKeys(cCity);
	}
	
	public void custState(String cState) {
		
		txtState.sendKeys(cState);
	}
	
	public void custPin(String cPin) {
		
		txtPin.sendKeys(String.valueOf(cPin));
	}
	
	public void custMobileNo(String cMobileNo) {
		
		txtMobileNo.sendKeys(cMobileNo);
	}
	
	public void custEmail(String cEmail) {
		
		txtEmail.sendKeys(cEmail);
	}
	
	public void custPassword(String cPassword) {
		
		txtPassword.sendKeys(cPassword);
	}
	
	public void custSubmit() {
		
		btnSubmit.click();
	}
	

}
