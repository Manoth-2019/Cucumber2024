@test
Feature: Adactin Hotel booking the Rooms.

  Background: 
    Given User navigate to the hotel login Page
@First
  Scenario: Login should be success
    And User enter the username as yours "Admin"
    And User enter the password as "admin123"
    When User click login button
    Then the login should be success
@second
  Scenario: Login should be Fail
    And User enter the username as yours "Admin"
    And User enter the password as "admin12"
    When User click login button
    Then the login should be fail
