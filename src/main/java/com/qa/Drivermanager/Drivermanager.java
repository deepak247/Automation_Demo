package com.qa.Drivermanager;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drivermanager {
	 protected Properties properties;
	protected WebDriver driver;
	protected String browserName;
	
//	public Drivermanager(Properties properties, WebDriverManager driverManager, String browserName) {
//		this.properties =properties;
//		this.driverManager = driverManager;
//		this.browserName = browserName;
//	}
//	
	public WebDriver  setupDriver(Properties prop) throws IOException {
//		properties=new Properties();
//		FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") +"/resources/config.properties");
//		properties.load(fileInputStream);
		browserName = prop.getProperty("browser");
		if(browserName != null && browserName.equalsIgnoreCase("chrome")) {
			// Ensure driver binary is available before creating ChromeDriver
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Please pass the correct browser name: "+browserName);
		}
		
		// maximize the browser window if driver initialized
		if (driver != null) {
			driver.manage().window().maximize();
			String url = prop.getProperty("Url");
			if (url != null) {
				driver.get(url.trim());
			}
		}

		return driver;
		return driver;
		
	}
	
	public Properties  init_prop() throws IOException {
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") +"/resources/config/config.properties");
		properties= new Properties();
		properties.load(ip);
		
		return properties;
		
		
		
	}
	
	
	

}
