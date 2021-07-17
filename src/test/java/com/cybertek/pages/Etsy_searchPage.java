package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Etsy_searchPage {

    WebDriver driver = Driver.getDriver();

    public Etsy_searchPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "global-enhancements-search-query")
    public WebElement searchBox;

    @FindBy(xpath = "//button[@data-id='gnav-search-submit-button']")
    public WebElement searchButton;

}
