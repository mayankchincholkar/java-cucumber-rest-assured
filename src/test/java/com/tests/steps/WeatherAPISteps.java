package com.tests.steps;

import domain.Clouds;
import domain.WeatherAPIResponse;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class WeatherAPISteps {
    private final RequestSpecification request = RestAssured.given();
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather";
    private Response response;

    @Before
    public void setUpBaseUrl(){
        request.baseUri(BASE_URL);
    }

    @When("the user makes the call to fetch weather details using api key {string} for city {string}")
    public void the_user_makes_the_call_to_fetch_weather_details_using_api_key_for_city(String apiKey, String city) {
        request.queryParam("q",city);
        request.queryParam("appid",apiKey);
        response=request.get();
    }
    @Then("the user gets the response back with status code {int} for city {string}")
    public void the_user_gets_the_response_back_with_status_code(int status,String city) {
        log.info("Body {}",response.getBody().prettyPeek());
        Assert.assertEquals(response.getStatusCode(),status);
        WeatherAPIResponse weatherAPIResponse= response.getBody().as(WeatherAPIResponse.class);
        Assert.assertEquals(weatherAPIResponse.getName(),city);
    }

    @Then("the user gets the response back with status code {int}")
    public void the_user_gets_the_response_back_with_status_code(int status) {
        log.info("Body {}",response.getBody().prettyPeek());
        Assert.assertEquals(response.getStatusCode(),status);
    }
}
