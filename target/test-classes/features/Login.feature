  Feature: Login
    This feature deals with the login functionality of the applications

    Scenario: Login with valid credentials

    Given I navigate to the login page
    And I enter the credentials as follows
      | username            | password |
      | admin@yourstore.com | admin    |
    And I click on the login button
    Then I should see the userform page