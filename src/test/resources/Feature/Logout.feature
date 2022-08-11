Feature: Logout Feature
  Background: Login First
    Given user is on login page
    When User enter valid username as "admin@yourStore.com"
    And User enter valid password as "123456"
    And Click on Login Button

  Scenario: Logout from the application
    Given user is logged in to the application and see "Logout" link
    When user clicks on "Logout" link
    Then user should be logged out from the application and see "Login" link