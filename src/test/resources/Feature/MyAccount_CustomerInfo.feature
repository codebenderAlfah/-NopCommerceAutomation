Feature: My Account Customer info feature
  Background: Login First
    Given user is on login page
    When User enter valid username as "testuser001@mail.com"
    And User enter valid password as "123456789"
    And Click on Login Button

  Scenario: Verify user can see Customer info
    Given user is on My Account Customer Info page
    Then User should be able to see Customer info

    @Skip
  Scenario Outline: Verify user can edit Customer info with valid data and save
    Given user is on My Account Customer Info page
    When User enter valid data in all fields from sheetname "<sheetname>" and rownumber <rownumber>
    And Click on Save Button

  Examples:
    | sheetname | rownumber |
    | customerinfo | 0 |
