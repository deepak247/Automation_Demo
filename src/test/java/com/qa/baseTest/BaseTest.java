package com.qa.baseTest;


import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.qa.Drivermanager.Drivermanager;

import com.qa.pages.*;

public class BaseTest {
	
	public WebDriver driverManger;
	protected Properties properties;
	Drivermanager driverManager;
	
	@BeforeClass
	public void setup() throws IOException {
		driverManager = new Drivermanager();
		properties = driverManager.init_prop();
		driverManger = driverManager.setupDriver(properties);
		LoginPage loginPage = new LoginPage(driverManger);
		
	}
	
	@AfterClass
	public void teardown() {
		if (driverManger != null) {
			driverManger.quit();
		}
		
	}


}
