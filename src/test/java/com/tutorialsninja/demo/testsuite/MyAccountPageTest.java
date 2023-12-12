package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.MyAccountPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class MyAccountPageTest extends BaseTest {
    MyAccountPage myAccountPage;
    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        myAccountPage = new MyAccountPage();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
        myAccountPage.clickOnMyAccountLink();
        myAccountPage.selectMyAccountOptions("Register");
        Assert.assertEquals(myAccountPage.getRegisterAccountMessage(),"Register Account","Message not displayed");
    }
    @Test(groups = {"smoke","regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
        myAccountPage.clickOnMyAccountLink();
        myAccountPage.selectMyAccountOptions("Login");
        Assert.assertEquals(myAccountPage.getReturningCustomerMessage(),"Returning Customer","Message not displayed");
    }
    @Test(groups = {"regression"})
    public void verifyThatUserRegisterAccountSuccessfully(){
        myAccountPage.clickOnMyAccountLink();
        myAccountPage.selectMyAccountOptions("Register");
        myAccountPage.enterFirstName("john");
        myAccountPage.enterLastName("david");
        myAccountPage.enterEmailId("johndavid123@gmail.com");
        myAccountPage.enterPhoneNumber("07700017017");
        myAccountPage.enterPassword("JohnDavid");
        myAccountPage.enterConfirmPassword("JohnDavid");
        myAccountPage.clickSubscribeOnYesRadioButton();
        myAccountPage.clickOnPrivacyPolicyCheckBox();
        myAccountPage.clickOnContinue1();
        Assert.assertEquals(myAccountPage.getAccountCreatedMessage(),"Your Account Has Been Created!","Message not displayed");
        myAccountPage.clickOnContinueButton2();
        myAccountPage.clickOnMyAccountTab();
        myAccountPage.selectMyAccountOptions("Logout");
        Assert.assertEquals(myAccountPage.getAccountLogoutMessage(),"Account Logout","Message not displayed");
        myAccountPage.clickOnContinueButton3();

    }
    @Test(groups = {"regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        myAccountPage.clickOnMyAccountLink();
        myAccountPage.selectMyAccountOptions("Login");
        myAccountPage.enterEmailId("johndavid123@gmail.com");
        myAccountPage.enterPassword("JohnDavid");
        myAccountPage.clickOnLogin();
        // Assert.assertEquals(myAccountPage.getMyAccountText(),"My Account","My account text not displayed");
        myAccountPage.clickOnMyAccountTab();
        myAccountPage.selectMyAccountOptions("Logout");
        Assert.assertEquals(myAccountPage.getAccountLogoutMessage(),"Account Logout","Account Logout text not displayed");
        myAccountPage.clickOnContinueButton3();
    }

}
