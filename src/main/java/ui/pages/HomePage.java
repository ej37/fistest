package ui.pages;

import config.ConfigManager;
import driver.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.Element;

import java.util.List;

public class HomePage {

    private final Element searchBar= new Element(By.xpath("//input[@title='Search']"));
    private final Element searchResults= new Element(By.xpath("//ul[contains(@class,'results')]/li//a"));
    private final Element cart= new Element(By.xpath(""));

    @Step("Opening the homepage of Ebay")
    public void openEbayHomePage(){
        DriverManager.getDriver().get(ConfigManager.getValue("ui.baseUrl"));
    }

    @Step("Search for the given text in Search bar and press enter")
    public void search(String searchText){
        searchBar.type(searchText);
        searchBar.pressEnter();
    }

    @Step("Click on the first item from search result list")
    public void clickFirstSearchResult(){
        searchResults.click(1);
        DriverManager.switchToNewWindow();
    }


}
