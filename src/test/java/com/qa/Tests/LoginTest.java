package com.qa.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.baseTest.BaseTest;
import com.qa.pages.Homepage;
import com.qa.pages.LoginPage;


public class LoginTest extends BaseTest {
	
	
	@Test
    public void testValidLogin() {
        // driver comes from BaseTest (already initialized in @BeforeClass)
		// Step 1: Create LoginPage object using driver from BaseTest
		LoginPage loginPage = new LoginPage(driverManger);
		Homepage homepage;
	
			homepage = loginPage.login(
					properties.getProperty("username"),
					properties.getProperty("password")
			);
			
			String actualTitle = homepage.getHomepageTitle();
//			System.out.println(actualTitle);
			Assert.assertEquals(actualTitle, "Products", "Homepage title mismatch!");
		
//		Assert.assertEquals(homepage.getHomepageTitle(), "Login failed - Homepage did not load");
	}

       


}