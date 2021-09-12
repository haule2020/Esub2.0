package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.DriverType;
import enums.EnvironmentType;

//Config File Reader to get based info from Configuration.properties  file
public class ConfigFileReader {
	private Properties properties;
	private final String propertyFilePath = "configs//Configuration.properties";
	private static ConfigFileReader configReader;

	// Load config file
	private ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	// Implement Singleton Pattern
	public static ConfigFileReader getInstance() {
		return (configReader == null) ? configReader = new ConfigFileReader() : configReader;
	}

	// Get Base Url from Configuration file
	public String getBaseUrl() {
		String baseurl = properties.getProperty("baseUrl");
		if (baseurl != null) {
			return baseurl;
		} else {
			throw new RuntimeException(
					"Application Url not specified in the Configuration.properties file for the Key:url");
		}
	}

	// Get getChromePath
	public String getChromePath() {
		String chromePath = properties.getProperty("chromePath");
		if (chromePath != null) {
			return chromePath;
		} else {
			throw new RuntimeException(
					"chromePath Url not specified in the Configuration.properties file for the Key:chromePath");
		}
	}

	// Get getChromeBinary
	public String getChromeBinary() {
		String chromeBinary = properties.getProperty("chromeBinary");
		if (chromeBinary != null) {
			return chromeBinary;
		} else {
			throw new RuntimeException(
					"chromeBinary Url not specified in the Configuration.properties file for the Key:chromeBinary");
		}
	}

	// Get getIEPath
	public String getIEPath() {
		String iePath = properties.getProperty("iePath");
		if (iePath != null) {
			return iePath;
		} else {
			throw new RuntimeException(
					"ciePath Url not specified in the Configuration.properties file for the Key:iePath");
		}
	}

	// Get getIEBinary
	public String getIEBinary() {
		String ieBinary = properties.getProperty("ieBinary");
		if (ieBinary != null) {
			return ieBinary;
		} else {
			throw new RuntimeException(
					"ieBinary Url not specified in the Configuration.properties file for the Key:ieBinary");
		}
	}

	// Get getFirefoxPath
	public String getFirefoxPath() {
		String firefoxPath = properties.getProperty("firefoxPath");
		if (firefoxPath != null) {
			return firefoxPath;
		} else {
			throw new RuntimeException(
					"firefoxPath Url not specified in the Configuration.properties file for the Key:firefoxPath");
		}
	}

	// Get firefoxBinary
	public String getFirefoxBinary() {
		String firefoxBinary = properties.getProperty("firefoxBinary");
		if (firefoxBinary != null) {
			return firefoxBinary;
		} else {
			throw new RuntimeException(
					"firefoxBinary Url not specified in the Configuration.properties file for the Key:firefoxBinary");
		}
	}
	
	// Get getHub
	public String getHub() {
		String hub = properties.getProperty("hub");
		if (hub != null) {
			return hub;
		} else {
			throw new RuntimeException(
					"hub Url not specified in the Configuration.properties file for the Key: hub");
		}
	}
	
	// Get getWindowSize
	public Boolean getWindowSize() {
		String windowMaximize = properties.getProperty("windowMaximize");
		if (windowMaximize != null)
			return Boolean.valueOf(windowMaximize);
		return true;

	}

	// Get getImplicitlyWait
	public Long getImplicitlyWait() {
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if (implicitlyWait != null)
			return new Long(implicitlyWait);
		else {
			throw new RuntimeException(
					"implicitlyWait Url not specified in the Configuration.properties file for the Key: implicitlyWait");
		}

	}

	// Get DriverType
	public DriverType getBrowser() {
		String browser = properties.getProperty("browser");
		if (browser == null || browser.equalsIgnoreCase("chrome"))
			return DriverType.CHROME;
		else if (browser.equalsIgnoreCase("firefox"))
			return DriverType.FIREFOX;
		else if (browser.equalsIgnoreCase("iexplorer"))
			return DriverType.INTERNETEXPLORER;

		else {
			throw new RuntimeException(
					"browser not specified in the Configuration.properties file for the Key:browser: " + browser);
		}
	}

	// Get Environment Type
	public EnvironmentType getEnvironment() {
		String environment = properties.getProperty("environment");
		if (environment.contains("local"))
			return EnvironmentType.LOCAL;
		else if (environment.contains("remote"))
			return EnvironmentType.REMOTE;
		else if (environment == null || environment.contains("bonigarcia"))
			return EnvironmentType.BONIGARCIA;
		else {
			throw new RuntimeException(
					"environment not specified in the Configuration.properties file for the Key:environment: "
							+ environment);
		}
	}

}