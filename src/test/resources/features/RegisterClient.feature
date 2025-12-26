#Tags for grouping and running tests(can be as many as you want/need)
@All
@Regression

Feature: Client registration

  Scenario: Successful client registration
    Given i am on the main page
    When i register a new account
    Then i should be successfully registered
    Then i test all filters
