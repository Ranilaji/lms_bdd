
#Background: Admin click +Add new assignment button after reaching to manage assignment pag

Feature: Add new assignment 

Scenario Outline: Validate admin able to add new assignment with valid data in mandatory fields

Given Admin is in  assignment details popup window
When Admin enters all mandatory field values with valid data from "<Sheetname>" and <Rownumber> and clicks save button
Then Admin should see new assignment details is added in the data table
Examples:
 | Sheetname  | Rownumber |
 | Assignment |         1 |

Scenario Outline: Validate admin able to add new assignment with invalid data in mandatory fields
When Admin enters all mandatory field values with invalid data from "<Sheetname>" and <Rownumber> and clicks save button
Then Error message should appear in alert
Examples:
 | Sheetname  | Rownumber |
 | Assignment |         2 |

Scenario Outline: Validate admin able to add new assignment with valid data  in all fields
When Admin enters values in all fields with valid data from "<Sheetname>" and <Rownumber> and clicks save button
Then Admin should see new assignment details is added in the data table
Examples:
 | Sheetname  | Rownumber |
 | Assignment |         3 |

Scenario Outline: Validate admin able to add new assignment with invalid data in optional fields
When Admin enters with invalid data in optional fields from "<Sheetname>" and <Rownumber> and clicks save button
Then Error message should appear in alert
Examples:
 | Sheetname  | Rownumber |
 | Assignment |         4 |

Scenario Outline: Validate admin able to add new assignment missing program name
When Admin enters  data missing value in program name from "<Sheetname>" and <Rownumber> and clicks save button
Then Program Name is missing
Examples:
 | Sheetname  | Rownumber |
 | Assignment |         5 |

Scenario Outline: Validate admin able to add new assignment missing batch number
When Admin enters data missing value in Batch number from "<Sheetname>" and <Rownumber> and clicks save button
Then Batch number is missing
Examples:
 | Sheetname  | Rownumber |
 | Assignment |         6 |

Scenario Outline: Validate admin able to add new assignment missing assignment name
When Admin enters data missing value in Assignment name from "<Sheetname>" and <Rownumber> and clicks save button
Then Assignment name is missing
Examples:
 | Sheetname  | Rownumber |
 | Assignment |         7 |

Scenario Outline: Validate admin able to add new assignment missing due date
When Admin enters data missing value in Assignment due date from "<Sheetname>" and <Rownumber> and clicks save button
Then Assignment due date is missing
Examples:
 | Sheetname  | Rownumber |
 | Assignment |         8 |

Scenario Outline: Validate admin able to add new assignment missing grade by
When Admin enters data missing value in grade by from "<Sheetname>" and <Rownumber> and clicks save button
Then Grade by is missing
Examples:
 | Sheetname  | Rownumber |
 | Assignment |        9 |
 
Scenario Outline: Validate  admin able to add new assignment passing past date
When Admin enters passed date in the due date field from "<Sheetname>" and <Rownumber> and clicks save button
Then Assignment cannot be created for the passed date
Examples:
 | Sheetname  | Rownumber |
 | Assignment |        10 |

Scenario: Validate date picker
When Admin clicks date from date picker
Then selected date should be their in class date text box
@test
Scenario: validate date picker should be correct format
Then selected date should be in  mm/dd/yyyy format

Scenario: Validate right arrow in data picker to navigate to next month
When Admin clicks right arrow in the date picker near month
Then Next month calender should visible

Scenario: Validate left arrow in data picker to navigate to previous month
When Admin clicks left arrow in the date picker near month
Then previous month calender should visible

Scenario: Validate current date is highlighted in the date picker
When Admin clicks date picker button
Then Admin should see current date is highled in the date picker

Scenario: Validate selected date is highlighted in the date picker
When Admin clicks date picker button and selects future date
Then Admin should see selected date is highled in the date picker

Scenario: Validate cancel button function in assignment details popup window
When Admin clicks Cancel button without entering values in the fields
Then Admin should land on manage assignment page

Scenario Outline: Validate cancel button function in assignment details popup window with values in field
When Admin clicks Cancel button entering values in the fields from "<Sheetname>" and <Rownumber> 
Then Admin should land on manage assignment Page and validate new assignment is not created in the data table
Examples:
 | Sheetname  | Rownumber |
 | Assignment |        22 |