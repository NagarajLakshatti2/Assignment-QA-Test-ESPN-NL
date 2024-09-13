@testsuite1 @seasonView
Feature: Find the matches Live Cricket Scores

  Background: Launch espncricinfo application
    Given Launch espncricinfo application

#    The scenario searches for the country and also implements SoftAssert when more than one validation is needed.
  @softAssert
  Scenario: TC_ESP_0003 Find matches by clicking on the Season View drop down option within the Live Cricket Scores menu and search valid country name
    Given Navigate to the live scores menu option
    When Tap on the drop-down list of items labeled season view
    Then Tap on the search icon after enter the country 'India' in the search match field
    And Verify match details

#    The scenario searches for the Invalid country name and HardAssert Implemented
  @HardAsser
  Scenario: TC_ESP_0011 Find matches by clicking on the Season View drop down option within the Live Cricket Scores menu and validating the invalid search context as No matches found for this season.
    Given Navigate to the live scores menu option
    When Tap on the drop-down list of items labeled season view
    Then Tap on the search icon after enter the country 'InValid test data' in the search match field
    And Validate invalid match text as no matches found for this season