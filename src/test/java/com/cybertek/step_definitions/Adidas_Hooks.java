package com.cybertek.step_definitions;

import com.cybertek.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Adidas_Hooks {

    @After
    public void tearDownScenario(Scenario scenario){

        // taking screenshot
        if(scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        } else {
            Driver.closeDriver();
        }
    }

}
