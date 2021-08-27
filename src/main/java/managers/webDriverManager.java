package managers;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
//import enums.EnvironmentType;

public class webDriverManager {
	
	private static  WebDriver driver;

	public WebDriver getDriver() {
		if(driver == null) driver = createRemoteDriver();
		return driver;
	}

	public WebDriver createRemoteDriver() {		
        	WebDriverManager.chromedriver().clearCache();
    		WebDriverManager.chromedriver().setup();
    		// Create a map to store preferences
    		Map<String, Object> prefs = new HashMap<String, Object>();
    		// add key and value to map as follow to switch off browser notification
    		// Pass the argument 1 to allow and 2 to block
    		prefs.put("profile.default_content_setting_values.notifications", 2);
    		// Create an instance of ChromeOptions
    		ChromeOptions options = new ChromeOptions();
    		// set ExperimentalOption - prefs
    		options.setExperimentalOption("prefs", prefs);
    		driver = new ChromeDriver(options);
    		driver.manage().deleteAllCookies();
     
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
	}


	public void closeDriver() {
		driver.close();
		driver.quit();
	}

}