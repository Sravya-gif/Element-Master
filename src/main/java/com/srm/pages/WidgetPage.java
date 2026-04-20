package com.srm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.srm.base.BasePage;

public class WidgetPage extends BasePage {

    public WidgetPage(WebDriver driver) {
        super(driver);
    }

    By widgets = By.xpath("//h5[text()='Widgets']");
    By datePickerMenu = By.xpath("//span[text()='Date Picker']");
    By dateInput = By.id("datePickerMonthYearInput");

    By month = By.className("react-datepicker__month-select");
    By year = By.className("react-datepicker__year-select");

    public By day(String d) {
        return By.xpath("//div[contains(@class,'react-datepicker__day') and not(contains(@class,'outside-month')) and text()='" + d + "']");
    }

    public void openDatePicker() {

        safeClick(widgets);

        waitForElement(datePickerMenu);

        scrollIntoView(datePickerMenu);

        safeClick(datePickerMenu);
    }

    public void selectDate() {

        safeClick(dateInput);

        waitForElement(month).sendKeys("April");
        waitForElement(year).sendKeys("2026");

        safeClick(day("20"));
    }

    public String getDate() {
        return waitForElement(dateInput).getAttribute("value");
    }
}