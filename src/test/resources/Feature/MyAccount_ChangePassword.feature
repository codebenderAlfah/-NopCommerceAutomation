Feature: My Account Change password feature

  Background: Login First
    Given user is on login page
    When User enter valid username as "testuser001@mail.com"
    And User enter valid password as "123456789"
    And Click on Login Button

  Scenario: Change password
    Given User is in Change password page
    When user see the Change password page
    And User enters old password and new password and confirm password
    And Clicks on Change password button
    Then User should be able to change password successfully