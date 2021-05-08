Feature: Login Test

Scenario: Test login with valid data

Given User launch testmeapp on chrome browser
When User navigates to login screen
When User enters login credentials like username and password
And User clicks on login button
Then User verify login success
And User close the browser