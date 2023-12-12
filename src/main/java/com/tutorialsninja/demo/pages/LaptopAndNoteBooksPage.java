package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.browserfactory.ManageBrowser;
import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopAndNoteBooksPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement currencyLink;

    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopsAndDesktopTab;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Show AllLaptops & Notebooks')]")
    WebElement showAllLaptopsAndNotebooksTab;

    @CacheLookup
    @FindBy(xpath = "//select[@id='input-sort']")
    WebElement sortByPriceHighToLow;

    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    WebElement getSortByHighToLowOrder;

    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement macBookTab;

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCartButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement getSuccessMessage;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Shopping Cart')]")
    WebElement shoppingCartLink;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Shopping Cart')]")
    WebElement getShoppingCartText;

    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement getProductMacBookText;

    @CacheLookup
    @FindBy(xpath = "//input[contains(@name, 'quantity')]")
    WebElement changeQuantityTo2;

    @CacheLookup
    @FindBy(xpath = "//button[contains(@data-original-title, 'Update')]")
    WebElement updateTab;

    @CacheLookup
    @FindBy(xpath = "//div[@id='checkout-cart']/div[1]")
    WebElement getMessageModifiedCart;

    @CacheLookup
    @FindBy(xpath = "//tbody/tr[1]/td[6]")
    WebElement getTotalPriceText;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Checkout')]")
    WebElement checkoutButton;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Checkout')]")
    WebElement getCheckoutText;

    @CacheLookup
    @FindBy(xpath = "//div[@class='col-sm-6']//h2")
    WebElement getNewCustomerText;

    @CacheLookup
    @FindBy(xpath = "//input[@name='account' and @value='guest']")
    WebElement guestCheckoutRadioButton;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-account']")
    WebElement continueTab;

    @CacheLookup
    @FindBy(name = "firstname")
    WebElement nameField;

    @CacheLookup
    @FindBy(name = "lastname")
    WebElement lastnameField;

    @CacheLookup
    @FindBy(id = "input-payment-email")
    WebElement emailField;

    @CacheLookup
    @FindBy(name = "telephone")
    WebElement telephone;

    @CacheLookup
    @FindBy(name = "address_1")
    WebElement address1;

    @CacheLookup
    @FindBy(name = "city")
    WebElement cityName;

    @CacheLookup
    @FindBy(name = "postcode")
    WebElement postCode;

    @CacheLookup
    @FindBy(xpath = "//a[@id='ui-id-23']//select[@id='input-payment-country']")
    WebElement countryName;

    @CacheLookup
    @FindBy(css = "//select[@id='input-payment-zone']")
    WebElement zoneName;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-guest']")
    WebElement continueButton;

    @CacheLookup
    @FindBy(xpath = "//textarea[@name='comment']")
    WebElement addCommentsToTextArea;

    @CacheLookup
    @FindBy(name = "agree")
    WebElement termsAndConditionsCheckBox;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-payment-method']")
    WebElement finalContinueButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement getPaymentMethodMessage;

    @CacheLookup
            @FindBy(xpath = "//span[normalize-space()='Currency']")
            WebElement currency;
    @CacheLookup
            @FindBy(xpath ="//button[normalize-space()='£Pound Sterling']" )
            WebElement poundSterling;

    public void clickOnCurrency(){
        clickOnElement(currency);
    }
    public void clickOnPoundSterling() {
        Reporter.log("Click On poundSterling" + poundSterling);
        clickOnElement(poundSterling);
    }


    public void mouseHoverOnLaptopsAndDesktopTab() {
        Reporter.log("MouseHover On LaptopsAndDesktopTab" + laptopsAndDesktopTab.toString());
        mouseHoverToElementAndClick(laptopsAndDesktopTab);
    }

    public void clickOnShowAllLaptopsAndNotebooks() {
        Reporter.log("clickOnShowAllLaptopsAndNotebooks" + showAllLaptopsAndNotebooksTab.toString());
        clickOnElement(showAllLaptopsAndNotebooksTab);
    }

    public void sortByPriceHighToLow() {
        Reporter.log("Sort By PriceHighToLow" + sortByPriceHighToLow.toString());
        selectByVisibleTextFromDropDown(sortByPriceHighToLow, "Price (High > Low)");
    }

    public String GetSortByHighToLowOrder() {
        List<WebElement> products = ManageBrowser.driver.findElements(By.xpath("//p[@class ='price']"));
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(originalProductsPrice);
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        System.out.println(originalProductsPrice);
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (Low > High)");
        products = ManageBrowser.driver.findElements(By.xpath("//p[@class ='price']"));
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(afterSortByPrice);
        return null;
    }

    public void clickOnCurrencyLink() {
        clickOnElement(currencyLink);
        List<WebElement> currencyList = ManageBrowser.driver.findElements(By.xpath("//ul[@class = 'dropdown-menu']/li"));
        for (WebElement e : currencyList) {
            if (e.getText().equalsIgnoreCase("£ Pound Sterling")) {
                e.click();
                break;
            }
        }
    }

    public void clickOnMacBookTab() {
        Reporter.log("Click On MacBookTab" + macBookTab.toString());
        clickOnElement(macBookTab);
    }

    public void clickOnAddToCartButton() {
        Reporter.log("Click On AddToCartButton" + addToCartButton.toString());
        clickOnElement(addToCartButton);
    }

    public String getSuccessTextFromLink() {
        Reporter.log("Get SuccessText From Link" + getSuccessMessage.toString());
        return getTextFromElement(getSuccessMessage);
    }

    public void clickOnShoppingCart() {
        Reporter.log("Click On ShoppingCart" + shoppingCartLink.toString());
        clickOnElement(shoppingCartLink);
    }

    public String getShoppingCartMessage() {
        Reporter.log("get ShoppingCart Message" + getShoppingCartText.toString());
        return getTextFromElement(getShoppingCartText);
    }

    public String getVerifyProductMacbook() {
        Reporter.log("Get VerifyProduct Macbook" + getProductMacBookText.toString());
        return getTextFromElement(getProductMacBookText);
    }

    public void changeQuantityTo2() {
        ManageBrowser.driver.findElement(By.xpath("//input[contains(@name, 'quantity')]")).clear();
    }

    public void sendTextChangeQuantityTo2(String text) {
        Reporter.log("sendTextChangeQuantityTo2" + changeQuantityTo2.toString());
        sendTextToElement(changeQuantityTo2, "text");
    }

    public void clickOnUpdateCart() {
        Reporter.log("Click On UpdateCart" + updateTab.toString());
        clickOnElement(updateTab);
    }

    public String getSuccessModifiedCartMessage() {
        Reporter.log("getSuccessModifiedCartMessage" + getMessageModifiedCart.toString());
        return getTextFromElement(getMessageModifiedCart);
    }

    public String getVerifyTotal() {
        Reporter.log("Get VerifyTotal" + getTotalPriceText.toString());
        return getTextFromElement(getTotalPriceText);
    }

    public void clickOnCheckoutButton() {
        Reporter.log("Click On CheckoutButton" + checkoutButton.toString());
        clickOnElement(checkoutButton);
    }

    public String getCheckoutText() {
        Reporter.log("Get Checkout Text" + getCheckoutText.toString());
        return getTextFromElement(getCheckoutText);
    }

    public String getNewCustomerText() {
        Reporter.log("Get NewCustomer Text" + getNewCustomerText.toString());
        return getTextFromElement(getNewCustomerText);
    }

    public void clickOnGuestCheckoutRadioButton() {
        Reporter.log("Click On GuestCheckoutRadioButton" + guestCheckoutRadioButton.toString());
        clickOnElement(guestCheckoutRadioButton);
    }

    public void clickOnContinueTab() {
        Reporter.log("Click On ContinueTab" + continueTab.toString());
        clickOnElement(continueTab);
    }

    public void enterName(String name) {
        Reporter.log("Enter Name " + name + " in firstname field" + nameField.toString());
        sendTextToElement(nameField, name);
    }

    public void enterLastName(String lastname) {
        Reporter.log("Enter LastName " + lastname + " in lastname field " + lastnameField.toString());
        sendTextToElement(lastnameField, lastname);
    }

    public void enterEmail(String email) {
        Reporter.log("Enter Email  " + email + " to email field" + emailField.toString());
        sendTextToElement(emailField, email);
    }

    public void enterTelephone(String phone) {
        Reporter.log("Enter Telephone " + phone + " in telephone field " + phone);
        sendTextToElement(telephone, phone);
    }

    public void enterAddress(String street) {
        Reporter.log("enter Address" + address1);
        sendTextToElement(address1, street);
    }

    public void enterCity(String city) {
        Reporter.log("Enter City " + cityName.toString());
        sendTextToElement(cityName, city);
    }

    public void enterPostcode(String code) {
        Reporter.log("Enter Postcode" + postCode.toString());
        sendTextToElement(postCode, code);
    }

    public void enterCountry() {
        Reporter.log("enter Country" + countryName.toString());
        selectByValueFromDropDown(countryName, "United Kingdom");
    }

    public void enterZone() {
        Reporter.log("enter Zone" + zoneName.toString());
        selectByValueFromDropDown(zoneName,"Greater London");
    }

    public void clickOnContinueButton() {
        Reporter.log("clickOnContinueButton" + continueButton.toString());
        clickOnElement(continueButton);
    }

    public void enterTextToTextArea(String message) {
        Reporter.log("enterTextToTextArea" + addCommentsToTextArea.toString());
        sendTextToElement(addCommentsToTextArea, message);
    }

    public void clickOnTermsAndConditionsCheckbox() {
        Reporter.log("clickOnTermsAndConditionsCheckbox" + termsAndConditionsCheckBox.toString());
        clickOnElement(termsAndConditionsCheckBox);
    }

    public void clickOnFinalContinueButton() {
        Reporter.log("clickOnFinalContinueButton" + finalContinueButton.toString());
        clickOnElement(finalContinueButton);
    }

    public String getWarningPaymentMethodRequiredText() {
        Reporter.log("getWarningPaymentMethodRequiredText" + getPaymentMethodMessage.toString());
        return getTextFromElement(getPaymentMethodMessage);
    }

}

