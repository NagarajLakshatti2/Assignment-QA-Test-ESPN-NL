@seasonView2
Feature: Find the matches Live Cricket Scores

  Background: Launch espncricinfo application
    Given Launch espncricinfo application

  Scenario: Find matches by clicking on the Season View drop down option within the Live Cricket Scores menu duplicate
    Given Navigate to the live scores menu option
    When Tap on the drop-down list of items labeled season view
    Then Tap on the search icon after enter the country 'India' in the search match field
    And Verify match details