@demo
Feature: book cart login and addtoCart
@cleanup
  Scenario Outline: check the different login users
   
    Given Users enter the "<username>" and "<password>"
    When Users click the login button
    And Users Search the "<Book>"
    And add to the cart in book
    Then Users check the validation the book is add to cart or not

    Examples: 
      | username | password    | Book            |
      | jhonwick | Jhonwick@19 | The Simple Wild |
      | batman   | Batman@1    | Catching Fire   |
