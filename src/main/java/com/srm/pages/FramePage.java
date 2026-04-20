package com.srm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.srm.base.BasePage;

public class FramePage extends BasePage {

    public FramePage(WebDriver driver) {
        super(driver);
    }

    By menu = By.xpath("//h5[text()='Alerts, Frame & Windows']");
    By frameMenu = By.xpath("//span[text()='Frames']");
    By frame = By.id("frame1");
    By text = By.id("sampleHeading");

    public void openFrames() {
        safeClick(menu);

        scrollIntoView(frameMenu);

        safeClick(frameMenu);
    }

    public String getFrameText() {

        switchToFrame(frame);

        String t = getText(text);

        switchToDefault();

        return t;
    }
}