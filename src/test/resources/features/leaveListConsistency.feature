@regression @consistency
Feature: Leave list consistency

  Scenario: Applied leave appears in Leave List
    Given User logs into OrangeHRM
    When User applies leave from "2026-01-28" to "2026-01-28"
    Then Leave should appear in Leave List