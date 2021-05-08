Feature: Create meeting

  Scenario:  Create new meeting
    Given user needs to create new meeting
    When select button create meeting
    And Enter meet name "Meet Test"
    And select meet type "General"
    And Enter the start date "07/08/2021"
    And Enter the end date "07/08/2021"
    And Select unit "Test 2"
    Then after saving you should see the new meeting record created