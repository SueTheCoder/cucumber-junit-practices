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


public class Library_stepDef {

    WebDriver driver = Driver.getDriver();
    Library_login library = new Library_login();

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        System.out.println("User is on the login page");
        driver.get(ConfigurationReader.getProperty("libraryURL"));
    }

    @When("I enter username {string}")
    public void iEnterUsername(String username) {
        library.emailInput.sendKeys(username);
        BrowserUtils.sleep(1);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        library.passwordInput.sendKeys(password);
        library.signIn.click();
        BrowserUtils.sleep(1);
    }


    @Then("I should see the dashboard")
    public void iShouldSeeTheDashboard() {
        BrowserUtils.sleep(5);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Library";
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @And("I click {string} link")
    public void iClickLink(String menuLinks) {
        BrowserUtils.sleep(2);
        WebElement menu = driver.findElement(By.xpath("//span[.='"+ menuLinks + "']"));
        menu.click();
    }

    @And("I see to records dropdown value should be {string} by default")
    public void iSeeToRecordsDropdownValueShouldBeByDefault(String value) {
        Select select = new Select(library.recordsDropdown);
        select.selectByVisibleText(value);
        System.out.println("select.getFirstSelectedOption().getText() = " + select.getFirstSelectedOption().getText());
        Assert.assertEquals(select.getFirstSelectedOption().getText(), value);
    }

    @Then("I should see the records should have following options:")
    public void iShouldSeeTheRecordsShouldHaveFollowingOptions(List<String> showRecordDropdown) {
        List<WebElement> columns = driver.findElements(By.xpath("//select[@name='tbl_users_length']/option"));
        List<String> actual = new ArrayList<>();
        for (WebElement each : columns) {
            System.out.println(each.getText());
            actual.add(each.getText());
        }
        Assert.assertEquals(actual, showRecordDropdown);
    }

    @Then("I should have following columns in the table:")
    public void iShouldHaveFollowingColumnsInTheTable(List<String> tableElements) {
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
