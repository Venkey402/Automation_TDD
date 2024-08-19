package com.venkat.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.venkat.testcases.BaseClass;

public class HomePage extends BaseClass {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input.search-keyword")
	WebElement txtSearch;

	@FindBy(css = "a.cart-icon")
	WebElement iconCart;

	@FindBy(xpath = "//*[text()='PROCEED TO CHECKOUT']")
	WebElement btnProceedToCheckout;

	public void clickOnProceedToCheckout() {
		btnProceedToCheckout.click();
		logger.info("Clicked on proceed to checkout");
	}

	public void clickOnCartIcon() {

		iconCart.click();
		logger.info("Clicked on Cart icon");
	}

	public void enterProductName(String productName) {
		txtSearch.clear();
		txtSearch.sendKeys(productName);
		logger.info("Entered product name");
	}

	public void addToCart(String productName) {
		WebElement btnAddToCart = driver.findElement(By.xpath(
				"//*[@class='product-name'][contains(text(),'" + productName + "')]/..//button[text()='ADD TO CART']"));
		btnAddToCart.click();
		logger.info("Product is added to cart");
	}
}
