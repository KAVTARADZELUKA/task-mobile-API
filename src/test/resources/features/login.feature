Feature: Notification Permission

  Background:
    Given user denies notification permission
    And user skips the intro

  Scenario Outline: User enters invalid username or password
    When user selects "<language>" language
    And user enters "<username>" as username
    And user enters "<password>" as password
    And user taps on login button
    Then error message should be displayed in "<language>" for username "<username>" and password "<password>"

    Examples:
      | language  | username   | password   |
      | ქართული   | wrongUser  | wrongPass  |
      | English   | fakeUser   | fakePass   |
      | Русский   | abc123     | 123abc     |
      | ქართული   |   | wrongPass  |
      | English   |    | fakePass   |
      | Русский   |      | 123abc     |
      | ქართული   | wrongUser  |   |
      | English   | fakeUser   |    |
      | Русский   | abc123     |      |
      | ქართული   |   |   |