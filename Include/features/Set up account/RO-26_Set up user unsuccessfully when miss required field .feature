#Author: 
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario Outline: Title of your scenario outline
  	Given I clink on email
    When I input Password "<password>"
    And I input Confirm Password "<confirmPassword>"
    And I click continue button
    Then Display error message when Password "<password>" or Confirm Password "<confirmPassword>" equal blank

    Examples: 
      | password  | confirmPassword | 
      |           |       | 
      |  					| namenamer   | 
      |           | 2     |