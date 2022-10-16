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
      And the "resume" is attached
      And the "cover letter" is attached
      And user enters "work permit status" as "I possess full work permit in Germany"
      And the privacy notice is confirmed
      And user enters "gitHubRepo" as "https://github.com/mhikmetozcan/Staffbase.git"
      And user clicks on "Submit Application" button
      Then the application should be succesfully sent



      Scenario Outline: Verify that compulsory fields need to be filled for applying
        When user enters "<First Name>" "<Last Name>" "<Email>" "<Phone>" "<Resume/CV>" "<GitHubRepo>"
        And the privacy notice is confirmed
        And user clicks on "Submit Application" button
        Then error message should be displayed
        Examples:
          | First Name | Last Name | Email             | Phone     | Resume/CV                | GitHubRepo                 |
          | John       | Doe       | johndoe@gmail.com | 123456789 | John Doe the QA Engineer |                            |
          | John       | Doe       | johndoe@gmail.com | 123456789 |                          | https://github.com/johndoe |
          | John       | Doe       | johndoe@gmail.com |           | John Doe the QA Engineer | https://github.com/johndoe |
          | John       | Doe       |                   | 123456789 | John Doe the QA Engineer | https://github.com/johndoe |
          | John       |           | johndoe@gmail.com | 123456789 | John Doe the QA Engineer | https://github.com/johndoe |
          |            | Doe       | johndoe@gmail.com | 123456789 | John Doe the QA Engineer | https://github.com/johndoe |
