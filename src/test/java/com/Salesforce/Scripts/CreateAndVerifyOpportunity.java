package com.Salesforce.Scripts;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Salesforce.DataDrivers.ReadPropertiesFile;
import com.Salesforce.PomPages.HomePage;
import com.Salesforce.PomPages.LoginPage;
import com.Salesforce.PomPages.NewOpportunity;
import com.Salesforce.PomPages.OpportunityDetailsPage;
import com.Salesforce.PomPages.ProfilePage;
import com.Salesforce.driverBase.BaseTest;

public class CreateAndVerifyOpportunity {

	LoginPage loginPage ;
	HomePage homePage ;
	NewOpportunity newOpportunity ;
	OpportunityDetailsPage opportunityDetailsPage ;
	ProfilePage profilePage ;
	
	@BeforeClass
	public void setUp() throws IOException
	{
		BaseTest.launchBrowser(ReadPropertiesFile.readData("browserName"), ReadPropertiesFile.readData("url"));
	}
	
	@BeforeMethod
	public void signinToSalesforce()
	{
		loginPage = new LoginPage(BaseTest.getDriver());
		try {
			loginPage.loginTosalesforceApp(ReadPropertiesFile.readData("userName"), ReadPropertiesFile.readData("password"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void verifyOpportunities() throws Exception
	{
		homePage = new HomePage(BaseTest.getDriver());
		homePage.clickOnHeadertab("Opportunities");
		newOpportunity = new NewOpportunity(BaseTest.getDriver());
		newOpportunity.clickOnNewButton();
		newOpportunity.fillOpportunityDetails();
		newOpportunity.clickOnSaveButton();
		
		opportunityDetailsPage= new OpportunityDetailsPage(BaseTest.getDriver());
		opportunityDetailsPage.clickOnDetailsTab();
		opportunityDetailsPage.verifyOpportunityDetails();
		
	}
	
	@AfterMethod
	public void signOutToSalesforce()
	{
		profilePage = new ProfilePage(BaseTest.getDriver());
		profilePage.signOutFromSalesforce();
	}
	
	@AfterClass
	public void tearDown() {
		BaseTest.getDriver().close();
	}
}
