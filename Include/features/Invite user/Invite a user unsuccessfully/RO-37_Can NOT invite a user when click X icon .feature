#Author: PhongTran
#
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario Outline: Title of your scenario outline
    Given I am stay Home page
  	And I click Create user button  
    When I input First name "<firstName>"
    And I input Last name "<lastName>"
    And I input Email "<email>"
    And I input Role "<role>"
    And I click X button
    Then Form invite is closed and not displayed message Invitation sent

    Examples: 
      | firstName  | lastName | email                  | role |
      | firstName  | lastname | ro.test@yopmail.com    | Lead |