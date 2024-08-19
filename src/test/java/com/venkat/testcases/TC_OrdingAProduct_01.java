package com.venkat.testcases;

import org.testng.annotations.Test;

import com.venkat.pageObjects.AddressPage;
import com.venkat.pageObjects.HomePage;
import com.venkat.pageObjects.OrderPage;

public class TC_OrdingAProduct_01 extends BaseClass {
	HomePage homepage;
	OrderPage orderpage;
	AddressPage addresspage;
	String successMessage = "your order has been placed successfully";
	String productName = "Tom";
	String country = "India";

	@Test
	public void orderAProduct() {
		homepage = new HomePage(driver);		
		homepage.enterProductName(productName);
		homepage.addToCart(productName);	
		homepage.clickOnCartIcon();		
		homepage.clickOnProceedToCheckout();		
		orderpage = new OrderPage(driver);
		orderpage.clickOnPlaceOrder();		
		addresspage = new AddressPage(driver);
		addresspage.selectCountry(country);
		addresspage.selectAgreementCheckBox();	
		addresspage.clickOnProceed();
		addresspage.verifyOrderSuccessMessage(successMessage);	
	}
}
