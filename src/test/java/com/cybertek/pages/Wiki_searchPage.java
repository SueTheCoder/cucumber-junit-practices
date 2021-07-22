package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Wiki_searchPage {

    WebDriver driver = Driver.getDriver();


    public Wiki_searchPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "searchInput")
    public WebElement searchBox;

    @FindBy(xpath = "//button[@class='pure-button pure-button-primary-progressive']")
    public WebElement submitButton;

    @FindBy(id = "firstHeading")
    public WebElement mainHeader;

    @FindBy(xpath = "//div[@id='mw-content-text']/div/table/tbody/tr/th/div[.='Steve Jobs']")
    public WebElement imageHeader;

}
