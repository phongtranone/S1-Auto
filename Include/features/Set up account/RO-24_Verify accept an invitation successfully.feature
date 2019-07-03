#Author: 
@tag
Feature: Verify accept an invitation successfully 

Background: 
		Given I am stay Home page
    And I click Create user button
    When I input First name "phong"
    And I input Last name "tran"
    And I input Email "phong.testautomation+3@gmail.com"
    And I input Role "Lead"
    And I click Invite button
    Then Display successfully message "New user has been created and an email has been sent to phong tran at phong.testautomation+3@gmail.com"


  @tag1
  Scenario Outline: Verify accept an invitation successfully 
  	Given I clink on email
    When I input Password "<password>"
    And I input Confirm Password "<confirmPassword>"
    And I click continue button
    Then I am navigated to Login page
    And Display successfully message "Your account is ready"
    And I can log in admin page with Password "<password>" was set up
    Examples: 
      | password  | confirmPassword |
      |132456789  | 132456789|