#Author: PhongTran


@tag
Feature: Can NOT invite a user with only space char at first name, last name fields 
  @tag1
  Scenario: Can NOT invite a user with only space char at first name, last name fields 
    Given I am stay Home page
  	And I click Create user button  
    When I input space on First name field
    And I input space on Last name field
    And I input Email "anhphong.tran@codestringers.com"
    And I input Role "Lead"
	  And I click Invite button
	  Then Display error message below First name and Last name
  