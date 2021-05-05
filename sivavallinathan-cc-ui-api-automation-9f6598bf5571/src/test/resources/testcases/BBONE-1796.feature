@Testing
Feature: Campus Cash Core Regression


Scenario Outline: Add Institution - with settlement type - long strings to every field which possible
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"
 Then Validate Adding Institution with settlement type with long strings to every field which possible

Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1508|Add Institution - with settlement type - long strings to every field which possible|Regression|Siva|chrome|


Scenario Outline: Add Institution-with settlement type-cancel and X button
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"
 Then Add Institution-with settlementtype-cancel and X button

Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1509|Add Institution-with settlement type-cancel and X button|Regression|Siva|chrome|

Scenario Outline: Modify settlement type-1 existing settlement type
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"	
 And Navigate to Settlement configuration and to the newly added institution
 Then Validate that if we could edit the existing settlement type

Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1516|Modify settlement type - 1 existing settlement type|Regression|Siva|chrome|


Scenario Outline:Modify institution 
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"
 Then Validate if there is any possiblity to edit the Institution ID

Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1521|Modify institution |Regression|Siva|chrome|

Scenario Outline:Timezone setting is mandatory when inserting institution 
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"
 Then Validate if the Timezone setting is mandatory when inserting institution

Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1524|Timezone setting is mandatory when inserting institution|Regression|Siva|chrome|

Scenario Outline: Refresh automatic settlements link
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"
 Then Validate the Refresh automatic settlements link

Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1537|Refresh automatic settlements link|Regression|Siva|chrome|

Scenario Outline: Display settlement history for institution
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"
 Then Validate display settlement history for institution

Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1523|Display settlement history for institution|Regression|Siva|chrome|

