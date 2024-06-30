Feature:
  Scenario:
    Given User launchs chrome browser
    When User opens URL "http://localhost:8180/auth/realms/scrumwise/protocol/openid-connect/auth?client_id=scrumwise-angular&redirect_uri=http%3A%2F%2Flocalhost%3A4200%2F&state=07ea4147-88a2-4834-866e-4f00eb52a88c&response_mode=fragment&response_type=code&scope=openid&nonce=9e503fd1-d59b-4a73-837a-a61ef245b3fb"
    And User enters Email as "mehdi.njema@ensi-uma.tn" and Password as "talan"
    And Click on Login
    Then Title should be "ScrumWise"
    When User clicks on Add new user button
    And User enters customer info
    And Click on save button
    Then User can see the home page again
    And I close browser

