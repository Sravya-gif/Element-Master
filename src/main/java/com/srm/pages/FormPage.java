package com.srm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.srm.base.BasePage;

public class FormPage extends BasePage {

    public FormPage(WebDriver driver) {
        super(driver);
    }

    By forms = By.xpath("//h5[text()='Forms']");
    By practiceForm = By.xpath("//span[text()='Practice Form']");
    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By gender = By.xpath("//label[text()='Female']");
    By mobile = By.id("userNumber");
    By submit = By.id("submit");

    By modal = By.id("example-modal-sizes-title-lg"); 

    public void openForm() {
        safeClick(forms);
        safeClick(practiceForm);
    }

    public void fillForm(String f, String l) {
        type(firstName, f);
        type(lastName, l);
        safeClick(gender);
        type(mobile, "9876543210");
    }

    public void submitForm() {
        scrollIntoView(submit);
        jsClick(submit);
    }

    public boolean isFormSubmitted() {
        return waitForElement(modal).isDisplayed();
    }
}