Feature: Create Business Unit

  Scenario:  Create new business unit
    Given user needs to create business unit
    When select button create business unit
    And Enter name "Test 2"
    And select parent unit "test"
    Then after saving you should see the record created