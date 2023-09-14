@Student
Feature: Student page Verification

  #Background: logged on the LMS portal as Admin
    #Given when user is in login page
    #When The user enter valid "user" and "password"
    #And The user click on login button
    #Then The user redirected to dashboard page

  @TS-1
  Scenario: Validate the title of the page
    When Admin clicks "Student" on the navigation bar
    Then Admin should see the Student details Page Title

  @TS-2
  Scenario: Validate response time from dashboard page to student page
    Then Maximum navigation time in milliseconds, defaults to 30 seconds

  @TS_4
  Scenario: Verify LMS title
    Then Admin should see LMS -Learning management system  as title

  @TS-6
  Scenario: Validate drop down is present in the page
    Then Admin should see search box inside the drop down

  @TS-8
  Scenario: Validate search bar in select batch id drop down

  @TS-9
  Scenario: Validate text spelling student name

  @TS-10
  Scenario: Validate text spelling select batch id

  @TS-11
  Scenario: Validate only numbers inside select batch id
    Then Admin should see only numbers inside batch id drop down

  @TS-12
  Scenario: Validate gray color in student name drop down
    Then Admin should see select student name in gray color

  @TS-14
  Scenario: Validate first drop down label is select student name
    Then Admin should see select student name in first

  @TS-15
  Scenario: Validate second drop down label is select batch id
    Then Admin should see select batch id in second

  @TS-16
  Scenario: Validate scroll down inside student name dropdown
    Then Admin should able to scroll down to select the name

  @TS-17
  Scenario: Validate scroll down inside batch id dropdown
    Then Admin should able to scroll down to select the batch id
