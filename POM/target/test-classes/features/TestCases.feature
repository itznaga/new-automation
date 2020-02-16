Feature: Test Cases


Scenario Outline: TC001 To verify user able to Submit New PP
Given user launch "UAT2" Application
When user login as "<username>"
And user navigate to "<screen>" PP
Then user submits new Product Package
And user logsout of the Application

Examples:
|username|screen|
|va2626|create|

Scenario: TC002 To verify user able to Authorize submitted PP
Given user launch "UAT2" Application
When user login as "va2626"
And user navigate to "create" PP
Then user submits new Product Package
And user logsout of the Application
Given user launch "UAT2" Application
When user login as "va2727"
And user navigate to "Authorize" PP
Then user Authorize submitted Product Package
And user logsout of the Application
