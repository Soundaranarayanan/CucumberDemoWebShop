Feature: Purchasing a Product in DemoWebShop

  @Purchase
  Scenario: Purchasing a product from the store using Excel data
  
  
      Given user is on the Login Page "https://demowebshop.tricentis.com/login"
      When user enters username and password
     When the user clicks on the Computers category and selects Desktops
     And the user clicks on the first desktop product
    And the user clicks the Add to cart button
    And the user navigates to the shopping cart
    And the user agrees to the terms of service
    And the user clicks the Checkout button
    Then the user should see the billing address page and enter details from Excel
