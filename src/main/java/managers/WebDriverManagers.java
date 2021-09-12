package managers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import dataProvider.ConfigFileReader;
import enums.DriverType;
import enums.EnvironmentType;
//import enums.EnvironmentType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagers {

	private WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	private static final String FIREFOX_DRIVER_PROPERTY = "webdriver.gecko.driver";
	private static final String IE_DRIVER_PROPERTY = "webdriver.ie.driver";

	public WebDriverManagers() {
		driverType = ConfigFileReader.getInstance().getBrowser();
		environmentType = ConfigFileReader.getInstance().getEnvironment();
	}

	public WebDriver getDriver() throws MalformedURLException {
		if (driver == null)
			driver = createDriver();
		return driver;
	}

	private WebDriver createDriver() throws MalformedURLException {
		switch (environmentType) {
		case LOCAL:
			driver = createLocalDriver();
			break;
		case REMOTE:
			driver = createRemoteDriver();
			break;
		case BONIGARCIA:
			driver = createBonigarciaDrivers();
			break;
		}
		return driver;
	}

	private WebDriver createRemoteDriver() throws MalformedURLException {
		switch (driverType) {
		case FIREFOX:
			DesiredCapabilities fcap = DesiredCapabilities.firefox();
			FirefoxOptions fOptions = new FirefoxOptions();
			fOptions.setBinary(ConfigFileReader.getInstance().getFirefoxBinary());
			fcap.setCapability(FirefoxOptions.FIREFOX_OPTIONS, fOptions);
			driver = new RemoteWebDriver(new URL(ConfigFileReader.getInstance().getHub()),fcap);
			driver.manage().deleteAllCookies();
			
			break;
		case CHROME:			
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			Map<String, Object> prefs = new HashMap<String, Object>();
			// Pass the argument 1 to allow and 2 to block
			prefs.put("profile.default_content_setting_values.notifications", 2);
			ChromeOptions options = new ChromeOptions();
			options.setBinary(ConfigFileReader.getInstance().getChromeBinary());
			options.setHeadless(true);
			options.setExperimentalOption("prefs", prefs);
			cap.setCapability(ChromeOptions.CAPABILITY, options);	
			driver = new RemoteWebDriver(new URL(ConfigFileReader.getInstance().getHub()), cap);		
			driver.manage().deleteAllCookies();
			break;
		case INTERNETEXPLORER:
			WebDriverManager.iedriver().arch32().setup();
			driver = new InternetExplorerDriver();
			break;
		}
		if (ConfigFileReader.getInstance().getWindowSize())
			driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(ConfigFileReader.getInstance().getImplicitlyWait(), TimeUnit.SECONDS);
		return driver;
	}

	public WebDriver createBonigarciaDrivers() {
		switch (driverType) {
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case CHROME:

			WebDriverManager.chromedriver().setup();
			// Create a map to store preferences
			Map<String, Object> prefs = new HashMap<String, Object>();
			// Pass the argument 1 to allow and 2 to block
			prefs.put("profile.default_content_setting_values.notifications", 2);
			// Create an instance of ChromeOptions
			ChromeOptions options = new ChromeOptions();
			// set ExperimentalOption - prefs
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
			driver.manage().deleteAllCookies();
			break;
		case INTERNETEXPLORER:
			WebDriverManager.iedriver().arch32().setup();
			driver = new InternetExplorerDriver();
			break;
		}
		if (ConfigFileReader.getInstance().getWindowSize())
			driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(ConfigFileReader.getInstance().getImplicitlyWait(), TimeUnit.SECONDS);
		return driver;
	}

	private WebDriver createLocalDriver() {
		switch (driverType) {
		case FIREFOX:
			System.setProperty(FIREFOX_DRIVER_PROPERTY, ConfigFileReader.getInstance().getFirefoxPath());
			DesiredCapabilities cap = new DesiredCapabilities();
			FirefoxOptions options = new FirefoxOptions();
			options.setCapability("marionette", true);
			driver = new FirefoxDriver(options);
			break;
		case CHROME:
			System.setProperty(CHROME_DRIVER_PROPERTY, ConfigFileReader.getInstance().getChromePath());
			Map<String, Object> prefs = new HashMap<String, Object>();
			// Pass the argument 1 to allow and 2 to block
			prefs.put("profile.default_content_setting_values.notifications", 2);
			ChromeOptions chrome_options = new ChromeOptions();
			// set ExperimentalOption - prefs
			chrome_options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(chrome_options);
			break;
		case INTERNETEXPLORER:
			System.setProperty(IE_DRIVER_PROPERTY, ConfigFileReader.getInstance().getIEPath());
			InternetExplorerOptions ieOptions = new InternetExplorerOptions();
			ieOptions.introduceFlakinessByIgnoringSecurityDomains();
			ieOptions.ignoreZoomSettings();
			driver = new InternetExplorerDriver(ieOptions);
			break;
		}

		if (ConfigFileReader.getInstance().getWindowSize())
			driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(ConfigFileReader.getInstance().getImplicitlyWait(), TimeUnit.SECONDS);
		return driver;
	}

	public void closeDriver() {
		driver.close();
		driver.quit();
	}

}