@topmenu @regression
Feature: Top Menu Test
  As a User I want to validate top menu

  Background: User is on Homepage
    Given I am on home page

  @sanity @smoke
  Scenario Outline: Verify user should navigate to each page successfully
  when user click on each tab
    When I mouse hover on "<menu>" tab and click
    And I select "<option>" option
    Then I should navigate to "<menu>" page successfully
    And I see the text "<menu>"
    Examples:
      | menu                | option                      |
      | Desktops            | Show AllDesktops            |
      | Laptops & Notebooks | Show AllLaptops & Notebooks |
      | Components          | Show AllComponents          |
