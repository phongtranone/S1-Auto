#Author: PhongTran

@login
Feature: Logout site

  @logout
  Scenario: Logout successfully
    Given I am stay Home page
    When I click sign out button
    Then I am navigated to Login page

   