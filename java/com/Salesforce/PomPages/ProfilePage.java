package com.Salesforce.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesforce.seleniumUtilities.SeleniumWebElements;

public class ProfilePage {

	@FindBy(xpath = "(//span[@class='uiImage'])[1]")
	private WebElement viewProfile;

	@FindBy(xpath = "//a[text()='Log Out']")
	private WebElement logOut;

	public ProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void signOutFromSalesforce() {
		try {
			SeleniumWebElements.clickOnElement(viewProfile);
			SeleniumWebElements.clickOnElement(logOut);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
