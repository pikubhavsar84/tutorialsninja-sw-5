package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class TopMenuPage extends Utility {
    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktopTab;

    @CacheLookup
    @FindBy(xpath = "//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*")
    WebElement selectMenu;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Desktops')]")
    WebElement desktopText;

    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopsAndNotebooksTab;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement laptopsAndNotebooksText;

    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement componentsTab;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Components')]")
    WebElement componentsText;


    public void selectMenu(String menu) {
        Reporter.log("Select menu " + selectMenu.toString());
        List<WebElement> topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        }
    }

    public void mouseHoverToElementAndClickOnDesktop() {
        Reporter.log(" Mousehover and Click on desktop " + desktopTab.toString());
        mouseHoverToElementAndClick(desktopTab);
    }

    public String getTextDesktop() {
        Reporter.log("get Text Desktop" + desktopText.toString());
        return getTextFromElement(desktopText);
    }

    public void mouseHoverOnLaptopsAndNotebooksTab() {
        Reporter.log("mouseHoverOnLaptopsAndNotebooksTab" + laptopsAndNotebooksTab.toString());
        mouseHoverToElementAndClick(laptopsAndNotebooksTab);
    }

    public String getLaptopsAndNotebooksText() {
        Reporter.log("getLaptopsAndNotebooksText" + laptopsAndNotebooksText.toString());
        return getTextFromElement(laptopsAndNotebooksText);
    }

    public void mouseHoverToComponentsTab() {
        Reporter.log("mouseHoverToComponentsTab" + componentsTab.toString());
        mouseHoverToElementAndClick(componentsTab);
    }

    public String getComponentsText() {
        Reporter.log("getComponentsText" + componentsText.toString());
        return getTextFromElement(componentsText);
    }


}
