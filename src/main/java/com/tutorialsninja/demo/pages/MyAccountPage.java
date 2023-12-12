package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.browserfactory.ManageBrowser;
import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class MyAccountPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccountLink;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement getRegisterAccountText;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
    WebElement getReturningCustomerText;
    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement firstName;

    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lastName;

    @CacheLookup
    @FindBy(id = "input-email")
    WebElement enterEmailId;
    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement enterPhoneNumber;
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement enterPassword;

    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement confirmPassword;

    @CacheLookup
    @FindBy(xpath = "//input[@name='newsletter']")
    WebElement subscribeYesRadioButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@name='agree']")
    WebElement privacyPolicyCheckBox;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@value='Continue']")
    WebElement clickOnContinueButton;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement getAccountCreatedText;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueButton2;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccount2;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement getAccountLogoutText;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueButton3;

    @CacheLookup
    @FindBy(xpath = "//form[contains(@action,'login')]//input[@type='submit']")
    WebElement loginButton;


    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'My Account')]")
    WebElement getMyAccountText;




    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = ManageBrowser.driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = ManageBrowser.driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        }
    }

    public void clickOnMyAccountLink() {
        Reporter.log("click On MyAccount Link " + myAccountLink);
        clickOnElement(myAccountLink);

    }

    public String getRegisterAccountMessage() {
        Reporter.log("getRegisterAccountMessage" + getRegisterAccountText.toString());
        return getTextFromElement(getRegisterAccountText);
    }

    public String getReturningCustomerMessage() {
        Reporter.log("getReturningCustomerMessage" + getReturningCustomerText);
        return getTextFromElement(getReturningCustomerText);
    }

    public void enterFirstName(String name) {
        Reporter.log("Enter First Name " + name + " in field" + firstName.toString());
        sendTextToElement(firstName, name);
    }

    public void enterLastName(String lastname) {
        Reporter.log("Enter First Name " + lastname + " in field" + lastName.toString());
        sendTextToElement(lastName, lastname);
    }

    public void enterEmailId(String email) {
        Reporter.log("Enter " + email + " EmailId" + enterEmailId.toString());
        sendTextToElement(enterEmailId, email);
    }

    public void enterPhoneNumber(String phone) {
        Reporter.log("Enter " + phone + "Phone Number" + enterPhoneNumber.toString());
        sendTextToElement(enterPhoneNumber, phone);
    }

    public void enterPassword(String password) {
        Reporter.log("Enter Password " + password + " in password field" + enterPassword.toString());
        sendTextToElement(enterPassword, password);
    }

    public void enterConfirmPassword(String confirmPword) {
        Reporter.log("enter ConfirmPassword " + confirmPassword.toString());
        sendTextToElement(confirmPassword, confirmPword);
    }

    public void clickSubscribeOnYesRadioButton() {
        Reporter.log("clickSubscribeOnYesRadioButton " + subscribeYesRadioButton.toString());
        clickOnElement(subscribeYesRadioButton);
    }

    public void clickOnPrivacyPolicyCheckBox() {
        Reporter.log("clickOnPrivacyPolicyCheckBox" + privacyPolicyCheckBox.toString());
        clickOnElement(privacyPolicyCheckBox);
    }

    public void clickOnContinue1() {
        Reporter.log("clickOnContinue1" + clickOnContinueButton.toString());
        clickOnElement(clickOnContinueButton);
    }

    public String getAccountCreatedMessage() {
        Reporter.log("getAccountCreatedMessage" + getAccountCreatedText.toString());
        return getTextFromElement(getAccountCreatedText);
    }

    public void clickOnContinueButton2() {
        Reporter.log("clickOnContinueButton2" + continueButton2.toString());
        clickOnElement(continueButton2);
    }

    public void clickOnMyAccountTab() {
        Reporter.log("clickOnMyAccountTab" + myAccount2.toString());
        clickOnElement(myAccount2);
    }

    public String getAccountLogoutMessage() {
        Reporter.log("getAccountLogoutMessage" + getAccountLogoutText.toString());
        return getTextFromElement(getAccountLogoutText);
    }

    public void clickOnContinueButton3() {
        Reporter.log("click On Continue Button3" + continueButton3.toString());
        clickOnElement(continueButton3);
    }

    public void clickOnLogin() {
        Reporter.log("clickOnLogin" + loginButton.toString());
        clickOnElement(loginButton);
    }

    public String getMyAccountText() {
        Reporter.log("getMyAccountText" + getMyAccountText.toString());
        return getTextFromElement(getMyAccountText);
    }

}
