Feature: To Test OpenMap WeatherAPI

Scenario: the authorised user can request for weather report
When the user makes the call to fetch weather details using api key "76a23477c5e494e37a8be7f5555faba3" for city "Melbourne"
Then the user gets the response back with status code 200 for city "Melbourne"

Scenario: the unauthorised user cannot request for weather report
When the user makes the call to fetch weather details using api key "76a23477c5e494e37a8be7f5555fincorrect" for city "Melbourne"
Then the user gets the response back with status code 401