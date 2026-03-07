@approve
Feature: Approve Leave

  @regression
  Scenario: Approve leave
    Given User logs into OrangeHRM
    When User applies leave from "2026-01-23" to "2026-01-23"
    And Admin approves the leave
    Then Leave status should be "Approved"
