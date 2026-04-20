package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.FramePage;

public class FrameTest extends BaseTest {

    @Test
    public void testFrame() {

        FramePage fp = new FramePage(driver);

        fp.openFrames();
        String text = fp.getFrameText();

        Assert.assertEquals(text, "This is a sample page");
        System.out.println("Frame Test Passed");
    }
}