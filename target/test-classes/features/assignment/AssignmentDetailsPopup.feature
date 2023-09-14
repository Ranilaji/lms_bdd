#Background: Admin logged into LMS portal and clicks assignment button on the navigation bar
Feature: Assignment details Popup window verification

  @addassignmentdetails
  Scenario: Verify Assignment details popup window
    Given Admin is on manage assignment Page
    When Admin click +Add new assignment button
    Then Admin should see a popup  with  heading "Assignment details"

  @addassignmentdetails
  Scenario: Verify input fields in Assignment details popup window
    Then Admin should see input fields Text "Program name", "batch number","Assignment Name", "Assignment Descriptio", "grade by", "Assignment due date", "Assignment File1","Assignment file 2", "Assignment file 3", "Assignment file 4", "Assignment file 5"

  @addassignmentdetails
  Scenario: Verify text box present in Assignment details popup window
    Then textbox should be  present in Assignment details popup window

  @addassignmentdetails
  Scenario: Verify drop down in Batch Number in Assignment details popup window
    Then Admin should see  dropdown option for Batch Number

  @addassignmentdetails
  Scenario: Verify drop down in Program name in Assignment details popup window
    Then Admin should see  dropdown option for Program name

  @addassignmentdetails
  Scenario: Verify calendar icon in Assignment due date  in Assignment details popup window
    Then Admin should see  calendar icon for assignment due date

  @addassignmentdetails
  Scenario: Verify save button is present
    Then Admin should see  save button in the Assignment detail popup window

  @addassignmentdetails
  Scenario: Verify cancel button is present
    Then Admin should see  cancel button in the Assignment detail popup window

  @addassignmentdetails
  Scenario: Verify close button in  Assignment details popup window
    Then Admin should see  close button on the Assignment details popup window
