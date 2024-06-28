@TestCase5
Feature: Negatively test the login functionality

  Scenario Outline: Verifies sign up button is displayed and incorrectly logging in will display error messages
    Given User goes to website
    When User attempts to sign in and provides an email  from given sheetname "<SheetName>" and rowNumber <RowNumber>
    Then User should verify the error messages is incorrect
    
    
    Examples:
    |SheetName|RowNumber|
    |login|0|
    |login|1|
    |login|2|
    |login|3|
    |login|4|
    |login|5|
    |login|6|
