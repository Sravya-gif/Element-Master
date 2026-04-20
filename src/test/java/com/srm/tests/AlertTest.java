package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.AlertPage;

public class AlertTest extends BaseTest {

    @Test
    public void testAlerts() {

        AlertPage ap = new AlertPage(driver);

        ap.openAlerts();

        ap.simpleAlert();

        ap.confirmDismiss();
        Assert.assertTrue(ap.getConfirmResult().contains("Cancel"));

        ap.prompt("Hello");
        Assert.assertTrue(ap.getPromptResult().contains("Hello"));

        System.out.println("Alert Test Passed");
    }
}