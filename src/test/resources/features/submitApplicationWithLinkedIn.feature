@wip
Feature: Submitting application with LinkedIn

  Background: User navigates to Job Application page
    Given user is on the "jobDescription" page
    And user clicks on "Accept" button
    And user clicks on "Apply" button
    And user clicks on "Apply With LinkedIn" button
    And user enters LinkedIn "username"
    And user enters LinkedIn "password"
    And user clicks on "sign in" button
  #  And user clicks on "allow" button


  Scenario: First Name is filled
    Then User verifies "firstName" is filled

  Scenario: Last Name is filled
    Then User verifies "lastName" is filled

  Scenario: Email is filled
    Then User verifies "email" is filled

  Scenario: Phone is filled
    Then User verifies "phone" is filled

  Scenario: Resume is filled
    Then User verifies "resume" is filled