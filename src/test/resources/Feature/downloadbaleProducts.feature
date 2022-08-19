Feature: Downloadable products features
  Background: log in
    Given user is on login page
    When User enter valid username as "admin@yourStore.com"
    And User enter valid password as "123456"
    And Click on Login Button

  Scenario: Downloadable products page
    Given User is in Downloadable products page
    When User should see Downloadable products page

  Scenario: Downloadable product details page
    Given User is in Downloadable products page
    When User should see Downloadable products page
    Then User click on order number link
    Then User should see Downloadable product's order details page

  Scenario: Downloadable product Download
    Given User is in Downloadable products page
    When User should see Downloadable products page
    Then User click on Download link of a downloadable product
    Then The product download should start