package driver;

import config.ConfigManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    static boolean isHeadless= Boolean.parseBoolean(ConfigManager.getValue("browser.headless"));

    public static WebDriver initiateDriver(String browserName ){
        if(browserName.equals("chrome")) {
            ChromeOptions options= new ChromeOptions();

            //handle security and webpage bot detection
            options.setExperimentalOption("useAutomationExtension", false);
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);

            options.addArguments("--disable-blink-features=AutomationControlled");
            options.addArguments("--disable-infobars");
            options.addArguments("--start-maximized");
            options.addArguments("--disable-extensions");
            options.addArguments("--remote-allow-origins=*");


            if(isHeadless)
                options.addArguments("-headless=new");
            options.addArguments("--start-maximized");
            return new ChromeDriver(options);
        }

        if(browserName.equals("firefox")) {
            FirefoxOptions options= new FirefoxOptions();
            if(isHeadless)
                options.addArguments("-headless=new");
            return new FirefoxDriver(options);
        }

        throw new IllegalArgumentException("Unsupported browser provided: "+ browserName);
    }
}
