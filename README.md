Discount charging app for purpose of recrutment process
=======================================================


DESCRIPTION
-----------

This is an application capable to charge discount proportionately to product prise. Input should be a product list and total discount value.
In real life price of product shouldn't be an integer value, but one of conditions od this task was to leave for last product in basket rest of discount amount.
All the components test using Spock framework. Data validation.

Example test cases (total discount 500):
---------------------------------------
| laptopPrice | headphonesPrice | keyboardPrice | mousePrice | laptopDisc | headphonesDisc | keyboardDisc | mouseDisc |
|-------------|-----------------|---------------|------------|------------|----------------|--------------|-----------|
| 3500        | 500             | 500           | 500        | 350        | 50             | 50           | 50        |
| 1500        | 500             | 200           | 300        | 300        | 100            | 40           | 60        |
| 1000        | 100             | 200           | 200        | 333        | 33             | 66           | 68        |

Technologies
------------
- Java 15
- Spock

How to run
----------
*Clone project
*Run "gradle clean test"