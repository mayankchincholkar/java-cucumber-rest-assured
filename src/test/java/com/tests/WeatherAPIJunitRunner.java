package com.tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",glue={"com.tests.steps"},monochrome = true,publish = true
)
public class WeatherAPIJunitRunner {
}
