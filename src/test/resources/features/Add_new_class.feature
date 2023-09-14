Feature: Add New class
Scenario Outline: Validate admin able to add new class with valid data in mandatory fields
Given Admin is in  class detail popup window
When Admin enters all mandatory field values with valid data from excel "<sheetname>" and <rownumber> and clicks save button ( Batch ID , No of Classes, Class Date, Staff Id)
Then Admin should see new class details is added in the data table
Examples: 
|sheetname|rownumber|
|Sheet1|1|