@Testing
Feature: Campus Cash Core Regression


Scenario Outline: Add Institution - with no settlement type - no UUID
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"
 Then Add institution with no UUID
 Then Evaluation message should be displayed as enter valid UUID
Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1501|Add Institution - with no settlement type - no UUID|Regression|Siva|chrome|


Scenario Outline: Add Institution - with no settlement type - use UUID which already exists in DB
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"
 Then Add Institution - with no settlement type - use UUID which already exists in DB
 Then Evaluation message should be displayed as institution already exists
Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1502|Add Institution - with no settlement type - no UUID|Regression|Siva|chrome|


@aa
Scenario Outline: Add Institution - with no settlement type - settlement run is earlier then 0:30
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"
 Then Add Institution - with no settlement type - run time earlier than 0.30
 Then Evaluation message should be displayed as invalid time
Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1503|Add Institution - with no settlement type - settlement run is earlier then 0:30|Regression|Siva|chrome|


Scenario Outline: Add Institution - with settlement type - active/inactive
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"
 And Navigate to Settlement configuration and to the newly added institution	
 Then Add a working settlement type for the institution 
Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1506|Add Institution - with settlement type - active/inactive |Regression|Siva|chrome|


Scenario Outline: Add Institution - with settlement type - active/inactive
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"
 And Navigate to Settlement configuration and to the newly added institution	
 Then Add a non-working inactive settlement type for the institution  
Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1506|Add Institution - with settlement type - active/inactive|Regression|Siva|chrome|



Scenario Outline:Add Institution - with settlement type - delete empty/filled settlement type
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"
 And Navigate to the settlement configuration page
 Then validate the deletion of particular settlement type
Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1507|Add Institution - with settlement type - delete empty/filled settlement type|Smoke|Siva|chrome|


