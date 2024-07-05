@desktopPage @regression
Feature: Desktop page test
  In Order to test Desktop page
  As a User I should verify different scenarios in desktop page

  Background: User is on home page
    Given I am on home page

  @sanity
  Scenario Outline: Verify product arrange in order when user select filter
    When I mouse hover on "Desktops" tab and click
    And  I select "Show AllDesktops" option
    And I collect the original "product" list by order
    And I select filter "<filter>"
    Then I should see the products arrange in "<order>" order
    Examples:
  | filter       | order      |
  | Name (A - Z) | ascending  |
  | Name (Z - A) | descending |

  @smoke
  Scenario Outline: Verify that product added to shopping cart successFully
    When I mouse hover on "Currency" tab and click
    And I select currency "£Pound Sterling"
    And I mouse hover on "Desktops" tab and click
    And  I select "Show AllDesktops" option
    And I select filter "Name (A - Z)"
    And I click on the product name "<product>"
    Then I see the product name "<product>" on product page
    When I enter qty "1"
    And I click on AddToCart button
    Then I see the message Success: You have added "<product>" to your shopping cart!
    When I click on shopping cart link display into the success message
    Then I see the text "Shopping Cart" on Shopping cart page
    And I see the product name "<product>"
    And I see the model number "<model>"
    And I see the total price "<price>"

    Examples:
      | product      | model      | price   |
      | HTC Touch HD | Product 1  | £74.73  |
      | iPhone       | product 11 | £75.46  |
      | iPod Classic | product 20 | £74.73  |
      | MacBook      | Product 16 | £368.73 |
      | MacBook Air  | Product 17 | £736.23 |
      | Sony VAIO    | Product 19 | £736.23 |






