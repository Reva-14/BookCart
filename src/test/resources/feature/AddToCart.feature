Feature: Add to Cart Functionality

Background: User Launches The Application
Given User Launches Bookcart Application "https://bookcart.azurewebsites.net/"

  Scenario: Search and Add Product To The Cart
    When User Searches "The Chosen" Book In The Search Bar 
    And User Clicks On The Product From Search Results
    And User Clicks On Add To Cart 
    Then The Product Should Be Added To The Cart and Should Display Correct Product "The Chosen"

  Scenario: Verify Cart After Adding Multiple Books
    When User Adds "The Chosen" Book To The Cart
    And User Adds "Slayer" Book To The Cart
    And User Views The Cart
    Then The Cart Should Contain Both The Books "The Chosen" "Slayer"
    And The Quantity Of The Books are Verified
    And The Total Price Should Be The Sum Of Individual Prices Of The Books
    
    @tag
  Scenario: Verify Cart Persistance After Page Refresh
    When User Adds "Slayer" Book To The Cart
    And User Refreshes The Application
    And User Views The Cart
    Then The Cart Should Still Contain The Book In The Cart "Slayer"
    
  Scenario: Remove A Book From The Cart
   When User Adds "The Chosen" Book To The Cart
    And User Adds "Slayer" Book To The Cart
    And User Views The Cart
   Then The Cart Should Contain Both The Books "The Chosen" "Slayer"
   When User removes "The Chosen" Book From The Cart
    And User Refreshes The Application
   Then The Cart Should Contain Only "Slayer" Book
   
  Scenario: Update Quantity Of A Book In The Cart
   When User Adds "Slayer" Book To The Cart With Quantity 1
    And User Views The Cart
    And User Changes The Quantity Of The Book To 2 In The Cart
    And User Refreshes The Application
   Then The Cart Should Update To Show 2 Quantity Of The Book
    And The Total Price Should Reflect The Updated Quantity
  
  

    
