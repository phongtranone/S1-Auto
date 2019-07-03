#Author: PhongTran
#Summary
#Input valid values for all fields with email address is 

#Case 1: Active user

#Case 2: Pending user

#Case 3: Suspended user

#ase 4: Expired user

@tag
Feature: Can NOT invite a user with existing email 

  @tag1
  Scenario Outline: Can NOT invite a user with invalid email
    Given I am stay Home page
  	And I click Create user button  
    When I input First name "anhphong"
    And I input Last name "tran"
    And I input Email "<email>"
    And I input Role "Lead"
	  And I click Invite button
	  Then Error message "Someone already uses this email address." is displayed 
    Examples: 
      | email |
      | anhphong.tran@codestringers.com |
  