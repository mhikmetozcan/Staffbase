Feature: Submit Application

  Background: User navigates to Job Application page
    Given user is on the "jobDescription" page
    And user clicks on "Accept" button
    And user clicks on "Apply" button


    @sendApplication
    Scenario: Verify the application can be sent
      When user enters "firstName" as "Mustafa Hikmet"
      And user enters "lastName" as "Özcan"
      And user enters "email" as "mhikmetozcan@gmail.com"
      And user enters "phone" as "+49 176 47365154"
      And the resume is attached
      And the cover letter is attached
      And user enters "work permit status" as "full work permit"
      And the privacy notice is confirmed
      And user enters "gitHubRepo" as "github.com/mhikmetozcan"


      @wip
      Scenario: verify dropdown is selected
        And the privacy notice is confirmed