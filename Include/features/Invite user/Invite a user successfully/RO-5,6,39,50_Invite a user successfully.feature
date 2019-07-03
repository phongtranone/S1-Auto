#Author: PhongTran
# This Scenario cover cases:RO-6 Can invite a user with max length allow all fields
#														RO-5 Can invite a user with valid values at first name and last name
#														RO-39 Can Invite a user with valid email
#														RO-50 Can invite a user with a role
@tag
Feature: Invite a user successfully

  @tag1
  Scenario Outline: Invite a user successfully
    Given I am stay Home page
    And I click Create user button
    When I input First name "<firstName>"
    And I input Last name "<lastName>"
    And I input Email "<email>"
    And I input Role "<role>"
    And I click Invite button
    Then Display successfully message "New user has been created and an email has been sent to <firstName> <lastName> at <email>"

    Examples: 
      | firstName  | lastName | email                  | role |
      | phong			     |    anh tran      |     phong.testautomation@gmail.com                  |  Lead    |
     