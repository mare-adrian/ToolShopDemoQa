#Tags for grouping and running tests(can be as many as you want/need)
@All
@Smoke


#This test fails intentionally to exhibit how a failing test is displayed in console and report
Feature: Intentionally failing a test for demonstration purposes

  Scenario: Failing test
    Given i am on the client registration page
    When i click on submit button
    Then i fail test