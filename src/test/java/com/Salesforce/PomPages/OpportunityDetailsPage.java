package com.Salesforce.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Salesforce.DataDrivers.ReadPropertiesFile;
import com.Salesforce.seleniumUtilities.SeleniumWebElements;

public class OpportunityDetailsPage {

	@FindBy(xpath = "(//a[text()='Details'])")
	private WebElement detailsTab;

	@FindBy (xpath = "(//span[contains(@class, 'test-id__field-value')])[2]//lightning-formatted-text")
	private WebElement amount ;
	
	@FindBy (xpath = "(//span[contains(@class, 'test-id__field-value')])[5]//lightning-formatted-text")
	private WebElement opportunityName ;
	
	@FindBy (xpath = "(//span[contains(@class, 'test-id__field-value')])[6]//lightning-formatted-text")
	private WebElement date ;
	
	@FindBy (xpath= "(//span[contains(@class, 'test-id__field-value')])[12]//lightning-formatted-number")
	private WebElement probability ;
	
	@FindBy (xpath= "(//span[contains(@class, 'test-id__field-value')])[14]//lightning-formatted-text")
	private WebElement orderNum ;
	
	@FindBy (xpath= "(//span[contains(@class, 'test-id__field-value')])[18]//lightning-formatted-text")
	private WebElement trackingNum ;
	
	
	public OpportunityDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnDetailsTab() {
		try {
			SeleniumWebElements.clickOnElement(detailsTab);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verifyOpportunityDetails()
	{
		String amt = SeleniumWebElements.getTextOfElement(amount);
		Assert.assertEquals(amt, ReadPropertiesFile.readData("amount"));
		
		String opportunityName1 = SeleniumWebElements.getTextOfElement(opportunityName);
		Assert.assertEquals(opportunityName1, ReadPropertiesFile.readData("opportunityName"));
		
		String dateAct = SeleniumWebElements.getTextOfElement(date);
		Assert.assertEquals(dateAct, ReadPropertiesFile.readData("date"));
		
		String probabilityAct = SeleniumWebElements.getTextOfElement(probability);
		Assert.assertEquals(probabilityAct, ReadPropertiesFile.readData("probability"));
		
		String orderNumAct = SeleniumWebElements.getTextOfElement(orderNum);
		Assert.assertEquals(orderNumAct, ReadPropertiesFile.readData("orderNumber"));
		
		String trackingNumAct = SeleniumWebElements.getTextOfElement(trackingNum);
		Assert.assertEquals(trackingNumAct, ReadPropertiesFile.readData("trackingNum"));
			
	}
	
}
