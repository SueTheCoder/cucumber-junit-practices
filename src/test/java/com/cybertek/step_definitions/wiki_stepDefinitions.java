package com.cybertek.step_definitions;

import com.cybertek.pages.Wiki_searchPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class wiki_stepDefinitions {

    Wiki_searchPage wiki = new Wiki_searchPage();
    WebDriver driver = Driver.getDriver();

    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        String wikiURL = ConfigurationReader.getProperty("wikiURL");
        driver.get(wikiURL);
    }

    @When("User types {string} in the wiki search box")
    public void user_types_in_the_wiki_search_box(String searchThings) {
        wiki.searchBox.sendKeys(searchThings);
        BrowserUtils.sleep(1);
    }

    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        wiki.submitButton.click();
        BrowserUtils.sleep(1);
    }

    @Then("User sees {string} is in the wiki title")
    public void user_sees_is_in_the_wiki_title(String str) {
        String actualTitle = driver.getTitle();
        String expectedTitle = str + " - Wikipedia";
        Assert.assertEquals("Wrong Title", expectedTitle, actualTitle);
    }

    @Then("User sees {string} is in the main header")
    public void user_sees_is_in_the_main_header(String str) {
        String actualMainHeader = wiki.mainHeader.getText();
        String expectedMainHeader = str;
        Assert.assertEquals("Wrong Main Header", expectedMainHeader, actualMainHeader);
    }

    @Then("User sees {string} is in the image header")
    public void user_sees_is_in_the_image_header(String str) {
        String actualImageHeader = driver.findElement(By.xpath("//div[@id='mw-content-text']/div/table/tbody/tr/th/div[.='"+ str +"']")).getText();
        String expectedImageHeader = str;
        Assert.assertEquals("Wrong Image Header", expectedImageHeader, actualImageHeader);
        driver.navigate().back();
    }

}
