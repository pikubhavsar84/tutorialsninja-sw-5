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

public class DesktopPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement currencyLink;

    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktopsTab;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Show AllDesktops']")
    WebElement showAllDesktop;

    @CacheLookup
    @FindBy(xpath = "//select[@id='input-sort']")
    WebElement sortByNameZtoA;

    @CacheLookup
    @FindBy(xpath = "//h4/a")
    WebElement productsInDescendingOrderText;

    @CacheLookup
    @FindBy(xpath = "//select[@id='input-sort']")
    WebElement sortByNameAtoZ;

    @CacheLookup
    @FindBy(linkText = "HP LP3065")
    WebElement productHpLP3065;


    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'HP LP3065')]")
    WebElement getHPLP3065Text;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'input-group date']//button")
    WebElement deliveryDate;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-quantity']")
    WebElement enterQuantity;

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCart;


    @CacheLookup
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]")
    WebElement getProductAddedToShoppingCartText;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Shopping Cart')]")
    WebElement shoppingCart;

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement getShoppingCartText;

    @CacheLookup
    @FindBy(linkText = "HP LP3065")
    WebElement getHPLP3065Message;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")
    WebElement getDeliveryDateText;

    @CacheLookup
    @FindBy(xpath = "//td[contains(text(),'Product 21')]")
    WebElement getProduct21Text;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement getTotalPriceText;

    public void clickOnCurrencyLink(){
        clickOnElement(currencyLink);
        List<WebElement> currencyList = ManageBrowser.driver.findElements(By.xpath("//ul[@class = 'dropdown-menu']/li"));
        for (WebElement e : currencyList) {
            if (e.getText().equalsIgnoreCase("£ Pound Sterling")) {
                e.click();
                break;
            }
        }
    }
    public void mouseHoverOnDesktop(){
        Reporter.log("Mouse Hover On Desktop" + desktopsTab.toString());
        WebElement desktopsTAb;
        mouseHoverToElementAndClick(desktopsTab);
    }
    public void clickOnDesktop(){
        Reporter.log("click On Desktop" + desktopsTab.toString());
        clickOnElement(desktopsTab);
    }
    public void clickOnShowAllDesktop(){
        Reporter.log("click On Show All Desktop" + showAllDesktop.toString());
        clickOnElement(showAllDesktop);
    }
    public void sortByPositionNameZtoA(String text){
        Reporter.log("Sort " + text + " By Position NameZtoA" + sortByNameZtoA.toString());
        selectByVisibleTextFromDropDown(sortByNameZtoA,text);
    }
    public void getProductsArrangeInDescendingOrderText(){
        // Get all the products name and stored into array list
        List<WebElement> products = ManageBrowser.driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (Z - A)");
        products = ManageBrowser.driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        System.out.println(afterSortByZToAProductsName);

    }
    public void sortByPositionNameAtoZ(String text){
        Reporter.log("Sort " + text + " By Position NameAtoZ" + sortByNameAtoZ.toString());
        selectByVisibleTextFromDropDown(sortByNameAtoZ,text);
    }
    public void clickOnProductHPLP3065(){
        Reporter.log("Click On Product HPLP3065" + productHpLP3065.toString());
        clickOnElement(productHpLP3065);
    }
    public String getHPLP3065TextFromList(){
        Reporter.log("Get HPLP3065Text From List" + getHPLP3065Text.toString());
        return getTextFromElement(getHPLP3065Text);
    }
    public void clickOnDeliveryDate(){
        Reporter.log("Select Delivery Date" );
        String year = "2023";
        String month = "November";
        String date = "30";
        clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));
        while (true) {
            String monthAndYear = ManageBrowser.driver.findElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']"));
            }
        }
        List<WebElement> allDates = ManageBrowser.driver.findElements(By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }

    }
    public void enterQuantity1(String  num){
        Reporter.log("enter Quantity1" + enterQuantity.toString());
        ManageBrowser.driver.findElement(By.xpath("//input[@id='input-quantity']")).clear();
        sendTextToElement(enterQuantity,num);
    }
    public void clickOnAdToCart() {
        Reporter.log("Click On Add To Cart" + addToCart.toString());
        clickOnElement(addToCart);
    }
    public String verifyProductAddedToShoppingCartText(){
        Reporter.log("verifyProductAddedToShoppingCartText" + getProductAddedToShoppingCartText.toString());
        return getTextFromElement(getProductAddedToShoppingCartText);
    }
    public void clickOnShoppingCart(){
        Reporter.log("clickOnShoppingCart" + shoppingCart.toString());
        clickOnElement(shoppingCart);
    }
    public String verifyTextShoppingCart(){
        Reporter.log("Verify Text ShoppingCart" + getShoppingCartText.toString());
        return getTextFromElement(getShoppingCartText);
    }
    public String verifyTextProductNameHPLP3065(){
        Reporter.log("VerifyTextProductNameHPLP3065" + getHPLP3065Message.toString());
        return getTextFromElement(getHPLP3065Message);
    }
    public String verifyDeliveryDate(){
        Reporter.log("verifyDeliveryDate" + getDeliveryDateText.toString());
        return getTextFromElement(getDeliveryDateText);
    }
    public String verifyTheModelProduct21Text(){
        Reporter.log("Verify TheModelProduct21 Text" + getProduct21Text.toString());
        return getTextFromElement(getProduct21Text);
    }
    public String verifyTheTotalPriceText(){
        Reporter.log("verifyTheTotalPriceText" + getTotalPriceText.toString());
        return getTextFromElement(getTotalPriceText);
    }


}
