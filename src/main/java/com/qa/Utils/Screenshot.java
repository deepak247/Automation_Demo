package com.qa.Utils;

import java.io.File;
import java.nio.channels.SelectableChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot {
	
	public  static String caputreScreenshot(WebDriver driver ,String testName) {
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(0));
        String fileName = testName + "_" + timestamp + ".png";
        String screenshotDir = System.getProperty("user.dir") + "/screenshots/";
        String filePath = screenshotDir + fileName;
        
        try {
            // Ensure screenshots folder exists
            Files.createDirectories(Paths.get(screenshotDir));
            
            TakesScreenshot tS =(TakesScreenshot)driver;
            File sourcesFiles = tS.getScreenshotAs(OutputType.FILE);
            File destFile = new File(filePath);
            Files.copy(sourcesFiles.toPath(), destFile.toPath());
            System.out.println("Screenshot saved: " + filePath);
        }
        
        catch (Exception e) {
			// TODO: handle exception
        	System.out.println("Failed to capture screenshot: " + e.getMessage());
		}
        return filePath;
	}
	
	public void dropdownbyIndex(WebElement element, int index) {
		
		Select select = new Select(element);
		select.selectByIndex(index);
	}

}
