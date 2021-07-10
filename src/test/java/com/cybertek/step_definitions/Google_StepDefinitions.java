package com.cybertek.step_definitions;

import com.cybertek.pages.GoogleSearchPage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Google_StepDefinitions {

    @Given("User is on google home page")
    public void user_is_on_google_home_page() throws InterruptedException {
        Driver.getDriver().get("https://www.google.com");
    }

    @Then("User should see title is Google")
    public void userShouldSeeTitleIsGoogle() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedInTitle = "Google";
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

    @When("User searches for apple")
    public void user_searches_for_apple() {
        GoogleSearchPage googleSearchPage = new GoogleSearchPage();
        googleSearchPage.searchBar.sendKeys("apple" + Keys.ENTER);
    }

    @Then("User should see apple in the title")
    public void user_should_see_apple_in_the_title() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedInTitle = "apple";
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }



}
