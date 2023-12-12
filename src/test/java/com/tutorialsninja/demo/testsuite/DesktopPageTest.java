package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.DesktopPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class DesktopPageTest extends BaseTest {
    DesktopPage desktopPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        desktopPage = new DesktopPage();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyProductArrangeInAlphaBaticalOrder()
{
        desktopPage.mouseHoverOnDesktop();
        desktopPage.clickOnDesktop();
        desktopPage.clickOnShowAllDesktop();
        desktopPage.sortByPositionNameZtoA("Name (Z - A)");
        desktopPage.getProductsArrangeInDescendingOrderText();

    }
    @Test(groups = {"smoke","regression"},dataProvider = "testdata", dataProviderClass = TestData.class)
    public void verifyProductAddedToShoppingCartSuccessFully(String product,String qty,String successMessage,String productName,String model,String total) throws InterruptedException {
        desktopPage.clickOnCurrencyLink();
        desktopPage.mouseHoverOnDesktop();
        desktopPage.clickOnShowAllDesktop();
        desktopPage.sortByPositionNameAtoZ("Name (A - Z)");
        desktopPage.clickOnProductHPLP3065();
        String expectedText = "HP LP3065";
        Assert.assertEquals(desktopPage.getHPLP3065TextFromList(),expectedText,"Product not found");
        desktopPage.clickOnDeliveryDate();
        desktopPage.enterQuantity1("1");
        desktopPage.clickOnAdToCart();

        String expectedProductText = "Success: You have added HP LP3065 to your shopping cart!" +
                "×";
        Assert.assertEquals(expectedProductText,desktopPage.verifyProductAddedToShoppingCartText());
        desktopPage.clickOnShoppingCart();
        Thread.sleep(2000);
        Assert.assertEquals(desktopPage.verifyTextShoppingCart(),"Shopping Cart  (1.00kg)","Error message not displayed");
        Assert.assertEquals(desktopPage.verifyTextProductNameHPLP3065(),"HP LP3065","Product name not displayed");
        Thread.sleep(2000);
        Assert.assertEquals(desktopPage.verifyDeliveryDate(),"Delivery Date: 2023-11-30","Delivery not displayed");
        Assert.assertEquals(desktopPage.verifyTheModelProduct21Text(),"Product 21","Message not displayed");
        Assert.assertEquals(desktopPage.verifyTheTotalPriceText(),"£74.73","Price not displayed");
    }
}

