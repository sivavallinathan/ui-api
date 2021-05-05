  #######################################1632################################################
@Testing
Feature: Campus Cash Core Smoke 

@T
Scenario Outline: View Settlement history
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"
 And User is logged in successfully
 Then User clicks on go button and validates the history features
Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|test|
|TC_1553|View Settlement history|Smoke|Siva|chrome|test|



#Scenario Outline: Settlement History for deleted and inactive accounts
# Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
# And User navigates and enter into Campucash UI"<Browser>"
# And Delete/Deactivate the settlement that is in-progress state
# Then The processing status should be changed to Stopped state
#Examples:
#|TestCaseName|TestCaseDesc|Category|Author|Browser|
#|TC_1555|Settlement history for Deleted/inactive accounts|Smoke|Siva|chrome|


Scenario Outline: View Settlement history-Filtering Processing Status
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"
 And User is logged in successfully
 Then User clicks on go button and validates the history filtering processing status "<Filter>"
Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|Filter|
|TC_1554|View Settlement history-Filtering Processing Status|Smoke|Siva|chrome|Failed|
|TC_1554|View Settlement history-Filtering Processing Status|Smoke|Siva|chrome|being retried|
|TC_1554|View Settlement history-Filtering Processing Status|Smoke|Siva|chrome|In Progress|
|TC_1554|View Settlement history-Filtering Processing Status|Smoke|Siva|chrome|Stopped|
|TC_1554|View Settlement history-Filtering Processing Status|Smoke|Siva|chrome|Successful|



Scenario Outline: Successful Login with Valid Credentials
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"
 Then User is logged in successfully
Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1528|Successful Login with Valid Credentials|Smoke|Siva|chrome|





Scenario Outline: Login with incorrect account
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>" with incorrect account
 Then User Should not be allowed to enter into the application
Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1530|Login with incorrect account|Smoke|Siva|chrome|


