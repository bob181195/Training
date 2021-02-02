Feature: Login

Scenario Outline: Login into Telebu Ping application
Given user is able to login into application
Then 	user is able to create group 
And   user is able to send message to added participants <message>
Then  user should logout from the application.

Examples:
|messages|
|sample example|