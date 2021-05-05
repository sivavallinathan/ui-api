@Testing
Feature: Campus Cash Core Smoke 


Scenario Outline: Hidden credentials of settlement types
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"
 Then Navigate to Settlement configuration
 Then Validate the credentials of the settlement types
Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1560|Hidden credentials of settlement types|Smoke|Siva|chrome|



Scenario Outline: Delete/Deactivate settlement type in in progress state
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"
 Then Validate if the in progress state settlements can be deleted/deactivated 
Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1563|Delete/Deactivate settlement type in in progress state|Smoke|Siva|chrome|


Scenario Outline: Valdiate the Transaction Availability
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"
 Then validate the Transaction availablity section
 
Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1614|Valdiate the Transaction Availability|Smoke|Siva|chrome|