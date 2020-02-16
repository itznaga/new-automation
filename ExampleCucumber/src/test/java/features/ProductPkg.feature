Feature: Product Pkg 

Background: 
Given user open "chrome" and launch "UAT2"

@TestScenario1
Scenario Outline:Verify user able to submit PP
Given user logs in as "ama4002"
When user navigates to Product Package "create"
And user enters "<ppName>" and adds service from "./data/services.xlsx" and submit PP
And user logs out of application
Examples:
|ppName|
|Naga Example16|

@TestScenario2
Scenario Outline:Verify user able to submit PP
Given user logs in as "ama4002"
When user navigates to Product Package "create"
And user enters "<ppName>" and adds service from "./data/services.xlsx" and submit PP
And user logs out of application
Examples:
|ppName|
|Naga Example16|
