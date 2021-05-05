#######################################1739################################################
@Testing
Feature: Campus Cash Core Smoke 


Scenario Outline: Other Browsers Execution
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"
 And User is logged in successfully
 Then User clicks on go button and validates the history features
Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1547|Other Browsers|Smoke|Siva|chrome|
#|TC_1547|Other Browsers|Smoke|Siva|firefox|
#|TC_1547|Other Browsers|Smoke|Siva|ie|


Scenario Outline: Validate Incomplete settlements page
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"
 And Navigate to the incomplete settlements page
 Then Validate the incomplete settlements page
Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1548|Validate Incomplete settlements page|Smoke|Siva|chrome|


Scenario Outline:Search for institution
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"
 And Navigate to the settlement configuration page
 Then Search for institution using the description
Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1549|Search for institution|Smoke|Siva|chrome|


Scenario Outline:Create/Delete/Create Institution
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"
 Then Validate Create/Delete/Create Institution

 
Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1558|Create/Delete/Create Institution|Smoke|Siva|chrome|


Scenario Outline: Edit institution
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"
 Then Navigate to Settlement configuration and Edit institution
 Then Institution is Edited successfully
Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1546|Edit institution|Smoke|Siva|chrome|


