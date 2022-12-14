Feature: Login Page Feature

  Scenario: Login page title
    Given user is on login page
    When user gets the title of the page
    Then page title should be "Your store. Login"

  Scenario: Forgot Password link
    Given user is on login page
    Then forgot password link should be displayed

  Scenario: Login with valid credentials
    Given user is on login page
    When User enter valid username as "testuser001@mail.com"
    And User enter valid password as "123456789"
    And Click on Login Button
    Then User should see Home page title as "Your store. Home page title"
