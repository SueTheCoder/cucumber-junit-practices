package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Library_login {

    WebDriver driver = Driver.getDriver();
    public Library_login() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "inputEmail")
    public WebElement emailInput;

    @FindBy(id = "inputPassword")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signIn;

    @FindBy(xpath = "//span[.='Dashboard']")
    public WebElement dashboard;

    @FindBy(xpath = "//a[@href='#users']")
    public WebElement usersLink;

}
