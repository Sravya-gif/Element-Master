package com.srm.base;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

public class BasePage {

    protected WebDriver driver;
    protected FluentWait<WebDriver> wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;

        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    public WebElement waitForElement(By locator) {
        return wait.until(driver -> {
            WebElement element = driver.findElement(locator);
            return element.isDisplayed() ? element : null;
        });
    }

    public void click(By locator) {
        waitForElement(locator).click();
    }

    public void type(By locator, String text) {
        WebElement element = waitForElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public String getText(By locator) {
        return waitForElement(locator).getText();
    }

    public String getAttribute(By locator, String attr) {
        return waitForElement(locator).getAttribute(attr);
    }

    public void scrollIntoView(By locator) {
        WebElement element = waitForElement(locator);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void safeClick(By locator) {
        WebElement element = waitForElement(locator);
        scrollIntoView(locator);

        try {
            element.click();
        } catch (Exception e) {
        
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", element);
        }
    }

    public void jsClick(By locator) {
        WebElement element = waitForElement(locator);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);
    }

    public Alert switchToAlert() {
        return wait.until(driver -> driver.switchTo().alert());
    }

    public void switchToFrame(By locator) {
        driver.switchTo().frame(waitForElement(locator));
    }

    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }

    public void waitForPageLoad() {
        wait.until(driver ->
            ((JavascriptExecutor) driver)
                .executeScript("return document.readyState")
                .equals("complete")
        );
    }
}