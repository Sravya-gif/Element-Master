## Design_Document of Element Master

## Framework Type
Page Object Model (POM)

## Features
- Config-driven execution using config.properties
- Reusable Page methods using POM design
- FluentWait for handling dynamic elements
- WebDriverManager for browser setup
- Screenshot capture on test failure
- ExtentReports for HTML reporting
- TestNG for test execution and annotations
- Clean separation of Base, Pages, Tests, and Utils

---

## Project Structure
```
ElementMaster
│
├── src/main/java
│   ├── com.srm.base
│   │   ├── BasePage.java
│   │   └── BaseTest.java
│   │
│   ├── com.srm.pages
│   │   ├── AlertPage.java
│   │   ├── FormPage.java
│   │   ├── FramePage.java
│   │   ├── WebTablePage.java
│   │   └── WidgetPage.java
│   │
│   ├── com.srm.utils
│   │   ├── ConfigReader.java
│   │   ├── ExtentManager.java
│   │   └── ScreenshotUtil.java
│
├── src/main/resources
│   └── config.properties
│
├── src/test/java
│   ├── com.srm.listeners
│   │   └── TestListener.java
│   │
│   └── com.srm.tests
│       ├── AlertTest.java
│       ├── FormTest.java
│       ├── FrameTest.java
│       ├── WebTableTest.java
│       └── WidgetTest.java
│
├── reports
├── screenshots
├── testng.xml
├── pom.xml
```

## Test Coverage

- Forms Module
- Web Tables Module
- Alerts Module
- Frames Module
- Widgets Module

---

## Tools & Technologies

- Java
- Selenium WebDriver
- TestNG
- Maven
- WebDriverManager
- ExtentReports
