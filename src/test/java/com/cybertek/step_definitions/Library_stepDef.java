package com.cybertek.step_definitions;

import com.cybertek.pages.Library_login;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Library_stepDef {

    WebDriver driver = Driver.getDriver();
    Library_login library = new Library_login();

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        System.out.println("User is on the login page");
        driver.get(ConfigurationReader.getProperty("libraryURL"));
    }

    @When("User enters username {string}")
    public void userEntersUsername(String username) {
        library.emailInput.sendKeys(username);
    }

    @And("User enters password {string}")
    public void userEntersPassword(String password) {
        library.passwordInput.sendKeys(password);
        library.signIn.click();
        BrowserUtils.sleep(1);
    }


    @Then("User should see the dashboard")
    public void user_should_see_the_dashboard() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Library";
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @When("User clicks {string} link")
    public void user_clicks_link(String menuLinks) {
        WebElement menu = driver.findElement(By.xpath("//span[.='"+ menuLinks + "']"));
        menu.click();
    }
/*
    @Then("User should see the records should have following options:")
    public void user_should_see_the_records_should_have_following_options(List<String> dataTable) {
        List<WebElement> columns = Driver.getDriver().findElements(By.xpath("//th"));
        List<String> actual = new ArrayList<>();
        for (WebElement each : columns) {
            System.out.println(each.getText());
            actual.add(each.getText());
        }
        Assert.assertEquals(actual, dataTable);
    }

 */


    @And("User sees to records dropdown value should be {string} by default")
    public void userSeesToRecordsDropdownValueShouldBeByDefault(String value) {
        Select select = new Select(library.recordsDropdown);
        select.selectByVisibleText(value);
        System.out.println("select.getFirstSelectedOption().getText() = " + select.getFirstSelectedOption().getText());
        Assert.assertEquals(select.getFirstSelectedOption().getText(), value);

    }

    @Then("User should see the records should have following options:")
    public void userShouldSeeTheRecordsShouldHaveFollowingOptions(List<String> showRecordDropdown) {
        List<WebElement> columns = driver.findElements(By.xpath("//select[@name='tbl_users_length']/option"));
        List<String> actual = new ArrayList<>();
        for (WebElement each : columns) {
            System.out.println(each.getText());
            actual.add(each.getText());
        }
        Assert.assertEquals(actual, showRecordDropdown);
    }

    @Then("User should have following columns in the table:")
    public void userShouldHaveFollowingColumnsInTheTable(List<String> tableElements) {
        List<WebElement> tableHeads = driver.findElements(By.xpath("//th"));
        List<String> actual = new ArrayList<>();
        for (WebElement each : tableHeads) {
            System.out.println(each.getText());
            actual.add(each.getText());
        }
        Assert.assertEquals(actual, tableElements);
    }


    @When("I enter {string} and {string}")
    public void i_enter_and(String username, String password) {
        library.emailInput.sendKeys(username);
        library.passwordInput.sendKeys(password);
        library.signIn.click();
        BrowserUtils.sleep(1);
    }

    @Then("user should see their {string} on account section")
    public void user_should_see_their_on_account_section(String username) {
        String actualDisplay = library.usernameDisplay.getText();
        Assert.assertTrue(username.contains(actualDisplay));
        System.out.println(username + " - " + actualDisplay);
    }

}
