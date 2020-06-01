@Manage_Direct_Debit @MY_ATF
Feature: Manage Direct Debit

  Background:
    Given I sign in as a generic user
    And I click Account Activity
    And I click on Top Up Account

  @CVSB-8612
  Scenario: Navigate to the Set up a direct debit page
    When I click the Set up a direct debit button
    Then the 'Set up a direct debit' page should be displayed
    And the page has a consistent GOV.UK header
    And the page has a consistent GOV.UK footer
    And the page shows the heading, sub heading and helpful information
    And that page shows the field and text allowing me to specify the sum I want to top up
    And that page shows the fields and text allowing me to specify the date I want to top up

  @CVSB-8612
  Scenario: Enter the top up Sum
    When I click the Set up a direct debit button
    Then the 'Set up a direct debit' page should be displayed
    And I have input a top up amount that is within business rules

  @CVSB-8612
  Scenario: Choose the Date
    When I click the Set up a direct debit button
    Then the 'Set up a direct debit' page should be displayed
    And that page shows the fields and text allowing me to specify the date I want to top up

  @CVSB-8612
  Scenario: Display error message, no date(s) selected
    When I click the Set up a direct debit button
    When I have input a top up amount that is within business rules
    And I click the 'continue' button on the set up a direct debit page
    Then I am presented with a no dates specified error message

  @CVSB-8612
  Scenario: Display error message, no sum specified
    When I click the Set up a direct debit button
    And I have selected a random direct debit date
    When I click the 'continue' button on the set up a direct debit page
    Then I am presented with a no sum specified error message

  @CVSB-8612
  Scenario: Display error Message, below minimum top up value
    When I click the Set up a direct debit button
    And I have selected a random direct debit date
    And I have input a top up amount that is less than the minimum amount
    When I click the 'continue' button on the set up a direct debit page
    Then I am presented with a below minimum top up value error message

  @CVSB-8612
  Scenario: Display error message, no selections made
    When I click the Set up a direct debit button
    And I click the 'continue' button on the set up a direct debit page
    Then I am presented with a no selections made error message

  @CVSB-8612
  Scenario: Navigate to Review Direct Debit Details page
    When I click the Set up a direct debit button
    And I have selected a random direct debit date
    And I have input a top up amount that is within business rules
    And I click the 'continue' button on the set up a direct debit page
    Then I am directed to the 'Confirm your direct debit' page
    And The Direct Debit Amount is displayed correctly
    And The Direct Debit Date is displayed correctly

  @CVSB-8612
  Scenario: Navigate to Review Direct Debit Details page
    When I click the Set up a direct debit button
    And I have selected a random direct debit date
    And I have input a top up amount that is within business rules
    And I click the 'continue' button on the set up a direct debit page
    Then I am directed to the 'Confirm your direct debit' page
    When I click the cancel link on the confirm direct debit page
    Then the Account Activity Page should be displayed

  @CVSB-8612
  Scenario: Change sum information before submission
    When I click the Set up a direct debit button
    And I have selected a random direct debit date
    And I have input a top up amount that is within business rules
    And I click the 'continue' button on the set up a direct debit page
    Then I am directed to the 'Confirm your direct debit' page
    When I click the change sum button
    Then the 'Set up a direct debit' page should be displayed
    And my previous amount selection is pre-populated
    And my previous date selection is pre-populated

  @CVSB-8612
  Scenario: Change date information before submission
    When I click the Set up a direct debit button
    And I have selected a random direct debit date
    And I have input a top up amount that is within business rules
    And I click the 'continue' button on the set up a direct debit page
    Then I am directed to the 'Confirm your direct debit' page
    When I click the change date button
    Then the 'Set up a direct debit' page should be displayed
    And my previous amount selection is pre-populated
    And my previous date selection is pre-populated

  @CVSB-8612
  Scenario: Confirm DD & navigate to CPMS/Go Cardless
    When I click the Set up a direct debit button
    And I have selected a random direct debit date
    And I have input a top up amount that is within business rules
    And I click the 'continue' button on the set up a direct debit page
    And I am directed to the 'Confirm your direct debit' page
    When I click the confirm and continue to set up button
    Then I am directed to the Go Cardless portal to finalise my direct debit set up
    When I enter my go cardless payment details
    Then the direct debit payment confirmation page is displayed
    When I click confirm on the direct debit payment confirmation page
    Then the Direct Debit request received page is displayed

  @CVSB-9231
  Scenario: Change DD & navigate to CPMS/Go Cardless
    When I click the change direct debit button on the Top up Account Page
    And I am navigated to the change your direct debit page
    And I click the confirm and change direct debit button
    And I have input a top up amount that is within business rules
    And I click the 'continue' button on the change your direct debit page
    And I am directed to the 'Confirm your direct debit' page
    When I click the confirm and continue to set up button
    Then I am directed to the Go Cardless portal to finalise my direct debit set up
    When I enter my go cardless payment details
    Then the direct debit payment confirmation page is displayed
    When I click confirm on the direct debit payment confirmation page
    Then the Direct Debit request received page is displayed

  @CVSB-9310
  Scenario: Cancel Direct Debit
    When I click the cancel direct debit button on the Top up Account Page
    Then the Remove Direct Debit Page should be displayed
    When I click the confirm and continue link on the Remove Direct Debit Page
    Then the Account Activity Page should be displayed
    And there is a message to say the direct debit has been removed







