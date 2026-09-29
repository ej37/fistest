package ui.base;

import config.ConfigManager;
import driver.DriverFactory;
import driver.DriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Log;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Arrays;

public class BaseUiTest {

    String browserName= ConfigManager.getValue("browser.name");

    @BeforeMethod
    public void setUp(){
        Log.info("Initiating WebDriver instance");
        DriverManager.setDriver(DriverFactory.initiateDriver(browserName));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result){
        DriverManager.quitDriver();

    }


}
