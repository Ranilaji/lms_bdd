#Background: Logged on the LMS portal as Admin
Feature: Manage assignment page Verification

  Scenario: Verify landing in manage assignment page
    Given Admin is on dashboard page after Login
    When Admin clicks assignment button on the navigation bar
    Then Admin should see URL with "Manage assignment"

  Scenario: Capture the response time to navigate to manage assignment page
    Then Get the response time for navigation from dashboard page to manage assignment page

  Scenario: Verify manage assignment page Header
    Then Admin should see header with "Manage assignment"

  Scenario: Validate text in manage assignment page
    When Admin clicks assignment button on the navigation bar and get all text from the portal page
    Then Admin should see correct spelling for all the fields

  Scenario: Verify delete icon below the header
    Then Admin should see disabled delete icon below the Manage assignment

  Scenario: Verify search bar on the manage assignment page
    Then Admin should see search bar on the manage assignment page

  Scenario: Verify add new assignment button  on manage assignment page
    Then Admin should see +Add New assignment button on the manage assignment page

  @edit
  Scenario: Verify Edit icon in the data table
    Given Admin is on dashboard page after Login
    When Admin clicks assignment button on the navigation bar
    Then Edit Icon in each row of data table only  when entries are available

  Scenario: Verify Edit icon when no data in the table
    Then Edit Icon will not be present in data table

  Scenario: Verify delete icon in the data table
    Then Delete Icon in each row of data table only  when entries are available

  Scenario: Verify delete icon when no data in the table
    Then Delete Icon will not be present in data table

  Scenario: Verify sort icon in the data table
    Then Admin should see sort icon near the column headers except for Edit and Delete

  Scenario: Verify check box in the data table
    Then Admin should see check box in the all rows  of data table when entries available

  Scenario: Verify Pagination control below the data table
    Then Admin should see the pagination controls under the data table

  Scenario: Validate footer text
    Then Admin should see the text with total number assignments in the data table "In total there are number of assignments"

## Header Navigation Links

  Scenario: Verify admin is able to navigate from manage assignment to student page
    Given Admin is in manage assignment page
    When Admin clicks Student button in the navigation bar
    Then Admin should able to land on student page

  Scenario: Verify admin is able to navigate from manage assignment to program page
    When Admin clicks Program button in the navigation bar
    Then Admin should able to land on program page

  Scenario: Verify admin is able to navigate from manage assignment to batch page
    When Admin clicks Batch button in the navigation bar
    Then Admin should able to land on batch page

  Scenario: Verify admin is able to navigate from manage assignment to user page
    When Admin clicks User button in the navigation bar
    Then Admin should able to land on user page

  Scenario: Verify admin is able to navigate from manage assignment to assignment page
    When Admin clicks class button in the navigation bar
    Then Admin should able to land on class page

  Scenario: Verify admin is able to navigate from manage assignment to attendance page
    When Admin clicks Attendance button in the navigation bar
    Then Admin should able to land on Attendance page

  Scenario: Admin clicks Logout button in the navigation bar
    When Admin clicks Logout button in the navigation bar
    Then Admin should able to land on login page
