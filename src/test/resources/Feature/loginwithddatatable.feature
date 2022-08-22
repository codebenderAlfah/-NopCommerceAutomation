Feature: Log in with data table
  Scenario: Log in with data table
    Given user is on login page
    When User enter following data:
      |username|password|
      |admin@yourStore.com|123456|
      |testuser001@mail.com|123456789|
    And Click on Login Button
    Then User should see Home page title as "Your store. Home page title"