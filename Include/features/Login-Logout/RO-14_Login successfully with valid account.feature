#Author: PhongTran

@tag
Feature: Login with valid account

  @login
  Scenario Outline: Login with valid account
    Given I am in Login page
    When I input email "<email>" and password "<pass>"
    And I click Sign in 
    Then Home page is displayed
Examples: 
      | email  | pass |
      |anhphong.tran@codestringers.com|123456|
   