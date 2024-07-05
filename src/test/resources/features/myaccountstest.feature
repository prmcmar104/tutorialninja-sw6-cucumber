@myAccountPage @regression
Feature: My Account Page
  As a user I want to test register functionality

  Background: User is on home page
    Given I am on home page
    When I click on my account link

  @sanity
  Scenario: User should navigate to register page successfully
    And I select "Register" option from my account options
    Then I should navigate to "Register Account" page successfully
    And I see the text "Register Account1"

  @smoke
  Scenario: User should navigate to login page successfully
    And I select "Login" option from my account options
    Then I should navigate to "Returning Customer" page successfully
    And I see the text "Returning Customer1"

  Scenario: User should Register account successfully
    And I select "Register" option from my account options
    And I enter first name "Prime"
    And I enter last name "Testing"
    And I enter email "prime123@gmail.com"
    And I enter telephone "07878112233"
    And I enter password "Prime123"
    And I enter confirm password "Prime123"
    And I select "yes" radio button for subscription
    And I click on privacy policy check box
    And I click on continue button
    Then I see the message "Your Account Has Been Created!"
    When I click on continue button on my account
    And I click on my account link
    And I select "Logout" option from my account options
    Then I should see the text "Account Logout"
    And I click on continue button on my account

  Scenario: User should navigate to login and logout successfully
    And I select "Login" option from my account options
    And I enter email "prime123@gmail.com" on login page
    And I enter password "Prime123" on login page
    And I click on login button
    Then I can see the text "My Account"
    When I click on my account link
    And I select "Logout" option from my account options
    Then I can see the text "Account Logout"
    Then I click on continue button on my account