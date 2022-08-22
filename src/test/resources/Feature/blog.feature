Feature: Blog page features
  Scenario: View a Blog
    Given User is in the Home page
    When User clicks on the Blog link
    Then User should be in the Blog page

  Scenario: View a Blog post
    Given User is in the Blog page
    When User clicks on the first Blog post
    Then User should be in the Blog post page

  Scenario: Comment on a Blog post
    Given User is in the Blog post page
    When User fills in the comment form "Hello Nop Commerce"
    And User clicks the Add new comment button
    Then User should see the new comment "Hello Nop Commerce" in the list of comments
