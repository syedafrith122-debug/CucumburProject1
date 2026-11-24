Feature: To validate login functionality ofplumdeluxe app

  Scenario: Verify that user can login with valid username and validpassword
    When  user has to click the account button
    When User has to enter the valid email and vaild password
    And User has to click the sign in button
    
    
  Scenario Outline: Verify that user can login with valid username and invalidpassword
  
    When  user has to click the account button
    When User has to enter the valid "<email>" and invaild "<password>"
    And User has to click the sign in button
    
 Examples:
          |email |password|
          |chelsi|87633|
          |farha |09876|
          
    
