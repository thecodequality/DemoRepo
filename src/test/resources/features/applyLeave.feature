@apply
Feature: Apply Leave

  @smoke
  Scenario: Apply leave successfully
    Given User logs into OrangeHRM
    When User applies "Sick Leave" leave from "2026-01-22" to "2026-01-22"
    Then Leave status should be "Pending Approval"
