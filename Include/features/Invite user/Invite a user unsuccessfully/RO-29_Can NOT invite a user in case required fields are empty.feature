#Author:PhongTran
@tag
Feature: Invite a user unsuccessfully

  @tag1
  Scenario Outline: Can NOT invite a user in case required fields are empty 
    Given I am stay Home page
  	And I click Create user button  	
    When I input First name "<firstName>"
    And I input Last name "<lastName>"
    And I input Email "<email>"
    And I input Role "<role>"
    And I click Invite button
    Then Display error message when First name"<firstName>" or Last name"<lastName>" or Email"<email>" or Role"<role>" equal blank 
   
    
    Examples: 
      | firstName  | lastName | email                  | role |
      | 			     |          |                        |      |
      |   			   | lastname | ro.test@yopmail.com    | Lead |
      | firstName  |          | ro.test@yopmail.com    | Lead |
      | firstName  | lastname |     									 | Lead |
      | firstName  | lastname | ro.test@yopmail.com    |      |