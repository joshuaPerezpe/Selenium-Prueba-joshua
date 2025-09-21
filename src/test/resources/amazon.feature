@amazon
Feature: Test Amazon search product

  @cart
  Scenario Outline:
    Given the user nagivates to www.amazon.com
    And click on Continue Shopping button
    And click on SearchBox
    And searches for <Product>
    And navigates to page number 2
    And selects the third item
    Then the user is able to add it to the cart

    Examples:
      | Product |  |
      | Alexa   |  |
#      | Playstation |