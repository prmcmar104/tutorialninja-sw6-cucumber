@laptopPage @regression
Feature: Laptop and Notebook page
  In Order to test Laptop and Notebook page
  As a User I should verify different scenarios for Laptop and Notebook page

  Background: User is on home page
    Given I am on home page

  @sanity
  Scenario: Verify products price display high to low successfully
    When I mouse hover on "Laptops & Notebooks" tab and click
    And I select "Show AllLaptops & Notebooks" option
    And I collect the original "price" list by order
    And I select filter "Price (High > Low)"
    Then I should see the products arrange in "High to Low" order

  @smoke
  Scenario: User should place the order successfully
    When I mouse hover on "Currency" tab and click
    And I select currency "£Pound Sterling"
    And I mouse hover on "Laptops & Notebooks" tab and click
    And  I select "Show AllLaptops & Notebooks" option
    And I should navigate to laptop and notebook page
    And I select filter "Price (High > Low)"
    And I click on the product name "MacBook"
    Then I see the product name "MacBook" on product page
    And I click on AddToCart button
    Then I see the message Success: You have added "MacBook" to your shopping cart!
    When I click on shopping cart link display into the success message
    Then I see the text "Shopping Cart" on Shopping cart page
    And I see the product name "MacBook"
    When I enter qty "2" on shopping cart page
    And I click on update tab
    Then I see the message "Success: You have modified your shopping cart!" on shopping cart page
    Then I see the total price "£737.45"
    And I click on check out button
    Then I see the text "Checkout" on checkout page
    And I click on guest checkout button
    And I click on continue button on checkout page
    And I fill my personal details with firstName "Prime" lastName "Testing" email "prime123@gmail.com" telephone "07878112233" address "101 Goodstone court" city "Watford" postcode "HA2 6JT" country "United Kingdom" and region "Herefordshire"
    And I click on continue button for guest
    And I add comment "Please send delivery as soon as possible" in text area
    And I check the terms and conditions
    And I click on continue button for payment method
    Then I get a message "Warning: Payment method required!"