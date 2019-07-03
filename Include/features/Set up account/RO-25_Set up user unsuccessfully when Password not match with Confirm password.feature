#Author: 
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario Outline: Title of your scenario outline
  	Given I clink on email
    When I input Password "<password>"
    And I input Confirm Password "<confirmPassword>"
    Then Display error message when Password "<password>" and Confirm Password "<confirmPassword>" not match

    Examples: 
      | password  | confirmPassword | 
      | Gon@123456| gon@123456    | 
  