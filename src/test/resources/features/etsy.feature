Feature: Etsy Search Feature

  Scenario: Etsy default Title Verification
    Given User is on the Etsy landing page
    Then User should see Etsy title as expected
    #expected: Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone

  @wip
  Scenario: Etsy Search Functionality Title Verification
    Given User is on the Etsy landing page
    When User types "Wooden Spoon" in the search box
    And User clicks search button
    Then User sees "Wooden spoon | Etsy" is in the title