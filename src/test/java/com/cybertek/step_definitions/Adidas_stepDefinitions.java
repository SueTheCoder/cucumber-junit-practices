package com.cybertek.step_definitions;

import com.cybertek.pages.Adidas_pages;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class Adidas_stepDefinitions {

    Adidas_pages adidasPage = new Adidas_pages();
    int expectedPurchaseAmount = 0;
    String orderID;
    int purchaseAmount;

    @Given("User is on the Home Page")
    public void user_is_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("AdidasURL"));
    }

    @When("User adds {string} from {string}")
    public void user_adds_from(String product, String category) {
        expectedPurchaseAmount += adidasPage.productAdder(category,product);
        System.out.println("expectedPurchaseAMount = " + expectedPurchaseAmount);
    }

    @When("User removes {string} from cart")
    public void user_removes_from_cart(String product) {
        expectedPurchaseAmount -= adidasPage.productRemover(product);
        System.out.println("expectedPurchaseAMount = " + expectedPurchaseAmount);
    }

    @When("User places order and captures and logs purchase ID and Amount")
    public void user_places_order_and_captures_and_logs_purchase_id_and_amount() {
        adidasPage.cart.click();
        adidasPage.placeButton.click();
        adidasPage.fillForm();
        adidasPage.purchaseButton.click();

        String confirmation = adidasPage.confirmation.getText();
        System.out.println("confirmation = " + confirmation);
        String[] confirmationArray = confirmation.split("\n");
        orderID = confirmationArray[0];
        System.out.println("orderID = " + orderID);
        purchaseAmount = Integer.parseInt(confirmationArray[1].split(" ")[1]);
    }

    @Then("User verifies purchase amount equals expected")
    public void user_verifies_purchase_amount_equals_expected() {
        int actualAmount = purchaseAmount;
        System.out.println("actualAmount = " + actualAmount);
        System.out.println("expectedOrderAmount = " + expectedPurchaseAmount);
        Assert.assertEquals(expectedPurchaseAmount,actualAmount);
        BrowserUtils.sleep(1);
        adidasPage.OK.click();
        BrowserUtils.sleep(1);
        Driver.closeDriver();
    }

}
