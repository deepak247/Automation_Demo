package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Homepage {
	
	protected WebDriver driverManger;
	
	@FindBy(xpath="//span[@class='title']")
	protected WebElement homepageTitle;
	
	public Homepage(WebDriver driverManger) {
		this.driverManger = driverManger;
		PageFactory.initElements(driverManger, this);
	}
	
	public String getHomepageTitle() {
		WebDriverWait wait = new WebDriverWait(driverManger, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(homepageTitle));
		System.out.println(homepageTitle.getText());
		return homepageTitle.getText();
	}
	
	

}
