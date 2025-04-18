Feature: Sign Up for Newsletter

@Subscribe
Scenario: Sign up for the newsletter
  Given user is on the Login Page "https://demowebshop.tricentis.com/login"
  When user enters username and password
  When the user provides an email
    |Email                |
    |2k21eee65@kiot.ac.in |
  And the user clicks the Subscribe button
  Then the user should  see the subscription confirmation text
  
  
  
  
  @Invalid
Scenario: Sign up with invalid email
  Given user is on the Login Page "https://demowebshop.tricentis.com/login"
  When user enters username and password
    When the user provides an Invalid email
    | Email       | ErrorMessage      |
    | @@2K21EEEE  | Enter valid email |
And the user clicks the Subscribe button
Then the user should see an error message