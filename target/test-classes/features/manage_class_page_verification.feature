Feature: Manage class page verification

  #Background: Logged on the LMS portal as Admin
    #Given admin is on Login page after clicking on Login button on home page
    #When admin enters valid login and password
    #And clicks on login button
    #Then admin navigated to dashboard page
    #Given Admin is on dashboard page after Login
    #When Admin clicks Class button on the navigation bar
    #Given Admin is on Manage Class Page

  Scenario Outline: Verify landing in class page
    Then Admin should see URL with "Manage Class"

    Examples: 
      | Manage Class                              |
      | https://www.lms.com/login/dashboard/class |

  Scenario: Capture the response time to navigate to manage class page
    Then Get the response time for navigation from dashboard page to manage class page

  Scenario: Verify Manage Class Page Header
    Then Admin should see header with Manage Class

  Scenario: Validate text in manage class page
    Then Admin should see correct spelling for the all the fields

  Scenario: Verify delete icon below the header
    Then Admin should see disabled delete icon below the Manage Class

  Scenario: Verify search bar on the class page
    Then Admin should see search bar on the class page

  Scenario: Verify add new class button  on class page
    Then Admin should see +Add New Class button on the class page

  Scenario: Verify data table on the class page
    Then Admin should see data table on the Manage Class Page With following column headers check box batch id classno class date class topic staff id description comments notes recording EditDelete

  Scenario: Verify Edit icon in the data table
    Then Edit Icon in each row of data table only  when entries are available

  Scenario: Verify Edit icon when no data in the table
    Then Edit Icon will not be present in data table

  Scenario: Verify delete icon in the data table
    Then Delete Icon in each row of data table only  when entries are available

  Scenario: Verify delete icon when no data in the table
    Then Admin cant see delete  Icon in data table

  Scenario: Verify sort icon in the data table
    Then Admin should see sort icon near the column headers except for Edit and Delete

  Scenario: Verify check box in the data table
    Then Admin should see check box in the all rows  of data table

  Scenario: Validate the number entries displaying
    Then Admin should see text showing entries

  Scenario: Verify Pagination control below the data table
    Then Admin should see the pagination controls under the data table

  Scenario: Validate footer  text
    Then Admin should see the text with total number classes in the data tabl

  Scenario Outline: Validate search box function
    When Admin enters "<batch id>" into search box
    Then Displays entries for valid values only

    #entering both valid and invalid batch id's
    Examples: 
      | batch id |
      |     7576 |
      |     0000 |

  Scenario Outline: Validate search box function
    When Admin enters "<class no>" into the search box
    Then entries are displayed for valid values only

    #entering both valid and invalid class numbers
    Examples: 
      | class no |
      |        1 |
      |        0 |

  Scenario Outline: Validate search box function
    When Admin enters "<class topic>" in the search box
    Then Displayed entries are for valid values only

    #entering both valid and invalid batch id's
    Examples: 
      | class topic |
      | python      |
      | ruby        |

  Scenario Outline: Validate search box function
    When Admin enters both valid and invalid "<staff id>" into search box
    Then it Displays entries for valid values only

    #entering both valid and invalid batch id's
    Examples: 
      | staff id |
      | U01      |
      | U00      |

  Scenario Outline: Validate search box function
    When Admin enters valid and invalid "<class date>" into search box
    Then Displayed entries  for valid dates only

    #entering both valid and invalid batch id's
    Examples: 
      | class date |
      | 12/22/22   |
      | 22/20/23   |

      