@library
Feature: Library app login feature
  User Story:
  As a user, I should be able to login with correct credentials to different accounts and dashboard should be displayed.
  Accounts are: librarian, student, admin

  Background: Assuming user is on the login page
    Given User is on the login page

  @library     @librarian
  Scenario Outline: Login as librarian
    When I enter username "<username>"
    And I enter password "<password>"
    Then I should see the dashboard

    Examples:
      | username            | password |
      | librarian14@library | 87x8afWY |
      | librarian13@library | 9rf6axdD |


  @library      @student
    Scenario Outline: Login as librarian
      When I enter username "<username>"
      And I enter password "<password>"
      Then I should see the dashboard
    Examples:
      | username            | password |
      | student11@library   | tScBPCUr |
      | student12@library   | UC0LC9Hj |


  @showRecords
  Scenario: Login as librarian
    When I enter username "librarian13@library"
    And I enter password "9rf6axdD"
    And I click "Users" link
    And I see to records dropdown value should be "10" by default
    Then I should see the records should have following options:
      | 5   |
      | 10  |
      | 15  |
      | 50  |
      | 100 |
      | 200 |
      | 500 |
    Then I should have following columns in the table:
      | Actions   |
      | User ID   |
      | Full Name |
      | Email     |
      | Group     |
      | Status    |

  @library
  Scenario Outline: Login as a different username and password
    When I enter "<username>" and "<password>"
    Then user should see their "<username>" on account section
    Examples:
      | username            | password |
      | librarian14@library | 87x8afWY |
      | librarian15@library | S5Ejblg1 |
      | student18@library   | nK83Q8Be |
      | student14@library   | 6SW236ia |