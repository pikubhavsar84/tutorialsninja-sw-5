package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.DesktopPage;
import com.tutorialsninja.demo.pages.LaptopAndNoteBooksPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LaptopsAndNoteBooksPageTest extends BaseTest {
    LaptopAndNoteBooksPage laptopsAndNotebooksPage;
    DesktopPage desktopPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        laptopsAndNotebooksPage = new LaptopAndNoteBooksPage();
        desktopPage = new DesktopPage();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully(){
        laptopsAndNotebooksPage.mouseHoverOnLaptopsAndDesktopTab();
        laptopsAndNotebooksPage.clickOnShowAllLaptopsAndNotebooks();
        laptopsAndNotebooksPage.sortByPriceHighToLow();
        laptopsAndNotebooksPage.GetSortByHighToLowOrder();
    }

    @Test(groups = {"smoke","regression"})
    public void verifyThatUserPlaceOrderSuccessfully()throws InterruptedException{
        //laptopsAndNotebooksPage.clickOnCurrencyLink();
        laptopsAndNotebooksPage.mouseHoverOnLaptopsAndDesktopTab();
        laptopsAndNotebooksPage.clickOnShowAllLaptopsAndNotebooks();
        laptopsAndNotebooksPage.sortByPriceHighToLow();
        laptopsAndNotebooksPage.clickOnMacBookTab();
        laptopsAndNotebooksPage.clickOnAddToCartButton();
        String expectedText = "Success: You have added MacBook to your shopping cart!\n"+"×";
        Assert.assertEquals(laptopsAndNotebooksPage.getSuccessTextFromLink(),expectedText,"Error Message not displayed");
        laptopsAndNotebooksPage.clickOnShoppingCart();
        Assert.assertEquals(laptopsAndNotebooksPage.getShoppingCartMessage(),"Shopping Cart","Message not displayed");
        Assert.assertEquals(laptopsAndNotebooksPage.getVerifyProductMacbook(),"MacBook","Message not displayed");

        Actions actions1 = new Actions(driver);
        WebElement quantity = driver.findElement(By.xpath("//input[contains(@name, 'quantity')]"));
        quantity.clear();
        sendTextToElement(By.xpath("//input[contains(@name, 'quantity')]"), "2");

        laptopsAndNotebooksPage.clickOnUpdateCart();
        String expectedMessage = "Success: You have modified your shopping cart!\n"+"×";
        Assert.assertEquals(laptopsAndNotebooksPage.getSuccessModifiedCartMessage(),expectedMessage,"Message not displayed");

        laptopsAndNotebooksPage.clickOnCurrency();
        laptopsAndNotebooksPage.clickOnPoundSterling();
        Assert.assertEquals(laptopsAndNotebooksPage.getVerifyTotal(),"£737.45","Price Not displayed");
        laptopsAndNotebooksPage.clickOnCheckoutButton();
        Assert.assertEquals(laptopsAndNotebooksPage.getCheckoutText(),"Checkout","Message not displayed");
        Thread.sleep(2000);
        String expectedNewCustomer = "New Customer";
        Assert.assertEquals(laptopsAndNotebooksPage.getNewCustomerText(),expectedNewCustomer,"Message not displayed");
        laptopsAndNotebooksPage.clickOnGuestCheckoutRadioButton();
        laptopsAndNotebooksPage.clickOnContinueTab();
        laptopsAndNotebooksPage.enterName("john");
        laptopsAndNotebooksPage.enterLastName("david");
        laptopsAndNotebooksPage.enterEmail("johndavid123@gmail.com");
        laptopsAndNotebooksPage.enterTelephone("07700017017");
        laptopsAndNotebooksPage.enterAddress("111, Harrow Road");
        laptopsAndNotebooksPage.enterCity("London");
        laptopsAndNotebooksPage.enterPostcode("HA3 8RP");
        laptopsAndNotebooksPage.enterCountry();
        laptopsAndNotebooksPage.enterZone();
        laptopsAndNotebooksPage.clickOnContinueButton();
        laptopsAndNotebooksPage.enterTextToTextArea("Please confirm delivery date");
        laptopsAndNotebooksPage.clickOnTermsAndConditionsCheckbox();
        laptopsAndNotebooksPage.clickOnFinalContinueButton();
        String expectedPaymentText = "Warning: Payment method required!"+"×";
        Assert.assertEquals(laptopsAndNotebooksPage.getWarningPaymentMethodRequiredText(),
                expectedPaymentText,
                "Message not displayed");
    }

}
