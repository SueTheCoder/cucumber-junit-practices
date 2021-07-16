@smoke @regression
Feature: Google search functionality
  Agile Story: As a user, when I am on the google search page,
  I should able to search whatever I want, and see relevant information

  Scenario: Search page title verification
    Given User is on google home page
    Then User should see title is Google

    Scenario: User search title verification
    Given User is on google home page
    When User searches for apple
    Then User should see apple in the title

      @wip
    Scenario: User search title verification
    Given User is on google home page
    When User searches for "mango"
    Then User should see "mango" in the title
