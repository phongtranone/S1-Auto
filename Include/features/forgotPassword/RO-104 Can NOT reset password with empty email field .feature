#Author: PhongTran

Feature: Forgot Password

  Scenario: Can NOT invite a user with invalid email
    Given I am in Login page
  	And I click on the Forgot link  
    When I input email 'anhphong@yopmail.com'
    And I clear all
	  Then The Continue button is disabled
       
      