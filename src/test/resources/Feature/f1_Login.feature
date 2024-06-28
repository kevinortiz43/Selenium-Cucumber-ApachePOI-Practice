@TestCase1
Feature: Negatively test the login functionality

  Scenario Outline: Verifies sign up button is displayed and incorrectly logging in will display error messages
    Given User goes to website
    When User attempts to sign in and provides an invalid '<email>' 
    Then User should verify the error messages is incorrect
   
   	Examples:
   	|email|
   	|1    |
   	|.    |
   	|     |
