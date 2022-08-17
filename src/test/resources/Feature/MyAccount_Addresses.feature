Feature: My Account Addresses page feature
  Background: Login First
    Given user is on login page
    When User enter valid username as "testuser001@mail.com"
    And User enter valid password as "123456789"
    And Click on Login Button

  Scenario: Add new address
    Given User is on My Account Addresses page
    When user click on Add New Address button
    Then user should see Add New Address page
    When User enter valid addresses
    And User click on Save Address Button
    Then User should be able to see the address in My Account Addresses page


  Scenario: Verify user can see Addresses
    Given User is on My Account Addresses page
    Then User should be able to see the address in My Account Addresses page

  Scenario: Edit address
    Given User is on My Account Addresses page
    When User click on Edit Address Button
    And User should be on Edit Address page
    And User enter valid addresses
    And User click on Save Address Button
    Then User should be able to see the address in My Account Addresses page


  Scenario: Delete address
    Given User is on My Account Addresses page
    When User click on Delete Address Button
    Then User should be able to see the address in My Account Addresses page
