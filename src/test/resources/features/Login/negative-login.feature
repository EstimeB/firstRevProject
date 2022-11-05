Feature: Login

  Scenario: Login Correct Username Invalid Password
    Given The employee is on the login page
    When The employee types in "g8tor" into the username input
    When The employee types in "chomp" into the password input
    When The employee clicks on the login button
    Then The employee should see an alert saying "Wrong password for User"

  Scenario: Login Invalid Username
    Given The employee is on the login page
    When The employee types in "sicEmDawgs" into the username input
    When The employee types in "natchamps" into the password input
    When The employee clicks on the login button
    Then The employee should see an alert saying "Username not found"