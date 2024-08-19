package com.venkat.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.venkat.testcases.BaseClass;

public class OrderPage extends BaseClass{
	WebDriver driver;

	public OrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "p.product-name")
	WebElement lblProductName;

	@FindBy(xpath = "//button[text()='Place Order']")
	WebElement btnPlaceOrder;

	public String getProductName() {

		return lblProductName.getText();
	}

	public void clickOnPlaceOrder() {

		btnPlaceOrder.click();
		logger.info("Clicked on place order");
	}
}
