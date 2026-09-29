package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.Element;
import utils.Log;

public class ProductPage {

    private final Element addToCartButton= new Element(By.xpath("//span[normalize-space()='Add to cart']/ancestor::div[1]"));
    private final Element addToCartDialog= new Element(By.xpath("//div[contains(@class,'lightbox-dialog')]//span[text()='Added to cart']"));
    private final Element addToCartDialogCloseButton= new Element(By.xpath("//div[contains(@class,'lightbox-dialog')]//span[text()='Added to cart']/../../../button[@aria-label='Close dialog']"));
    private final Element cartCountBadge= new Element(By.xpath("//div[contains(@class,'right-aligned')]/a[@href='https://cart.ebay.com']//span[contains(@class,'badge')]"));

    @Step("Click on add to cart button on product page")
    public void clickAddToCartButton(){
        addToCartButton.click();
    }

    @Step("Wait for item Added to cart popup to appear")
    public void waitForItemAddedToCartPopup(){
        try{
            addToCartDialog.waitForElementVisible();
        }catch(Exception e){
            Log.error("Pop up dialog box did not appear");
        }
    }

    @Step("Close the pop up dialog box")
    public void closePopUp(){
        addToCartDialogCloseButton.click();

    }

    @Step("Get item count number on cart")
    public int getCartItemCount(){
        String badgeCount= cartCountBadge.getText().trim();
        return Integer.parseInt(badgeCount);
    }



}
