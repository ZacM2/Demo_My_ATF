@TopUpPFA @MY_ATF
Feature: Top up a PFA

  Background:
    Given I sign in as a generic user
    And I click Account Activity
    And I click on Top Up Account
    And I am navigated to the Top Up Account Page
    When I click the Set up a card payment button

  Scenario: Display the 'Top up by credit or debit card' page
    Then the 'Top up by Card' page is displayed
    And the page has a consistent GOV.UK header
    And the page has a consistent GOV.UK footer
    And the Continue and Cancel links are present

  Scenario: Cancel top up amount entry
    When I click the Cancel link on the confirm top up page
    Then I am navigated to the Top Up Account Page

  Scenario: Enter Top Up Amount and confirm
    When the 'Top up by Card' page is displayed
    And I enter a top amount according to business rules
    When I click the Continue link
    Then the Confirm your top up amount page is displayed
    When I click the 'confirm and continue to set up' button for card top up
    Then I am directed to the CPMS site to make a card payment
    When I cancel the payment on the CPMS page
    Then I am directed to a payment was unsuccessful screen

  Scenario: Cancel confirm top up amount
    When the 'Top up by Card' page is displayed
    And I enter a top amount according to business rules
    When I click the Continue link
    And the Confirm your top up amount page is displayed
    When I click the cancel button on the confirm your top up page
    Then I am navigated to the Top Up Account Page

  Scenario: Display error message: Top Up Amount missing
    When the 'Top up by Card' page is displayed
    When I click the Continue link
    Then a "top up amount missing" error message is shown

  Scenario: Display error message: below minimum top up value
    When the 'Top up by Card' page is displayed
    And I enter a top amount below minimal value
    When I click the Continue link
    Then a "below minimum value" error message is shown

  Scenario: Enter Top Up Amount and complete payment
    When the 'Top up by Card' page is displayed
    And I enter a top amount according to business rules
    When I click the Continue link
    Then the Confirm your top up amount page is displayed
    When I click the 'confirm and continue to set up' button for card top up
    Then I am directed to the CPMS site to make a card payment
    When I enter my card details on the CPMS page
    And I enter my CPMS additional information
    Then the payment confirmation page should be displayed
    When I click Make Payment
    Then the Successful Top Up Screen should be displayed




















