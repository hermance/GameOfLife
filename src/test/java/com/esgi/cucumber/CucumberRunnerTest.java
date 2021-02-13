package com.esgi.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.esgi.cucumber.features"},
        features = {"src/test/resources/com/esgi/cucumber/features"}
        // /src/test/resources/com.esgi.cucumber.features
)
public class CucumberRunnerTest {
}
