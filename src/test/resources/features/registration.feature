@Test @MY_ATF
Feature: Registration

  Background:
    Given I sign in as a generic user

  Scenario: Consistent GOV.UK header and footer, logged in
    Then the Manage Your ATF Homepage should be displayed
    And the page has a consistent GOV.UK header
    And the page has a consistent GOV.UK footer
    When I click Account Activity
    Then the Account Activity Page should be displayed
    And the page has a consistent GOV.UK header
    And the page has a consistent GOV.UK footer
    When I navigate back to the homepage
    And I click Site Management
    Then the Site Management Page should be displayed
    And the page has a consistent GOV.UK header
    And the page has a consistent GOV.UK footer

    Scenario: Register New User




