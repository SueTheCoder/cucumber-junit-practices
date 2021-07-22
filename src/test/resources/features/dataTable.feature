Feature: Examples of Cucumber data table implementations


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

@library1
  Scenario: Library login example using data table
    Given user is on the login page of library app
    When user enters username and password as below
    |username|librarian13@library|
    |password|9rf6axdD           |
    Then user should see title is Library
