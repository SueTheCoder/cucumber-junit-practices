package com.cybertek.step_definitions;

import com.cybertek.pages.Etsy_searchPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Etsy_stepDefinitions {

    Etsy_searchPage etsy = new Etsy_searchPage();

    @Given("User is on the Etsy landing page")
    public void user_is_on_the_etsy_landing_page() {
        String etsyURL = ConfigurationReader.getProperty("etsyURL");
        Driver.getDriver().get(etsyURL);
    }

    @Given("User should see Etsy title as expected")
    public void user_should_see_etsy_title_as_expected() {
        String expectedTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        String actualTitle= Driver.getDriver().getTitle();
        Assert.assertTrue("Title is not expected!!!", expectedTitle.equals(actualTitle));
    }

    @When("User types {string} in the search box")
    public void user_types_in_the_search_box(String searchItem) {
        etsy.searchBox.sendKeys(searchItem);
    }

    @When("User clicks search button")
    public void user_clicks_search_button() {
        etsy.searchButton.click();
    }

    @Then("User sees {string} is in the title")
    public void user_sees_is_in_the_title(String actualTitle) {
        String expectedTitle = "Wooden spoon | Etsy";
        Assert.assertTrue("Wrong Title!", expectedTitle.equals(actualTitle));
    }


}
