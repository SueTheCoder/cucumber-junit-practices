package com.cybertek.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/library-report.html",
                "rerun:target/rerun.txt"
        },
        features = "src/test/resources/features",
        glue = "com/cybertek/step_definitions",
        dryRun = false,
        tags = "@adidas"
)

public class AdidasRunner {

}
