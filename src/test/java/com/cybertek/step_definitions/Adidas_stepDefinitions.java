package com.cybertek.step_definitions;

import com.cybertek.pages.Adidas_pages;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;


public class Adidas_stepDefinitions {
    /**
     * creating object to access pages class and we can use the methods, webElements and variables
     */
    Adidas_pages adidasPage = new Adidas_pages();
    int expectedPurchaseAmount = 0;
    String orderID;
    int purchaseAmount;
    int listPrice;
    int addingPrice;
    int cartPrice;


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

    @Then("Under {string} category user should see the list of products")
    public void under_category_user_should_see_the_list_of_products(String category, List<String> expectedProducts ) {
        Driver.getDriver().findElement(By.xpath("//a[.='" + category + "']")).click();
        BrowserUtils.sleep(2);
        // we're getting webElements of products from the page and putting their text into list of string
        List<String> actualProducts = BrowserUtils.getElementsText(adidasPage.products);

        System.out.println("actualProducts = " + actualProducts);
        System.out.println("expectedProducts = " + expectedProducts);
        Assert.assertEquals("verify the list of products failed", expectedProducts,actualProducts);
    }

    @When("User adds {string} from {string} to see the price")
    public void user_adds_from_to_see_the_price(String products, String category) {
        String locator = "//a[.='"+products+"']/../../h5";
        listPrice = Integer.parseInt(Driver.getDriver().findElement(By.xpath(locator)).getText().substring(1));
        addingPrice = adidasPage.productAdder(category,products);
    }

    @When("User removes {string} from cart to verify the price")
    public void user_removes_from_cart_to_verify_the_price(String products) {
        cartPrice = adidasPage.productRemover(products);
    }

    @Then("User verifies list and cart price are same and they are equal to {string}")
    public void user_verifies_list_and_cart_price_are_same_and_they_are_equal_to(String priceString) {
        int expectedPrice = Integer.parseInt(priceString);
        Assert.assertEquals(expectedPrice, listPrice);
        Assert.assertEquals(addingPrice, cartPrice);
    }




}
