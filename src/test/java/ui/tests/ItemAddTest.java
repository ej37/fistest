package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.base.BaseUiTest;
import ui.pages.HomePage;
import ui.pages.ProductPage;
import utils.Log;

public class ItemAddTest extends BaseUiTest {

    @Test(description = "Verify item can be added to Cart")
    public void verifyItemCanBeAddedToCart() throws InterruptedException {
        Log.info("Starting test: verifyItemCanBeAddedToCart");

        HomePage homePage= new HomePage();
        homePage.openEbayHomePage();

        homePage.search("book");
        homePage.clickFirstSearchResult();

        ProductPage productPage= new ProductPage();
        productPage.clickAddToCartButton();
        productPage.waitForItemAddedToCartPopup();
        productPage.closePopUp();

        int actualCartCount= productPage.getCartItemCount();
        Assert.assertEquals(actualCartCount, 1);

    }
}
