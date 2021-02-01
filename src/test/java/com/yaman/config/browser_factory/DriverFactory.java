package com.yaman.config.browser_factory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {

	private static WebDriver driver;

	public DriverFactory() {
	}

	/**
	 * Recebe o tipo de driver a ser instanciado
	 * 
	 * @FIREFOX
	 * @CHROME
	 * @IE
	 * @SAFARI
	 */
	public static WebDriver getDriver(DriverType type) {

		if (driver == null) {
			switch (type) {
			case FIREFOX:
				getGeckoDriver();
				break;
			case CHROME:
				getChromeDriver();
				break;
			case IE:
				getIExplorerDriver();
				break;
			case EDGE:
				getEdgeDriver();
				break;
			default:
				getChromeDriver();
				break;
			}
		}
		return driver;
	}
	
	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

	private static void getGeckoDriver() {
		FirefoxOptions options = new FirefoxOptions();
		options.addPreference("dom.webnotifications.enabled", true);
		options.addPreference("geo.enabled", true);
		options.addPreference("geo.provider.use_corelocation", true);
		options.addPreference("geo.prompt.testing", true);
		options.addPreference("geo.prompt.testing.allow", true);
		driver = new FirefoxDriver(options);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	private static void getIExplorerDriver() {
		driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	private static void getEdgeDriver() {
		System.setProperty("webdriver.edge.driver","src\\test\\resources\\drivers\\msedgedriver.exe"); //put actual location
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	private static void getChromeDriver() {
		ChromeOptions options = new ChromeOptions();
		Map < String, Object > prefs = new HashMap < String, Object > ();
		Map < String, Object > profile = new HashMap < String, Object > ();
		Map < String, Object > contentSettings = new HashMap < String, Object > ();
		
		options.addArguments("test-type");
		options.addArguments("--disable-infobars");
		options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation", "load-extension"));
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-extensions");
		options.addArguments("ignore-certificate-errors");
		options.addArguments("--allow-running-insecure-content");
		options.addArguments("--incognito");
		//0 - default / 1- allow / 2- deny
		contentSettings.put("geolocation", 1);
	    profile.put("managed_default_content_settings", contentSettings);
	    prefs.put("profile", profile);
	    options.setExperimentalOption("prefs", prefs);
		
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
}
