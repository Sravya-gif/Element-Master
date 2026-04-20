package com.srm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.srm.base.BasePage;

public class AlertPage extends BasePage {

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    By menu = By.xpath("//h5[text()='Alerts, Frame & Windows']");
    By alerts = By.xpath("//span[text()='Alerts']");

    By alertBtn = By.id("alertButton");
    By confirmBtn = By.id("confirmButton");
    By promptBtn = By.id("promtButton");

    By confirmResult = By.id("confirmResult");
    By promptResult = By.id("promptResult");

    public void openAlerts() {
        safeClick(menu);
        scrollIntoView(alerts);
        safeClick(alerts);
    }

    public void simpleAlert() {
        safeClick(alertBtn);
        switchToAlert().accept();
    }

    public void confirmDismiss() {
        safeClick(confirmBtn);
        switchToAlert().dismiss();
    }

    public void prompt(String text) {
        safeClick(promptBtn);
        switchToAlert().sendKeys(text);
        switchToAlert().accept();
    }

    public String getConfirmResult() {
        return getText(confirmResult);
    }

    public String getPromptResult() {
        return getText(promptResult);
    }
}