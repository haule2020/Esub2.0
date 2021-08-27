package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.eClaimSubmission;

public class PageObjectManager {

	private WebDriver driver;
	private eClaimSubmission eClaimSubmitPage;	
	private driverUtilities  baseDriver;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;

	}

	public driverUtilities getdriverMethod() throws Exception {
		return (baseDriver == null) ? baseDriver = new driverUtilities(driver) : baseDriver;
	}	
	
	
	public eClaimSubmission geteClaimSubmissionPage() throws Exception {
		return (eClaimSubmitPage == null) ? eClaimSubmitPage = new eClaimSubmission(driver)
				: eClaimSubmitPage;

	}
	
	
}