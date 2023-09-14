# Background: Admin logged into LMS portal and clicks assignment button on the navigation bar 

Feature: Edit assignment Validation

Scenario: Verify Edit assignment popup window
Given Admin is in manage assignment page
When Admin clicks Edit button in data table
Then Edit popup window appears with heading Assignment Details

Scenario: Verify values in popup window
When Admin clicks Edit button from one of the row in data table
Then Edit popup window appears with same row values in the all fields

Scenario Outline: Validate admin able to update assignment with valid data in mandatory fields
Given Admin is in  Edit assignment detail popup window
When Admin enters all mandatory field values with valid data from "<Sheetname>" and <Rownumber> and clicks save button
Then Admin should see updated assignment details is added in the data table
Examples:
 | Sheetname  | Rownumber |
 | Assignment |				 13	|

Scenario Outline: Validate admin able to update assignment with invalid data in mandatory fields
When Admin enters all mandatory field values with invalid data from "<Sheetname>" and <Rownumber> and clicks save button
Then Error message should appear in alert
Examples:
 | Sheetname  | Rownumber |
 | Assignment |				 14	|

Scenario Outline: Validate admin able to update assignment with valid data  in all fields
When Admin enters values in all fields with valid data from "<Sheetname>" and <Rownumber> and clicks save button
Then Admin should see updated assignment details is added in the data table
Examples:
 | Sheetname  | Rownumber |
 | Assignment |				 15	|

Scenario Outline: Validate admin able to update assignment with invalid data  in optional fields
When Admin enters with invalid data in optional fields from "<Sheetname>" and <Rownumber> and clicks save button
Then Error message should appear in alert
Examples:
 | Sheetname  | Rownumber |
 | Assignment |				 16	|
 
Scenario Outline: Validate admin able to update assignment missing program name
When Admin enters  data missing value in program name from "<Sheetname>" and <Rownumber> and clicks save button
Then Program Name is missing
Examples:
 | Sheetname  | Rownumber |
 | Assignment |				 17	|

Scenario Outline: Validate admin able to update assignment missing batch number
When Admin enters data missing value in Batch number from "<Sheetname>" and <Rownumber> and clicks save button
Then Batch number is missing
Examples:
 | Sheetname  | Rownumber |
 | Assignment |				 18	|
 
Scenario Outline: Validate admin able to update assignment missing assignment name
When Admin enters data missing value in Assignment name from "<Sheetname>" and <Rownumber> and clicks save button
Then Assignment name is missing
Examples:
 | Sheetname  | Rownumber |
 | Assignment |				 19	|

Scenario Outline: Validate admin able to update assignment missing due date
When Admin enters data missing value in Assignment due date from "<Sheetname>" and <Rownumber> and clicks save button
Then Assignment due date is missing
Examples:
 | Sheetname  | Rownumber |
 | Assignment |				 20	|

Scenario Outline: Validate admin able to update assignment missing grade by
When Admin enters data missing value in grade by from "<Sheetname>" and <Rownumber> and clicks save button
Then Grade by is missing
Examples:
 | Sheetname  | Rownumber |
 | Assignment |				 21	|

Scenario Outline: Validate  admin able to update assignment passing past date
When Admin enters passed date in the due date field from "<Sheetname>" and <Rownumber> and clicks save button
Then Assignment cannot be updated for the passed date
Examples:
 | Sheetname  | Rownumber |
 | Assignment |				 22	|
 
Scenario: Validate cancel button function in assignment details popup window
When Admin clicks Cancel button without entering values in the fields
Then Admin should land on manage assignment page

Scenario: Validate cancel button function in assignment details popup window with values in field
When Admin clicks Cancel button entering values in the fields
Then Admin should land on manage assignment Page and validate new assignment is not created in the data table