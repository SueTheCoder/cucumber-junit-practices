
Feature: Library app login feature
  User Story:
  As a user, I should be able to login with correct credentials to different accounts and dashboard should be displayed.
  Accounts are: librarian, student, admin

  Background: Assuming user is on the login page
    Given User is on the login page


  Scenario Outline: Login as librarian
    When User enters username "<username>"
    And User enters password "<password>"
    Then User should see the dashboard
    @librarian
    Examples:
      | username            | password |
      | librarian13@library | 9rf6axdD |
      | librarian14@library | 87x8afWY |
    @student
    Examples:
      | username            | password |
      | student11@library   | tScBPCUr |
      | student12@library   | UC0LC9Hj |


  @showRecords
  Scenario: Login as librarian
    When User enters username "librarian13@library"
    And User enters password "9rf6axdD"
    And User clicks "Users" link
    And User sees to records dropdown value should be "10" by default
    Then User should see the records should have following options:
      | 5   |
      | 10  |
      | 15  |
      | 50  |
      | 100 |
      | 200 |
      | 500 |
    Then User should have following columns in the table:
      | Actions   |
      | User ID   |
      | Full Name |
      | Email     |
      | Group     |
      | Status    |

@all
  Scenario Outline: Login as a different username and password
    When I enter "<username>" and "<password>"
    Then user should see their "<username>" on account section
    Examples:
      | username            | password |
      | librarian14@library | 87x8afWY |
      | librarian15@library | S5Ejblg1 |
      | student18@library   | nK83Q8Be |
      | student14@library   | 6SW236ia |