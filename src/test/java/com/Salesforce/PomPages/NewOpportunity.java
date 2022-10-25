package com.Salesforce.PomPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesforce.DataDrivers.ReadPropertiesFile;
import com.Salesforce.seleniumUtilities.SeleniumWebElements;

public class NewOpportunity {

	private WebDriver driver ;
	
	@FindBy (xpath = "//div[text()='New']")
	private WebElement btn_new ;
	
	@FindBy (xpath= "//input[@name='Name']")
	private WebElement opportunityName ;
	
	@FindBy (xpath= "(//input[@class='slds-combobox__input slds-input'])[1]")
	private WebElement accountName ;
	
	@FindBy (xpath= "//button[@aria-label='Type, --None--']")
	private WebElement type ;
	
	@FindBy (xpath= "//button[@aria-label='Lead Source, --None--']")
	private WebElement leadSource ;
	
	@FindBy (xpath= "//button[@aria-label='Stage, --None--']")
	private WebElement stage ;
	
	@FindBy (xpath= "//button[@aria-label='Delivery/Installation Status, --None--']")
	private WebElement deliveryStatus ;
	
	@FindBy (xpath= "//input[@name='Amount']")
	private WebElement amount ;
	
	@FindBy (xpath= "//input[@name='CloseDate']")
	private WebElement date ;
	
	@FindBy (xpath= "//input[@name='NextStep']")
	private WebElement nextStep ;
	
	@FindBy (xpath= "//input[@name='Probability']")
	private WebElement probability ;
	
	@FindBy (xpath = "//input[@name='OrderNumber__c']")
	private WebElement orderNumber ;
	
	@FindBy (xpath = "//input[@name='TrackingNumber__c']")
	private WebElement trackingNum ;
	
	@FindBy (xpath = "//textarea[@class='slds-textarea']")
	private WebElement description ;
	
	@FindBy (xpath = "//button[@name='SaveEdit']")
	private WebElement saveBtn ;
	
	public NewOpportunity(WebDriver driver)
	{
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnNewButton() throws Exception
	{
		SeleniumWebElements.clickOnElement(btn_new);
	}
	
	public void fillOpportunityDetails() throws Exception
	{
		SeleniumWebElements.enterInputIntoElement(opportunityName, ReadPropertiesFile.readData("opportunityName"));
		SeleniumWebElements.clickOnElement(accountName);
		accountName.sendKeys(Keys.ARROW_DOWN);
		accountName.sendKeys(Keys.ARROW_DOWN);
		accountName.sendKeys(Keys.ENTER);
		
		SeleniumWebElements.clickOnElement(type);
		type.sendKeys(Keys.ARROW_DOWN);
		type.sendKeys(Keys.ENTER);
		
		SeleniumWebElements.clickOnElement(leadSource);
		leadSource.sendKeys(Keys.ARROW_DOWN);
		leadSource.sendKeys(Keys.ARROW_DOWN);
		leadSource.sendKeys(Keys.ENTER);
		
		SeleniumWebElements.enterInputIntoElement(amount, ReadPropertiesFile.readData("amount"));
		SeleniumWebElements.enterInputIntoElement(date, ReadPropertiesFile.readData("date"));
		SeleniumWebElements.enterInputIntoElement(nextStep, ReadPropertiesFile.readData("nextStep"));
		
		SeleniumWebElements.clickOnElement(stage);
		stage.sendKeys(Keys.ARROW_DOWN);
		stage.sendKeys(Keys.ARROW_DOWN);
		stage.sendKeys(Keys.ARROW_DOWN);
		stage.sendKeys(Keys.ENTER);
		
		SeleniumWebElements.enterInputIntoElement(probability, ReadPropertiesFile.readData("probability"));
		SeleniumWebElements.clickByJavascript(deliveryStatus);
		deliveryStatus.sendKeys(Keys.ARROW_DOWN);
		deliveryStatus.sendKeys(Keys.ENTER);
		
		SeleniumWebElements.enterInputIntoElement(orderNumber, ReadPropertiesFile.readData("orderNumber"));
		SeleniumWebElements.enterInputIntoElement(trackingNum, ReadPropertiesFile.readData("trackingNum"));
		SeleniumWebElements.enterInputIntoElement(description, ReadPropertiesFile.readData("description"));
	}
	
	public void clickOnSaveButton() throws Exception
	{
		SeleniumWebElements.clickOnElement(saveBtn);
	}
}
