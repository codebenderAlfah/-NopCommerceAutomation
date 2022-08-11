Feature: Registration features
  Scenario: Registration page title
    Given user is in the registration page
    When user get the title of the current page
    Then user should see the registration page title as "Your store. Register"

  Scenario: Registration with valid info
    Given user is in the registration page
    When user enters valid First name
    And user enters valid Last name
    And user enters valid Email
    And user enters valid Password
    And user enters valid Confirm Password
    And user clicks on Register button
    Then user should see the registration success message
    When user clicks continue button
    Then user should see the home page