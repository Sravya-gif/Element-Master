package com.srm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.srm.base.BasePage;

public class WebTablePage extends BasePage {

    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    By elements = By.xpath("//h5[text()='Elements']");
    By webTable = By.xpath("//span[text()='Web Tables']");
    By addBtn = By.id("addNewRecordButton");

    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By email = By.id("userEmail");
    By age = By.id("age");
    By salary = By.id("salary");
    By dept = By.id("department");
    By submit = By.id("submit");

    By search = By.id("searchBox");
    By deleteBtn = By.xpath("(//span[@title='Delete'])[1]");

    public void openTable() {
        safeClick(elements);
        safeClick(webTable);
    }

    public void addRecord() {

        safeClick(addBtn);

        type(firstName, "Sravya");
        type(lastName, "Alahari");
        type(email, "sravya@test.com");
        type(age, "22");
        type(salary, "50000");
        type(dept, "AT");

        safeClick(submit);

        wait.until(driver ->
            driver.findElements(By.id("example-modal-sizes-title-lg")).size() == 0
        );

        wait.until(driver ->
            driver.getPageSource().contains("Sravya")
        );
    }

    public void searchRecord(String name) {
        type(search, name);

        wait.until(driver ->
            driver.getPageSource().contains(name)
        );
    }

    public void deleteRecord() {
        safeClick(deleteBtn);
    }

    public boolean isRecordPresent(String name) {
        return driver.getPageSource().contains(name);
    }
}