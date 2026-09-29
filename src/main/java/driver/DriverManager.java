package driver;

import org.openqa.selenium.WebDriver;
import utils.Log;

import java.util.Set;

public class DriverManager {

    public static ThreadLocal<WebDriver> driverThreadLocal= new ThreadLocal<>();

    public static void setDriver(WebDriver webDriver){
        driverThreadLocal.set(webDriver);
    }

    public static WebDriver getDriver(){
        return driverThreadLocal.get();
    }

    public static void switchToNewWindow(){
        String mainWindow= getDriver().getWindowHandle();

        Set<String> allWindowsHandles = getDriver().getWindowHandles();

        for(String windowHandle: allWindowsHandles){
            if(!windowHandle.equals(mainWindow)){
                getDriver().switchTo().window(windowHandle);
                Log.info("Switched to new browser tab");
                break;
            }
        }
    }

    public static void switchtoSpecificWindow(String windowHandle){
        getDriver().switchTo().window(windowHandle);
    }

    public static void quitDriver(){
        WebDriver driver = driverThreadLocal.get();
        if(driver!= null){
            try {
                driver.quit();
                Log.info("WebDriver session successfully closed.");
            } catch (Exception e) {
                Log.error("Error while quitting WebDriver: " + e.getMessage());
            } finally {
                driverThreadLocal.remove();
            }
        }
    }
}
