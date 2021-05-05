#######################################1693################################################
@Testing
Feature: Campus Cash Core Smoke 


Scenario Outline: Add new institution 
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"
 Then Navigate to Settlement configuration and Add a new institution
 Then New institution is added successfully
Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1539|Add new institution|Smoke|Siva|chrome|


Scenario Outline: Add new working settlement type 
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"
 And Navigate to Settlement configuration and to the newly added institution	
 Then Add a working settlement type for the institution 
Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1540|Add new working settlement type |Smoke|Siva|chrome|


Scenario Outline: Add new non-working settlement type 
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"
 And Navigate to Settlement configuration and to the newly added institution	
 Then Add a non-working settlement type for the institution 
Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1541|Add new non-working settlement type|Smoke|Siva|chrome|


Scenario Outline: Add new non-working inactive settlement type 
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"
 And Navigate to Settlement configuration and to the newly added institution	
 Then Add a non-working inactive settlement type for the institution 
Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1542|Add new non-working settlement type|Smoke|Siva|chrome|


Scenario Outline: Automatic Settlement
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"	
 Then Validate if the settlement is completed and file is downloded 
Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1543|Add new non-working settlement type|Smoke|Siva|chrome|


Scenario Outline: Edit Settlement type
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"	
 And Navigate to Settlement configuration and to the newly added institution
 Then Validate that if we could edit the existing settlement type
 
Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1545|Edit Settlement type|Smoke|Siva|chrome|

Scenario Outline:Delete Institution
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"
 And Navigate to the settlement configuration page
 Then validate the deletion of particular institution
Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1551|Delete Institution|Smoke|Siva|chrome|





