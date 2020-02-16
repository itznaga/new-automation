Feature: As a user i need to do validations for ONP Notifications 

@TestScenario1
Scenario Outline:Verify user able to access all 16 ONP Notification service Events for BV Product Type
Given user generates "QA" Authentication code to access API
#When user performs ONP post request for "<eventName>" with headers "<trackingID>" and body "./bodyLocation" with product type as "BV" and the URI is "https"
#Then user verifies status code is "200" and message is "success" in the response
Examples:
|eventName|trackingID|
|INSTANTIATE_Design|tr1313|

@TestScenario2
Scenario Outline:Verify user able to perform Contractual Validations for 16 ONP Notification service Events for BV Product Type
Given user generates "QA" Authentication code
When user performs ONP post request for "<eventName>" with headers "<trackingID>" and  wrong body "./bodyLocation" with product type as "BV" and the URI is "https"
Then user validates the response body matches with the expected body "./Location" and the status code is "400"
And user performs ONP post request without "<eventName>" with headers "<trackingID>" and correct body "./bodyLocation" with product type as "BV" and the URI is "https"
Then user validates the response body matches with the expected body "./Location" and the status code is "400"
And user performs ONP post request for "<eventName>" with wrong headers "<trackingID>" and body "./bodyLocation" with product type as "BV" and the URI is "https"
Then user validates the response body matches with the expected body "./Location" and the status code is "400"
Examples:
|eventName|trackingID|
|INSTANTIATE_Design|tr1313|

@TestScenario3
Scenario Outline:Verify user able to perform Kibana Log Validations for 16 ONP Notification service Events for BV Product Type
Given user launched chrome and accessed Kibana
When user enters "<trackingID>" to search for logs 
And user verifies downstream endpoint for ONP Events is ""
Then user verifies "<eventName>" matches in Kibana Logs
Examples:
|eventName|trackingID|
|INSTANTIATE_Design|tr1313|
