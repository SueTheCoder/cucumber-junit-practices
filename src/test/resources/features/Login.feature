Feature: Library app login feature
  User Story:
  As a user, I should be able to login with correct credentials to different accounts and dashboard should be displayed.
  Accounts are: librarian, student, admin

@librarian @employee
  Scenario: Login as librarian
    Given User is on the login page
    When User enters librarian username
    And User enters librarian password
    Then User should see the dashboard

  @student
  Scenario: Login as student
    Given User is on the login page
    When User enters student username
    And User enters student password
    Then User should see the dashboard

@admin @employee
  Scenario: Login as admin
    Given User is on the login page
    When User enters admin username
    And User enters admin password
    Then User should see the dashboard