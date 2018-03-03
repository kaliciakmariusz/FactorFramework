Feature: LoginFeature
  This features test login process

  Background:
    Given I make sure the application has been opened on Home page
    And I click on "Zaloguj się" in menu on Home page

  Scenario Outline: Check Login with correct username and password
    When I enter <correct-userName> and <correct-password>
    And I click button "Zaloguj"
    Then I should see <correct-userName> in menu on Dashboard page

    Examples:
      | correct-userName              | correct-password |
      | factor.fakturowania@gmail.com | fakturownia      |


  Scenario Outline: Check Login with incorrect username or incorrect password or both
    When I enter <userName> and <password>
    And I click button "Zaloguj"
    Then I should see <contentsError> on Login page

    Examples:
      | userName                      | password        | contentsError     |
      | testBadLogin                  | fakturownia     | nie jest poprawny |
      | factor.fakturowania@gmail.com | testBadPassword | nie jest poprawne |
      | testBadLogin                  | testBadPassword | nie jest poprawny |