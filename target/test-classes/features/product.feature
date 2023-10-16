Feature: buying a product

  Scenario: add to cart
    Given I am on the product page
    When I order a product
    Then it is added to the cart
