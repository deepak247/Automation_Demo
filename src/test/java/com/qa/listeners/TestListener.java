package com.qa.listeners;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.baseTest.BaseTest;
import com.qa.Utils.Screenshot;

public class TestListener implements ITestListener {
	@Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        BaseTest base = (BaseTest) testClass;   // cast to access driver

        String testName = result.getMethod().getMethodName();
        Screenshot.caputreScreenshot(base.driverManger, testName);

        System.out.println("Test Failed: " + testName + " — screenshot captured");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getMethod().getMethodName());
    }

}
