#Author: 
@tag
Feature: Verrify password field

  @tag1
  Scenario Outline: Password lower than minlength or greater than maxlength
  	Given I clink on email
    When I input Password "<password>"
    Then Display error message when Password "<password>" lower than minlength or greater than maxlength

    

    Examples: 
      | password  | 
      |  Sed |   
      |  		Sed ut perspiciatis unde omnis iste natus |

 