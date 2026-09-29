# Automation Framework

A Java-based UI and API automation framework built using Selenium WebDriver, Rest Assured, TestNG, Maven, REST Assured, and Allure Reports.

The framework is designed to provide reusable components for browser management, page objects, element interactions,api clients, configuration, logging, test execution, and reporting.

---

## Tech Stack

| Technology | Version |
|------------|---------|
| Java | 11 |
| Selenium WebDriver | 4.41.0 |
| TestNG | 7.12.0 |
| Maven | 3.x |
| Allure Reports | 2.29.1 |
| REST Assured | 5.3.0 |

---

## Framework Features/ Approach Used

- Selenium WebDriver for UI automation
- REST Assured for API automation
- TestNG for test execution
- Page Object Model for maintainable test design
- DTO for handling api request and responses
- Reusable Selenium element utilities
- Centralized WebDriver management with parallel execution
- Configuration management
- Log4j2 logging
- Allure reporting with proper steps and failure screenshot
- Maven-based execution

---

## Prerequisites
- Java 11 
- Maven
- Allure
- Chrome (or Firefox Browser)
- Project has been created in IntellijIDEA but can be opened in any Java- compatible IDE
- Handle browser and headless in src/main/resources/config/qaconfig.yaml

## Run test
```bash
mvn clean test
```

## Check allure results
```bash
allure serve target/allure-results
```