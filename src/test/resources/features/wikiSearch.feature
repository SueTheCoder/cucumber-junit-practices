Feature: Wikipedia Search Functionality
  As a user I should able to search terms and see relevant information
  Case: Search for "Steve Jobs", title, header, and image header should be displayed as "Steve Jobs"


  Scenario: Wikipedia Search Functionality Title Verification
    Given User is on Wikipedia home page
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" is in the wiki title