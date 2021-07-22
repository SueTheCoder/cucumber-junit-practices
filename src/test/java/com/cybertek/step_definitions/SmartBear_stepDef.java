package com.cybertek.step_definitions;

import com.cybertek.pages.SmartBear_pages;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SmartBear_stepDef {

    WebDriver driver = Driver.getDriver();
    SmartBear_pages smartBearPages = new SmartBear_pages();


    @Given("User is logged into SmartBear Tester account")
    public void user_is_logged_into_smart_bear_tester_account() {
        driver.get(ConfigurationReader.getProperty("smartBearURL"));
        smartBearPages.username.sendKeys("Tester");
        smartBearPages.password.sendKeys("test");
        smartBearPages.loginButton.click();
        BrowserUtils.sleep(1);
    }

    @And("User clicks {string} menu")
    public void userClicksMenu(String menu) {
        WebElement menuOrder = driver.findElement(By.xpath("//a[.='" + menu + "']"));
        menuOrder.click();
    }

    @Given("User selects {string} from product dropdown")
    public void user_selects_from_product_dropdown(String product) {
        Select select = new Select(smartBearPages.productDropdownMenu);
        select.selectByVisibleText(product);
        BrowserUtils.sleep(1);
    }

    @And("User enters {string} to quantity")
    public void userEntersToQuantity(String quantity) {
        smartBearPages.quantity.sendKeys(quantity);
        BrowserUtils.sleep(1);
    }

    @Given("User enters {string} to costumer name")
    public void user_enters_to_costumer_name(String name) {
        smartBearPages.name.sendKeys(name);
        BrowserUtils.sleep(1);
    }

    @Given("User enters {string} to street")
    public void user_enters_to_street(String street) {
        smartBearPages.street.sendKeys(street);
        BrowserUtils.sleep(1);
    }

    @Given("User enters {string} to city")
    public void user_enters_to_city(String city) {
        smartBearPages.city.sendKeys(city);
        BrowserUtils.sleep(1);
    }

    @Given("User enters {string} to state")
    public void user_enters_to_state(String state) {
        smartBearPages.state.sendKeys(state);
        BrowserUtils.sleep(1);
    }

    @And("User enters {string}")
    public void userEnters(String zip) {
        smartBearPages.zip.sendKeys(zip);
        BrowserUtils.sleep(1);
    }

    @Given("User selects {string} as card type")
    public void user_selects_as_card_type(String cardType) {
        Actions actions = new Actions(driver);
        actions.click(smartBearPages.cardType).perform();
        BrowserUtils.sleep(1);
    }

    @Given("User enters {string} to card number")
    public void user_enters_to_card_number(String cardNumber) {
        smartBearPages.cardNumber.sendKeys(cardNumber);
        BrowserUtils.sleep(1);
    }

    @Given("User enters {string} to expiration date")
    public void user_enters_to_expiration_date(String expDate) {
        smartBearPages.expireDate.sendKeys(expDate);
        BrowserUtils.sleep(1);
    }

    @Given("User clicks process button")
    public void user_clicks_process_button() {
        smartBearPages.processButton.click();
        BrowserUtils.sleep(1);
    }

    @Then("User verifies {string} is in the list")
    public void user_verifies_is_in_the_list(String name) {
        WebElement verifyNameInTheList = driver.findElement(By.xpath("//td[.='"+ name +"']"));
        String expectedName = name;
        String actualName = verifyNameInTheList.getText();
        Assert.assertEquals("The name is not on the list", expectedName, actualName);
    }



}
