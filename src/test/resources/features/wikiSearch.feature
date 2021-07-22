Feature: Wikipedia Search Functionality
  As a user I should able to search terms and see relevant information
  Case: Search for "Steve Jobs", title, header, and image header should be displayed as "Steve Jobs"

  @wikiSearch1
  Scenario: Wikipedia Search Functionality Title Verification
    Given User is on Wikipedia home page
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" is in the wiki title

  @wikiSearch2
  Scenario Outline: Wikipedia Search Functionality Header Verification
    Given User is on Wikipedia home page
    When User types "<searchValue>" in the wiki search box
    And User clicks wiki search button
    Then User sees "<expectedMainHeader>" is in the main header
    Then User sees "<expectedTitle>" is in the wiki title

    Examples: Search terms we are going to use in the computer
      | searchValue      | expectedMainHeader | expectedTitle    |
      | Steve Jobs       | Steve Jobs         | Steve Jobs       |
      | Albert Einstein  | Albert Einstein    | Albert Einstein  |
      | Elon Musk        | Elon Musk          | Elon Musk        |
      | Nikola Tesla     | Nikola Tesla       | Nikola Tesla     |
      | Conor McGregor   | Conor McGregor     | Conor McGregor   |
      | Chuck Norris     | Chuck Norris       | Chuck Norris     |
      | Marie Curie      | Marie Curie        | Marie Curie      |
      | Natalie Dormer   | Natalie Dormer     | Natalie Dormer   |
      | İbrahim Tatlıses | İbrahim Tatlıses   | İbrahim Tatlıses |

  @wikiSearch3
  Scenario: Wikipedia Search Functionality Image Header Verification
    Given User is on Wikipedia home page
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" is in the image header



