package cucumber;

import managers.PageObjectManager;
import managers.webDriverManager;

public class TestContext {
	private webDriverManager driverManager;
	private PageObjectManager pageObjectManager;

	public TestContext() {
		driverManager = new webDriverManager();
		pageObjectManager = new PageObjectManager(driverManager.getDriver());
	
	}
	
	
	public webDriverManager getWebDriverManager() {
		return driverManager;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

}