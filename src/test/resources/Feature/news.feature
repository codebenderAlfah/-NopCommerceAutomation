Feature: News page features
  Scenario: View a News
    Given User is in the Home page
    When User clicks on the News link
    Then User should be in the News page

  Scenario: View a news post
    Given User is in the News page
    When User clicks on the first News post
    Then User should be in the News post page

  Scenario: Comment on a News post
    Given User is in the News post page
    When User fills in the comment form tittle "Hello Nop Commerce"
    And User fills in the comment form text "This is a test comment"
    And User clicks the Add new comment button on news post page
    Then User should see the new comment "Hello Nop Commerce" in the list of comments on the news post page
