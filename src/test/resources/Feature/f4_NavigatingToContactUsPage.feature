@TestCase4
Feature: User will navigate to contact us page

  Scenario: Contact us page verification
    Given Navigate to website
    And Verify the page is correctly navigated
    When Scroll down to the footer 
    And Click on contact us button
    Then Verify the page header is part of contact us page
