package com.cybertek.step_definitions;

import com.cybertek.pages.Library_login;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class DataTables_stepDefinitions {

    WebDriver driver = Driver.getDriver();
    Library_login libraryLogin = new Library_login();

    @Then("user should see below words displayed")
    public void user_should_see_below_words_displayed(Map<String, String> listOfFruits) {
        System.out.println("listOfFruits = " + listOfFruits);
    }

    //======================================================


    @Given("user is on the login page of library app")
    public void user_is_on_the_login_page_of_library_app() {
        driver.get(ConfigurationReader.getProperty("libraryURL"));
    }

    @When("user enters username and password as below")
    public void user_enters_username_and_password_as_below(Map<String, String> loginInfo) {
        libraryLogin.emailInput.sendKeys(loginInfo.get("username"));
        libraryLogin.passwordInput.sendKeys(loginInfo.get("password"));
        libraryLogin.signIn.click();
        BrowserUtils.sleep(2);
    }

    @Then("user should see title is Library")
    public void user_should_see_title_is_library() {
        String expectedTitle = "Library";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }



}
