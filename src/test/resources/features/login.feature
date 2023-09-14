Feature: Login page verification

  Background: Admin gives the correct LMS portal URL
    Given Admin is in home page
    When Admin clicks Login button should see "Login successfull" message

  Scenario: Verify admin is able to land on home page
    Then Admin should land on the home page

  Scenario: Verify tht header of the login page
    Then Admin should see "Please login to LMS application" in the header

  Scenario: Verify text field is present
    #Then Admin should see two text field

  Scenario: Verify the text spelling in login page
    Then Admin should see correct spellings in all fields

  Scenario: Verify text on the first text field
    Then Admin should "user" in the first text field

  Scenario: Verify text on the second text field
    Then Admin should "password" in the second text field

  Scenario: Verify asterik next to password text
    Then Admin should see * symbol next to password text

  Scenario: Verify asterik next to user text
    Then Admin should see * symbol next to user text

  Scenario Outline: Validate login with valid credentials
    Given Admin is in login page
    When Admin enter valid credentials  and clicks login button
    Then Admin should land on dashboard page

    Examples: 
      | username | password |
      | admin    | admin123 |

  Scenario: verify login button action through mouse
    Given Admin is in login page
    #When Admin enter valid credentials and clicks login button through mouse
    Then Admin should land on dashboard page