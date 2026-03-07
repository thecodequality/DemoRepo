@regression @stability
Feature: Leave status persistence

  Scenario: Approved leave status persists after refresh
    Given User logs into OrangeHRM
    When User applies leave from "2026-01-27" to "2026-01-27"
    And Admin approves the leave
    Then Leave status should be "Approved"
    When User refreshes the page
    Then Leave status should still be "Approved"