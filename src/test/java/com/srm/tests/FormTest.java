package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.FormPage;

public class FormTest extends BaseTest {

    @Test
    public void testFormSubmission() {

        FormPage fp = new FormPage(driver);

        fp.openForm();
        fp.fillForm("Sravya", "Test");
        fp.submitForm();

        Assert.assertTrue(fp.isFormSubmitted());

        System.out.println("Form Test Passed");
    }
}