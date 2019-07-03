#Author: PhongTran

@tag
Feature:Can NOT invite a user with invalid email

  @tag1
  Scenario Outline: Can NOT invite a user with invalid email
    Given I am stay Home page
  	And I click Create user button  
    When I input First name "anhphong"
    And I input Last name "tran"
    And I input Email "<email>"
    And I input Role "Lead"
	  And I click Invite button
	  Then Error message "Please enter a valid email address." is displayed 
    Examples: 
      | email |
      | email |
      | email |
      | email |
      | email |
       
      