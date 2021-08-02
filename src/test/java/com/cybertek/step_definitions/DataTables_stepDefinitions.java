package com.cybertek.step_definitions;

import com.cybertek.pages.DataTables_pages;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataTables_stepDefinitions {

    WebDriver driver = Driver.getDriver();
    DataTables_pages dataTables_pages = new DataTables_pages();

    @Then("user should see below words displayed")
    public void setListOfFruits(Map<String, String> listOfFruits) {
        System.out.println("listOfFruits = " + listOfFruits);
    }

    //==============================================================================================

    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> expectedList) {
        Select select = new Select(dataTables_pages.month);
        List<WebElement> options = select.getOptions();
        Assert.assertEquals(expectedList, BrowserUtils.getElementsText(options));

        /** I created this in the BrowserUtils class
            List<String> actualList = new ArrayList<>();
            for(WebElement each : options){
                actualList.add(each.getText());
            }
            Assert.assertEquals(expectedList, actualList);

         */



    }



}
