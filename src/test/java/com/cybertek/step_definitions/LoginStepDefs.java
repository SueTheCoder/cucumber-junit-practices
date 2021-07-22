package com.cybertek.step_definitions;

import com.cybertek.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginStepDefs {

    WebDriver driver = Driver.getDriver();
    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        System.out.println("User is on the login page");
        driver.get("https://library2.cybertekschool.com/login.html");
    }

    @When("User enters librarian username")
    public void user_enters_librarian_username() {
        System.out.println("User enters librarian username");
        driver.findElement(By.id("inputEmail")).sendKeys("librarian13@library");
    }

    @When("User enters librarian password")
    public void user_enters_librarian_password() {
        System.out.println("User enters librarian password");
        driver.findElement(By.id("inputPassword")).sendKeys("9rf6axdD" + Keys.ENTER);
    }

    @Then("User should see the dashboard")
    public void user_should_see_the_dashboard() {
        System.out.println("User sees the dashboard");
    }

    @When("User enters student username")
    public void userEntersStudentUsername() {
        System.out.println("User enters student username");
        driver.findElement(By.id("inputEmail")).sendKeys("student13@library");
    }

    @And("User enters student password")
    public void userEntersStudentPassword() {
        System.out.println("User enters student password");
        driver.findElement(By.id("inputPassword")).sendKeys("zcVbvUWH" + Keys.ENTER);
    }

    @When("User enters admin username")
    public void userEntersAdminUsername() {
        System.out.println("User enters admin username");
    }

    @And("User enters admin password")
    public void userEntersAdminPassword() {
        System.out.println("User enters admin password");
    }

    @When("User enters {string} username")
    public void user_enters_username(String string) {
        if (string.equalsIgnoreCase("librarian")) {
            System.out.println("User enters librarian username");
            driver.findElement(By.id("inputEmail")).sendKeys("librarian13@library");
        } else if(string.equalsIgnoreCase("student")){
            System.out.println("User enters student username");
            driver.findElement(By.id("inputEmail")).sendKeys("student13@library");
        }
    }

    @When("User enters {string} password")
    public void user_enters_password(String string) {
        if (string.equalsIgnoreCase("librarian")) {
            System.out.println("User enters librarian password");
            driver.findElement(By.id("inputPassword")).sendKeys("9rf6axdD" + Keys.ENTER);
        } else if(string.equalsIgnoreCase("student")){
            System.out.println("User enters student password");
            driver.findElement(By.id("inputPassword")).sendKeys("zcVbvUWH" + Keys.ENTER);
        }
    }


}
