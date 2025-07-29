Feature: Login Functionality

  Scenario: Valid login with user credentials
    Given User is on login page
    When User enters valid email "user@example.com" and password "user123"
    And User clicks on login button
    Then User should be redirected to the dashboard

  Scenario: Invalid login with wrong credentials
    Given User is on login page
    When User enters invalid email "wrong@example.com" and password "wrongpass"
    And User clicks on login button
    Then Error message should be displayed
