package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.CrmPage;

public class PageObjectManager {

	private WebDriver driver;
	private CrmPage eClaimSubmitPage;	
	private driverUtilities  baseDriver;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;

	}

	public driverUtilities getdriverMethod() throws Exception {
		return (baseDriver == null) ? baseDriver = new driverUtilities(driver) : baseDriver;
	}	
	
	
	public CrmPage geteClaimSubmissionPage() throws Exception {
		return (eClaimSubmitPage == null) ? eClaimSubmitPage = new CrmPage(driver)
				: eClaimSubmitPage;

	}
	
	
}