Feature: Login to DemoWebShop Web Application

Background:
  Given user is on the Login Page "https://demowebshop.tricentis.com/login"
  
@ValidCredentials
  Scenario: Login with valid credentials
  When user enters username and password
    Then User should be able to login successfully and new page open

@InValidCredentials
Scenario Outline: Login with Invalid credentials
  When user enters username "<username>" and password "<password>"
  Then User should see an Error Message "<ErrorMessage>"
  
 
  Examples:
    |username            |password|ErrorMessage|
    |2k21eee64@kiot.ac.in|k iot1234|Login was unsuccessful. Please correct the errors and try again.|