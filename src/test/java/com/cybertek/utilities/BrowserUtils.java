package com.cybertek.utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrowserUtils {

    /*
    Method that will accept int  arg
    Wait for given second duration
    //1sec = 1000 milli seconds
    //1 * 1000 = 1000
        Thread.sleep(1000);
        Thread.sleep(2000);
        Thread.sleep(3000);
        BrowserUtils.sleep(1); --> 1 second
     */

    public static void sleep(int second) {

        Driver.getDriver().manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);

    }

    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }

}