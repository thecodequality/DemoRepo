Feature: Cancel Leave

  @cancel
  Scenario: Cancel leave
    Given User logs into OrangeHRM
    When User applies leave from "2026-01-24" to "2026-01-24"
    And User cancels the leave
    Then Leave status should be "Cancelled"
