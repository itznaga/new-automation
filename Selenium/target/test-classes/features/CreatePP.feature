Feature: Create PP Functionality

Scenario Outline: TC001 To verify user able to Submit New PP
#Given user launch chrome
#And user maximize the browser
#And user set the Time out
#And user launch UAT Application
#When user navigate to login page
When user login as "<username>"
Then user navigate to "<screen>" PP
#When user adds PP name and adds required services
#Then user submit PP

Examples:
|username|screen|
|xex1234|create|