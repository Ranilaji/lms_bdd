Feature: Pagination in manage class

  #Background: Logged on the LMS portal as Admin
    #Given Admin is on dashboard page after Login
    #When Admin clicks Class button on the navigation bar

  Scenario: Verify  right arrow is enable when sheet one is displayed in data table
    Then Right arrow should be enabled in page one  when entries are more than five available

  Scenario: Verify  left arrow is disabled when sheet one is displayed in data table
    Then Left arrow should be disabled in page one  when entries are more than five available

  Scenario: Verify  right arrow is enable when sheet two is displayed in data table when entries are more than ten
    Then Right arrow should be enabled in page two when entries are more than ten available

  Scenario: Verify  left arrow is enable when sheet two is displayed in data table
    Then Left arrow should be enabled in page two

  Scenario: Verify  right arrow is disable when sheet two is displayed in data table when entries are less than ten
    Then Data table should display  page one  when entries available

  Scenario: Verify pagination controls enabled
    Then pagination controls should be enabled when entries are more than five in data table

  Scenario: Verify pagination controls disabled
    Then pagination controls should be disabled when entries are less than five in data table