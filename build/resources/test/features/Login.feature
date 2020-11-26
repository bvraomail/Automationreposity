Feature: User can log in account

  @login
  Scenario: User can log in account
    Given the User is on page WMU
    When enters the credentials
      |administrator|realpage|
    Then the user is successfully logged in
