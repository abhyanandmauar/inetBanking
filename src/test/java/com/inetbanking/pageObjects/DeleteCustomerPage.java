package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage {
	
	WebDriver ldriver;
	
	public DeleteCustomerPage(WebDriver rdriver) {
		
		ldriver= rdriver;
		
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(how= How.XPATH, using="//body/div[3]/div[1]/ul[1]/li[4]/a[1]")
	@CacheLookup
	WebElement lnkDeleteCustomer;
	
	@FindBy(how= How.NAME, using="cusid")
	@CacheLookup
	WebElement txtCustomerId;
	
	@FindBy(how= How.NAME, using="AccSubmit")
	@CacheLookup
	WebElement btnSubmit;
	
	@FindBy(how= How.NAME, using="res")
	@CacheLookup
	WebElement btnReset;
	
	public void clickDeleteCustomer() {
		
		lnkDeleteCustomer.click();
		
	}
	
	public void custId(String cid) {
		
		txtCustomerId.sendKeys(cid);
	}
	
	public void custSubmit() {
		
		btnSubmit.click();
	}
	
	public void custReset() {
		
		btnReset.click();
	}

}