package stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.WebDriverManagers;
import managers.Xls_Reader;
import managers.driverUtilities;
import pageObjects.CrmPage;

import java.io.File;
import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.TestContext;

public class CrmSteps {

	TestContext testContest;
	CrmPage eSubmitssion;
	driverUtilities baseMethod;
	Scenario scenario;
	Xls_Reader reader;

	public CrmSteps(TestContext context) throws Exception {
		testContest = context;
		eSubmitssion = testContest.getPageObjectManager().geteClaimSubmissionPage();
		baseMethod = testContest.getPageObjectManager().getdriverMethod();
	}

	@Before
	private void before(Scenario scenario) {

	}

	@When("^Launch esasy Claim page$")
	public void launchEsasyClaimPage() throws Throwable {
		eSubmitssion.launchPage("https://www.servicenow.com/lpdem/demonow-all.html");
		
		

	}

	@When("^User checks agree terms$")
	public void userChecksAgreeTerms() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("^User click continue button$")
	public void userClickContinueButton() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

}
