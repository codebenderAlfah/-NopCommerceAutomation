Feature: Apply for vendor features
  Background: Login first
    Given user is on login page
    When User enter valid username as "testusers5@mail.com"
    And User enter valid password as "123456"
    And Click on Login Button

  Scenario: Apply for vendor Page
    Given User is on the home page
    When User clicks on the Apply for vendor link
    And User should be on the Apply for vendor page

  Scenario: Apply for vendor
    Given User is on the Apply for vendor page
    When User fill in Valid Vendor Name
    And User click on Submit button
    And I should see a success message