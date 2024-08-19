package com.venkat.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.venkat.testcases.BaseClass;

public class AddressPage extends BaseClass {
	WebDriver driver;

	public AddressPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(tagName = "select")
	WebElement drpCountry;

	@FindBy(css = ".chkAgree")
	WebElement chkAgree;

	@FindBy(xpath = "//button[text()='Proceed']")
	WebElement btnProceed;

	public void selectCountry(String country) {
		Select select = new Select(drpCountry);
		select.selectByValue(country);
		logger.info("Selected county" + country);
	}

	public void selectAgreementCheckBox() {
		chkAgree.click();
		logger.info("Clicked on agreement checkbox");
	}

	public void verifyOrderSuccessMessage(String message) {
		WebElement lblOrderSuccessful = driver.findElement(By.xpath("//*[contains(text(),'" + message + "')]"));
		boolean isSuccess = lblOrderSuccessful.isDisplayed();
		Assert.assertTrue(isSuccess);
		logger.info("Verified order message success");
	}

	public void clickOnProceed() {
		btnProceed.click();
		logger.info("Clicked on proceed button");
	}
}
