Feature: Examples of Cucumber data table implementations

  @fruits
  Scenario: Something happens
    #Given user does something
  Then user should see below words displayed
    | Apple      | 2lb |
    | Kiwi       | 1lb |
    | Orange     | 1lb |
    | Strawberry | 1lb |
    | Mango      | 1lb |
    | Tomato     | 1lb |

    # to fix pipes order
      # WINDOWS: Ctrl + Alt + L

  @months
  Scenario: User should be able to see all 12 months in months
  dropdown
    Given User is on the dropdowns page of practice tool
    Then User should see below info in month dropdown
      | January |
      | February |
      | March |
      | April |
      | May |
      | June |
      | July |
      | August |
      | September |
      | October |
      | November |
      | December |
