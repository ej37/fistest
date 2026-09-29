package utils;

import config.ConfigManager;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Element {
    private final By locator;

    private String globalTimeout= ConfigManager.getValue("timeout.globalTimeout");
    private final Duration timeout= Duration.ofSeconds(Integer.valueOf(globalTimeout));


    public Element(By locator){
        this.locator= locator;
    }

    private WebDriverWait waitForElement(){
        return new WebDriverWait(DriverManager.getDriver(), timeout);
    }

    public WebElement findElement(){
        return waitForElement().until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public List<WebElement> findElements(){
        return waitForElement().until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public WebElement getElementFromList(int index){
        List<WebElement> elements= findElements();
        if(index>elements.size())
            throw new IndexOutOfBoundsException("Index not found in total elements");

        return elements.get(index-1);
    }

    public WebElement waitForElementClickable(){
        return waitForElement().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForElementVisible() {
        return waitForElement().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void click(){
        Log.info("Clicking element: "+ locator);
        waitForElementClickable().click();
    }

    public void click(int index){
        Log.info("Clicking element "+ locator+" based on index: "+ index);
        WebElement elementToClick= getElementFromList(index);
        elementToClick.click();
    }

    public String getText(){
        Log.info("Fetching text from element: "+ locator);
        return waitForElementVisible().getText();
    }

    public void type(String text){
        Log.info("Typing the text into element: "+ locator);
        WebElement element= waitForElementVisible();
        element.clear();
        element.sendKeys(text);
    }

    public void pressEnter(){
        Log.info("Pressing Enter key");
        WebElement element= waitForElementVisible();
        element.sendKeys(Keys.ENTER);
    }

    public boolean isDisplayed(){
        Log.info("Verfying if the element: "+ locator+ " is displayed");
        try {
            return waitForElementVisible().isDisplayed();
        }
        catch (Exception e) {
            return false;
        }
    }

    public boolean isEnabled(){
        Log.info("Verfying if the element: "+ locator+ " is enabled");
        try {
            return waitForElementVisible().isEnabled();
        }
        catch (Exception e) {
            return false;
        }
    }

    public boolean isSelected(){
        Log.info("Verfying if the element: "+ locator+ " is selected");
        try {
            return waitForElementVisible().isSelected();
        }
        catch (Exception e) {
            return false;
        }
    }


}
