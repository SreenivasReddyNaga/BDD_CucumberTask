@EbayAddToCart
Feature: Add Product to the cart

  Scenario: Adding product to the cart
    Given I Navigate to Ebay HomePage
    When I search for "iPhone"
    And I add it to the cart
    Then "iPhone" should be available in the cart

  Scenario Outline: Adding product to the cart
    Given I Navigate to Ebay HomePage
    When I search for "<product>"
    And I add it to the cart
    Then "<product>" should be available in the cart

    Examples: 
      | product        |
      | Sony           |
      | Samsung Galaxy |