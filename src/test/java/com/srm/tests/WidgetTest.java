package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.WidgetPage;

public class WidgetTest extends BaseTest {

    @Test
    public void testDatePicker() {

        WidgetPage wp = new WidgetPage(driver);

        wp.openDatePicker();
        wp.selectDate();

        Assert.assertTrue(wp.getDate().contains("04/20/2026"));

        System.out.println("Date Picker Passed");
    }
}