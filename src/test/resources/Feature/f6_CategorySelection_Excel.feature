@TestCase6
Feature: Testing different categories selection and moving it to excel

  Scenario Outline: Verify different categories are able to be selected and move them to excel
    Given User navigates to browser
    When User opens the drop-down menu
    When selects the items then writes it to excel sheetName "<sheetName>"

   
   Examples:
   |sheetName|
   |categories|