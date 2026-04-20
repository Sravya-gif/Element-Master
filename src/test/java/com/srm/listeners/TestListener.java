package com.srm.listeners;

import org.testng.*;

import com.aventstack.extentreports.*;
import com.srm.base.BaseTest;
import com.srm.utils.*;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getReport();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
        
    }

    @Override
    public void onTestFailure(ITestResult result) {

        String path = ScreenshotUtil.capture(BaseTest.driver, result.getName());

        test.fail(result.getThrowable());

        if (path != null) {
            try {
                test.addScreenCaptureFromPath(path);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush(); 
    }
}