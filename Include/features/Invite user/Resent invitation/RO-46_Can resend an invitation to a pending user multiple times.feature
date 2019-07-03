#Author: 

@tag
Feature: Resent invitation

  @tag1
  Scenario Outline: Resend an invitation to a pending System user
    Given I am stay Home page
    When I click resent invitation to email "<email>"
    Then Display successfully message "Invitation sent."

    Examples: 
      | email  |
      | phong.testautomation+3@gmail.com  | 