#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@login
Feature: Login with invalid account

Background: 
	Given I am in Login page
  @login
  Scenario Outline: Login with invalid account   
    When I input email "<email>" and password "<pass>"
    And I click Sign in 
    Then Error message "<messeage>" is displayed 

    Examples: 
      | email  | password | messeage  |
      | name1  |     5    | success   |

	@login
  Scenario Outline: Login when miss any required field
    When I input email "<email>" and password "<pass>"
    And I click Sign in 
    Then Error message "<messeage>" is displayed 

    Examples: 
      | email  | password | messeage  |
      | a      |a         | success   |
   