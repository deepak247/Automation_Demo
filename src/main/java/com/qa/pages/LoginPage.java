package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v125.network.model.PrivateNetworkRequestPolicy;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {
	
	protected WebDriver driverManger;
	
	 // Step 1: Declare WebElements with @FindBy (NOT initialized here)
    @FindBy(id = "user-name")
    private WebElement usernameField;
    
    @FindBy(id="password")
    private WebElement passwordField;
    
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement loginButton;
    
    @FindBy(xpath = "//div[@class='app_logo']")
    private WebElement Logologin_page;
	
	public LoginPage(WebDriver driverManger) {
		this.driverManger = driverManger;
		 PageFactory.initElements(driverManger, this);

	}
	
	public Homepage login(String username ,String paswword) {
		usernameField.sendKeys(username);
		passwordField.sendKeys(paswword);
		loginButton.click();
		 return new Homepage(driverManger);
	}
	

	

}
