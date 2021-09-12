package cucumber;

import managers.PageObjectManager;
import managers.WebDriverManagers;

public class TestContext {
	private WebDriverManagers driverManager;
	private PageObjectManager pageObjectManager;

	public TestContext() throws Exception {
		driverManager = new WebDriverManagers();
		pageObjectManager = new PageObjectManager(driverManager.getDriver());
	
	}
	
	
	public WebDriverManagers getWebDriverManager() {
		return driverManager;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

}