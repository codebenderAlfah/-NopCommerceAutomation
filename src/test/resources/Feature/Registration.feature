Feature: Registration features
  Scenario: Registration page title
    Given user is in the registration page
    When user get the title of the current page
    Then user should see the registration page title as "Your store. Register"

  Scenario Outline: Registration with valid info from excel
    Given user is in the registration page
    When user enters valid info from given sheetname "<sheetname>" and rownumber <rownumber>
    When user clicks on Register button
    Then user should see the registration success message
    When user clicks continue button
    Then user should see the home page

  Examples:
    | sheetname | rownumber |
    | registrationinfo | 0 |
    | registrationinfo | 1 |
    | registrationinfo | 2 |
    | registrationinfo | 3 |
    | registrationinfo | 4 |